package API.demo.view;

import API.demo.models.Book;
import API.demo.services.BookServices;
import jakarta.validation.Valid;
import org.hibernate.sql.ast.SqlTreeCreationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String create(@ModelAttribute("book") @Valid Book book, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.book", result);
            redirectAttributes.addFlashAttribute("book", book);
            return "redirect:/books/new";
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
            return "redirect:/books/" + id;
        }
        servicios.deleteBook(id);
        return "redirect:/books";
    }

    @GetMapping("/books/edit/{id}")
    public String editarLibro(@PathVariable("id") Long id, Model modelo){
        Book libro = servicios.findBook(id);
        modelo.addAttribute("libro", libro);
        return "edit";
    }

    @PutMapping("/books/update")
    public String editarlibro(@ModelAttribute("book") @Valid Book libro, BindingResult resultado){
        if(resultado.hasErrors()){
            return "redirect:/books/edit/" + libro.getId();
        } else {
            servicios.updateBook(libro);
            return "redirect:/books";
        }
    }
}
