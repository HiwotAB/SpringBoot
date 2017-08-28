package com.hiwotab.springboot14.Model;

import com.hiwotab.springboot14.Model.Movie;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String fname;
    private String lname;
    private String genre;
    @OneToMany(mappedBy = "director",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    public Set<Movie> movies;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }
}
