package com.hiwotab.springboot14.Repository;

import com.hiwotab.springboot14.Model.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MoiveRepository extends CrudRepository<Movie,Long> {
    Iterable<Movie> findAllByTitle(String partialString);
}
