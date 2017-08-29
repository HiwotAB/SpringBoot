package com.hiwotab.springboot14.Repository;

import com.hiwotab.springboot14.Model.Director;
import com.hiwotab.springboot14.Model.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface MoiveRepository extends CrudRepository<Movie,Long> {
    Iterable<Movie> findAllByTitle(String partialString);
    Set<Movie> findByDirector(Director director);
}
