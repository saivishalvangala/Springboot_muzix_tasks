package com.stackroute.muzixApp.muzix;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Muzix {
    @Id
    int trackId;
    String trackName;
    String comments;

    public Muzix() {
    }

    @Override
    public String toString() {
        return "Muzix{" +
                "trackId=" + trackId +
                ", trackName='" + trackName + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }

    public Muzix(int trackId, String trackName, String comments) {
        this.trackId = trackId;
        this.trackName = trackName;
        this.comments = comments;
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
