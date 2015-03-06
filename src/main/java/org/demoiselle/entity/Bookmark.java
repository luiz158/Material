package org.demoiselle.entity;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Bookmark implements Serializable {

    private static final long serialVersionUID = 1L;

    /*
     * If you are using Glassfish then remove the strategy attribute
     */
    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;

    @Size(max = 255)
    @Column(length = 255)
    private String released;
    @Size(max = 255)
    @Column(length = 255)
    private String metascore;
    @Size(max = 255)
    @Column(length = 255)
    private String plot;
    @Size(max = 255)
    @Column(length = 255)
    private String director;
    @Size(max = 255)
    @Column(length = 255)
    private String title;
    @Size(max = 255)
    @Column(length = 255)
    private String actors;
    @Size(max = 255)
    @Column(length = 255)
    private String imdbrating;
    @Size(max = 255)
    @Column(length = 255)
    private String imdbvotes;
    @Size(max = 255)
    @Column(length = 255)
    private String response;
    @Size(max = 255)
    @Column(length = 255)
    private String runtime;
    @Size(max = 255)
    @Column(length = 255)
    private String type;
    @Size(max = 255)
    @Column(length = 255)
    private String awards;
    @Size(max = 255)
    @Column(length = 255)
    private String year;
    @Size(max = 255)
    @Column(length = 255)
    private String language;
    @Size(max = 255)
    @Column(length = 255)
    private String rated;
    @Size(max = 255)
    @Column(length = 255)
    private String poster;
    @Size(max = 255)
    @Column(length = 255)
    private String country;
    @Size(max = 255)
    @Column(length = 255)
    private String genre;
    @Size(max = 255)
    @Column(length = 255)
    private String writer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getMetascore() {
        return metascore;
    }

    public void setMetascore(String metascore) {
        this.metascore = metascore;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getImdbrating() {
        return imdbrating;
    }

    public void setImdbrating(String imdbrating) {
        this.imdbrating = imdbrating;
    }

    public String getImdbvotes() {
        return imdbvotes;
    }

    public void setImdbvotes(String imdbvotes) {
        this.imdbvotes = imdbvotes;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

}
