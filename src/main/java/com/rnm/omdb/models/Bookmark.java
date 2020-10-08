package com.rnm.omdb.models;


import javax.persistence.*;

@Entity
@Table(name="bookmarks")
public class Bookmark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "TEXT")
    private String title;

    @Column(columnDefinition = "TEXT")
    private String year;

    @Column(columnDefinition = "TEXT")
    private String posterLink;

    @Column(columnDefinition = "TEXT")
    private String imdbID;


    public Bookmark() {
    }

    public Bookmark(String title) {
        this.title = title;
    }

    public Bookmark(String title, String year, String imdbID) {
        this.title = title;
        this.year = year;
        this.imdbID = imdbID;
    }

    public Bookmark(String title, String year, String posterLink, String imdbID) {
        this.title = title;
        this.year = year;
        this.posterLink = posterLink;
        this.imdbID = imdbID;
    }

    public Bookmark(long id, String title, String year, String posterLink, String imdbID) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.posterLink = posterLink;
        this.imdbID = imdbID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPosterLink() {
        return posterLink;
    }

    public void setPosterLink(String posterLink) {
        this.posterLink = posterLink;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }
    




}
