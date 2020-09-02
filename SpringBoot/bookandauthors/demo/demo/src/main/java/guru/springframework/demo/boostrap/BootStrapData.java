package guru.springframework.demo.boostrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.demo.domain.Author;
import guru.springframework.demo.domain.Book;
import guru.springframework.demo.domain.Publisher;
import guru.springframework.demo.repositories.AuthorRepository;
import guru.springframework.demo.repositories.BookRepository;
import guru.springframework.demo.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner{

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    @Override
    public void run(String... args) throws Exception {
       Author eric = new Author("Eric","Somthing");
        Book ddd = new Book("Domain Driven DEsign", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod ","Johnson");
        Book noEJB = new Book("J2EE DEvelopment without EJB","329293123");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        authorRepository.save(rod);
        bookRepository.save(noEJB);

        Publisher same= new Publisher( "firstName",  "lastName",  "addreas",  "city",  "state",  "zip");
        same.getBooks().add(noEJB);
        noEJB.setPublisher(same);
        same.getBooks().add(noEJB);
        publisherRepository.save(same);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books :" + bookRepository.count());
        System.out.println("Number of Publishers :" + publisherRepository.count());
        System.out.println("Number of books of the Publishers :" + same.getBooks().size());
    }

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
            PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

   
}
