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
import java.util.ArrayList;
import java.util.List;

public class UtahTheaterAuditionsUtil {

    public List<Show> scrapeAuditions() throws IOException, ParseException {
        List<Show> shows = new ArrayList<>();
        List<Show> empressShows = scrapeEmpressAuditionsPage();
        return shows;
    }

    private List<Show> scrapeEmpressAuditionsPage() throws IOException, ParseException {
        Show show = new Show();
        SimpleDateFormat auditionDateFormat = new SimpleDateFormat("M d, yyyy 'at' hh:mm a");
        Document doc = Jsoup.connect("https://www.empresstheatre.com/audition").get();
        Elements showAndDirectors = doc.select("#comp-kpgh6afv > p:nth-child(3)");
        Element showAndDirector = showAndDirectors.get(0);
        String showAndDirectorText = showAndDirector.text();
        show.setDirector(showAndDirectorText.split("directed by ")[1]);
        show.setName(showAndDirectorText.split(",\"")[0]);
        Elements elements = doc.select("#comp-kpgh6afv > p");
        for (Element element : elements) {
            String text = element.text();
            if (text.contains("Individuals interested in auditioning should submit a virtual audition no later than")) {
                String[] split = text.split("Individuals interested in auditioning should submit a virtual audition no later than ");
                String auditionDate = split[1];
                show.setAudition(auditionDateFormat.parse(auditionDate));
            }
        }
        return null;
    }

}
