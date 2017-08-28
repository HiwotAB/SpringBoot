package com.hiwotab.springboot14.Repository;

import com.hiwotab.springboot14.Model.Director;
import org.springframework.data.repository.CrudRepository;

public interface DirectorRepository extends CrudRepository<Director,Long >{
    Iterable<Director> findAllByFname(String partialString);
    Iterable<Director> findAllById(long  partialString);
}
