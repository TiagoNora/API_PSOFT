package com.psoft.project.model;

import java.util.Date;

public class ReviewUser {
    private int id;
    private String sku;
    private String status;
    private String text;
    private float rating;
    private int totalVotes;
    private int upVotes;
    private int downVotes;
    private Date creationDateTime;
    private String funFact;

    public ReviewUser(int id, String sku, String status, String text, float rating, int totalVotes, int upVotes, int downVotes, Date creationDateTime, String funFact) {
        this.id = id;
        this.sku = sku;
        this.status = status;
        this.text = text;
        this.rating = rating;
        this.totalVotes = totalVotes;
        this.upVotes = upVotes;
        this.downVotes = downVotes;
        this.creationDateTime = creationDateTime;
        this.funFact = funFact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getTotalVotes() {
        return totalVotes;
    }

    public void setTotalVotes(int totalVotes) {
        this.totalVotes = totalVotes;
    }

    public int getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(int upVotes) {
        this.upVotes = upVotes;
    }

    public int getDownVotes() {
        return downVotes;
    }

    public void setDownVotes(int downVotes) {
        this.downVotes = downVotes;
    }

    public Date getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(Date creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public String getFunFact() {
        return funFact;
    }

    public void setFunFact(String funFact) {
        this.funFact = funFact;
    }
}
