package com.hiwotab.springboot14.Model;

import com.hiwotab.springboot14.Model.Movie;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotEmpty
    @Size(min=2,max = 30)
    private String fname;
    @NotEmpty
    @Size(min=2,max = 30)
    private String lname;
    @NotEmpty
    @Size(min=2,max = 50)
    private String genre;

    @OneToMany(mappedBy = "director",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    public Set<Movie> movies;

    public Director(){
        setMovies(new HashSet<Movie>());
    }

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

    public void addMoive(Movie movie){
        movie.setDirector(this);
        this.movies.add(movie);
    }
}
