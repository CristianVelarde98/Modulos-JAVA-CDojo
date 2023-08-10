package API.demo.view;

import API.demo.models.Book;
import API.demo.services.BookServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {
    private final BookServices servicios;

    public BookController(BookServices bookServices){
        this.servicios = bookServices;
    }

    @RequestMapping("/books")
    public String index(Model model){
        List<Book> books = servicios.allBooks();
        model.addAttribute("books", books);
        return "index";
    }

    @RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book){
        return "new";
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public String create(@ModelAttribute("book") Book book, BindingResult result){
        if(result.hasErrors()){
            return "new";
        } else {
            servicios.createBook(book);
            return "redirect:/books";
        }
    }

    @GetMapping("/books/{id}")
    public String showBook(@PathVariable("id") Long id, Model modelo){
        Book libro = servicios.findBook(id);

        if(libro == null){
            return "paginaError";
        }

        modelo.addAttribute("libro", libro);
        return "show";
    }

    @DeleteMapping("/books/{id}")
    public String deletebook(@PathVariable("id") Long id){
        Book libro = servicios.findBook(id);
        if(libro == null){
            return "paginaError";
        }
        servicios.deleteBook(id);
        return "index";
    }
}
