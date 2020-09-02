package guru.springframework.demo.BookController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.demo.repositories.BookRepository;


@Controller
public class BookController {

    private final BookRepository bookRepository;

    @RequestMapping("/books")
    public String getBooks( final Model model) {
        
        model.addAttribute( "books", bookRepository.findAll());
        return "books/list";
    }

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    
}
