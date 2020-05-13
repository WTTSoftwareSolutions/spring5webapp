package com.wttsoftwaresolutions.spring5webapp.bootstrap;

import com.wttsoftwaresolutions.spring5webapp.model.Author;
import com.wttsoftwaresolutions.spring5webapp.model.Book;
import com.wttsoftwaresolutions.spring5webapp.model.Publisher;
import com.wttsoftwaresolutions.spring5webapp.repositories.AuthorRepository;
import com.wttsoftwaresolutions.spring5webapp.repositories.BookRepository;
import com.wttsoftwaresolutions.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 5/16/17.
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher("SFG Publishing", null, "St Petersburg", "FL", null);
        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());

        //Eric
        Author eric = new Author("Eric", "Evans");
        Book  ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);
        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());

    }
}
