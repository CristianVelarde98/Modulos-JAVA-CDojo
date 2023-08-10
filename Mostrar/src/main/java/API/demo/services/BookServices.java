package API.demo.services;

import API.demo.models.Book;
import API.demo.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServices {
    private final BookRepository bookRepo;

    public BookServices(BookRepository bookRepository){
        this.bookRepo = bookRepository;
    }

    // pedir todos los libros
    public List<Book> allBooks(){
        return bookRepo.findAll();
    }

    // crear un nuevo libro
    public Book createBook(Book nuevoLibro){
        return bookRepo.save(nuevoLibro);
    }

    // buscar un libro por Id
    public Book findBook(Long id){
        Optional<Book> optionalBook = bookRepo.findById(id);

        if(optionalBook.isPresent()){
            return optionalBook.get();
        } else {
            return null;
        }
    }

    // modificar un libro
    public Book updateBook(Long id, String title, String desc, String lang, Integer pages){
        Book optionalBook = findBook(id);
        if(optionalBook == null){
            return null;
        }

        optionalBook.setTitle(title);
        optionalBook.setDescription(desc);
        optionalBook.setLenguage(lang);
        optionalBook.setNumberOfPages(pages);

        return bookRepo.save(optionalBook);
    }

    // eliminar un libro
    public void deleteBook(Long id){
        bookRepo.deleteById(id);
    }

}
