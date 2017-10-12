package fi.haagahelia.course.Bookstore;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import fi.haagahelia.course.Bookstore.domain.Book;
import fi.haagahelia.course.Bookstore.domain.BookRepository;
import fi.haagahelia.course.Bookstore.domain.Category;
import fi.haagahelia.course.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);



	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CategoryRepository crepository, BookRepository brepository) {
		return (args) -> {
			log.info("-- SAVING CATEGORIES --");
			crepository.save(new Category("Horror"));
			crepository.save(new Category("Educational"));
			crepository.save(new Category("Romance"));
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Science fiction"));
			crepository.save(new Category("Diary"));
			crepository.save(new Category("Poetry"));
			crepository.save(new Category("Drama"));
			
			
			log.info("-- SAVING BOOKS --");
			brepository.save(new Book("Stories from Ass", "Ass Ketchum", 1991, "000001", 99.99, crepository.findByName("Diary").get(0)));
			brepository.save(new Book("Lord of the Rings", "J. R. R. Tolkien", 1954, "000002", 39.95, crepository.findByName("Fantasy").get(0)));
			brepository.save(new Book("Space Junkies", "Author X", 2147, "000003", 49.95, crepository.findByName("Science fiction").get(0)));
			// brepository.s
			
			log.info("--- FETCHING CATEGORIES ---");
			for (Category category : crepository.findAll()) {
				log.info(category.toString());
			}
			
			log.info("--- FETCHING BOOKS ---");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
