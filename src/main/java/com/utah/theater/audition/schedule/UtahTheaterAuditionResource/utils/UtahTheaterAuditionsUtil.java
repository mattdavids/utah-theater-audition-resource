package com.utah.theater.audition.schedule.UtahTheaterAuditionResource.utils;

import com.utah.theater.audition.schedule.UtahTheaterAuditionResource.pojo.Show;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalField;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtahTheaterAuditionsUtil {

    public List<Show> scrapeAuditions() throws IOException, ParseException {
        List<Show> shows = new ArrayList<>();
        List<Show> empressShows = scrapeEmpressAuditionsPage();
        return shows;
    }

    private List<Show> scrapeEmpressAuditionsPage() throws IOException, ParseException {
        Show show = new Show();
        Document doc = Jsoup.connect("https://www.empresstheatre.com/audition").get();
        Elements showAndDirectors = doc.select("#comp-kpgh6afv > p:nth-child(3)");
        Element showAndDirector = showAndDirectors.get(0);
        String showAndDirectorText = showAndDirector.text();
        String[] showAndDirectorSplit = showAndDirectorText.split(" directed by ");
        show.setDirector(showAndDirectorSplit[1]);
        String showName = showAndDirectorSplit[0];
        if (showName.endsWith(",”")) {
            showName = showName.replaceAll(",”", "");
            showName = showName.replaceAll("“", "");
            if (showName.endsWith(",")) {
                showName = showName.substring(0, showName.length() - 1);
            }
        }
        show.setName(showName);
        Elements elements = doc.select("#comp-kpgh6afv > p");
        for (Element element : elements) {
            String text = element.text();
            if (text.contains("Individuals interested in auditioning should submit a virtual audition no later than")) {
                String[] split = text.split("Individuals interested in auditioning should submit a virtual audition no later than ");
                String auditionDate = split[1];
                show.setAudition(parseWordyDate(auditionDate));
            }
            if (text.contains("PRODUCTION SCHEDULE")) {
                Pattern p = Pattern.compile(": (\\w+ \\d{1,2}, \\d{4})");
                Matcher m = p.matcher(text);
                List<String> dates = new ArrayList<>();
                while (m.find()) {
                    dates.add(m.group(1));
                }
                System.out.println("here");;
            }
        }
        return null;
    }

    private Instant parseWordyDate(String wordyDate) {
        Map<Long, String> ordinalNumbers = new HashMap<>(42);
        ordinalNumbers.put(1L, "1st");
        ordinalNumbers.put(2L, "2nd");
        ordinalNumbers.put(3L, "3rd");
        ordinalNumbers.put(21L, "21st");
        ordinalNumbers.put(22L, "22nd");
        ordinalNumbers.put(23L, "23rd");
        ordinalNumbers.put(31L, "31st");
        for (long d = 1; d <= 31; d++) {
            ordinalNumbers.putIfAbsent(d, "" + d + "th");
        }
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("MMMM ")
                .appendText(ChronoField.DAY_OF_MONTH, ordinalNumbers)
                .appendPattern(", yyyy 'at' h:m a")
                .toFormatter().withLocale(Locale.ENGLISH);
        LocalDateTime parsed = LocalDateTime.parse(wordyDate, formatter);
        ZoneId zone = ZoneId.of("-07:00");
        return parsed.toInstant(zone.getRules().getOffset(LocalDateTime.now()));
    }

}
