package com.utah.theater.audition.schedule.UtahTheaterAuditionResource.pojo;

import org.springframework.data.annotation.Id;

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
    private Date opening;
    private Date closing;
    private Date audition;
    private Date callback;
    private Date rehearsalStart;
    private Date rehearsalEnd;
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

    public Date getOpening() {
        return opening;
    }

    public void setOpening(Date opening) {
        this.opening = opening;
    }

    public Date getClosing() {
        return closing;
    }

    public void setClosing(Date closing) {
        this.closing = closing;
    }

    public Date getAudition() {
        return audition;
    }

    public void setAudition(Date audition) {
        this.audition = audition;
    }

    public Date getCallback() {
        return callback;
    }

    public void setCallback(Date callback) {
        this.callback = callback;
    }

    public Date getRehearsalStart() {
        return rehearsalStart;
    }

    public void setRehearsalStart(Date rehearsalStart) {
        this.rehearsalStart = rehearsalStart;
    }

    public Date getRehearsalEnd() {
        return rehearsalEnd;
    }

    public void setRehearsalEnd(Date rehearsalEnd) {
        this.rehearsalEnd = rehearsalEnd;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
