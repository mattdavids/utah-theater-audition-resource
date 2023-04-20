package com.utah.theater.audition.schedule.UtahTheaterAuditionResource.pojo;

import org.springframework.data.annotation.Id;

import java.time.Instant;
import java.util.Date;

public class Show {
    @Id
    private String id;
    private String name;
    private String theater;
    private String location;
    private String director;
    private String musicDirector;
    private String choreographer;
    private Instant opening;
    private Instant closing;
    private Instant audition;
    private Instant callback;
    private Instant rehearsalStart;
    private Instant rehearsalEnd;
    private String link;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTheater() {
        return theater;
    }

    public void setTheater(String theater) {
        this.theater = theater;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getMusicDirector() {
        return musicDirector;
    }

    public void setMusicDirector(String musicDirector) {
        this.musicDirector = musicDirector;
    }

    public String getChoreographer() {
        return choreographer;
    }

    public void setChoreographer(String choreographer) {
        this.choreographer = choreographer;
    }

    public Instant getOpening() {
        return opening;
    }

    public void setOpening(Instant opening) {
        this.opening = opening;
    }

    public Instant getClosing() {
        return closing;
    }

    public void setClosing(Instant closing) {
        this.closing = closing;
    }

    public Instant getAudition() {
        return audition;
    }

    public void setAudition(Instant audition) {
        this.audition = audition;
    }

    public Instant getCallback() {
        return callback;
    }

    public void setCallback(Instant callback) {
        this.callback = callback;
    }

    public Instant getRehearsalStart() {
        return rehearsalStart;
    }

    public void setRehearsalStart(Instant rehearsalStart) {
        this.rehearsalStart = rehearsalStart;
    }

    public Instant getRehearsalEnd() {
        return rehearsalEnd;
    }

    public void setRehearsalEnd(Instant rehearsalEnd) {
        this.rehearsalEnd = rehearsalEnd;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
