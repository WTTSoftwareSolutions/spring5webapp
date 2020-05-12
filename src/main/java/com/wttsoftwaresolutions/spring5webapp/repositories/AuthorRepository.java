package com.wttsoftwaresolutions.spring5webapp.repositories;

import com.wttsoftwaresolutions.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jt on 5/16/17.
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
