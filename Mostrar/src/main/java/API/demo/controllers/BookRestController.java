package API.demo.controllers;

import API.demo.models.Book;
import API.demo.services.BookServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookRestController {
    private final BookServices bookServices;

    public BookRestController(BookServices bookServices){
        this.bookServices = bookServices;
    }

    @RequestMapping("/api/books")
    public List<Book> index(){
        return bookServices.allBooks();
    }

    @RequestMapping(value = "/api/books", method = RequestMethod.POST)
    public Book create(@RequestParam(value = "title") String title, @RequestParam(value = "description") String desc, @RequestParam(value = "lenguage") String lenguaje, @RequestParam(value = "pages") Integer pages){
        Book newBook = new Book(title, desc, lenguaje, pages);
        return bookServices.createBook(newBook);
    }

    @RequestMapping("/api/books/{id}")
    public Book showById(@PathVariable("id") Long id){
        Book libro = bookServices.findBook(id);
        return libro;
    }

    @RequestMapping(value = "/api/books/{id}", method = RequestMethod.PUT)
    public Book updateBook(@PathVariable("id") Long id, @RequestParam(value = "title") String title, @RequestParam(value = "description") String desc, @RequestParam(value = "lenguage") String lenguaje, @RequestParam(value = "pages") Integer pages){
        Book updateBook = bookServices.updateBook(id, title, desc, lenguaje, pages);
        return updateBook;
    }

    @RequestMapping(value = "/api/books/{id}", method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable("id") Long id){
        Book optionalBook = bookServices.findBook(id);
        if(optionalBook != null){
            bookServices.deleteBook(id);
            return "EL libro " + " ' " + optionalBook.getTitle() + " ' " + " fue eliminado con exito";
        } else {
            return "No se encontro un libro con ese id";
        }
    }
}
