package fi.haagahelia.course.Bookstore.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.haagahelia.course.Bookstore.domain.Book;
import fi.haagahelia.course.Bookstore.domain.BookRepository;
import fi.haagahelia.course.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {
    @Autowired
    private BookRepository brepository;
    
    @Autowired
    private CategoryRepository crepository;
                
    @RequestMapping(value="/booklist")
    public String indexPage(Model model) {
        model.addAttribute("books", brepository.findAll());
        return "booklist";
    }

    @RequestMapping(value="/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
    	model.addAttribute("categories", crepository.findAll());
        return "addbook";
    }

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String save(Book book) {
        brepository.save(book);
        return "redirect:booklist";
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        brepository.delete(bookId);
        return "redirect:/booklist";
    }
    
    @RequestMapping(value="/edit/{id}")
    public String editBook(@PathVariable("id") Long bookId, Book book, Model model) {
    	model.addAttribute("book", brepository.findOne(bookId));
    	model.addAttribute("categories", crepository.findAll());
    	return "editbook";
    }

}
