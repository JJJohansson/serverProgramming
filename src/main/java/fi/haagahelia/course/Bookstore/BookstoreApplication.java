package fi.haagahelia.course.Bookstore;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import fi.haagahelia.course.Bookstore.domain.Book;
import fi.haagahelia.course.Bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);



	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	/**
	 * @param repository
	 * @return
	 */
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			log.info("save a couple of books");
			repository.save(new Book("Stories from Ass", "Ass Ketchum", 1991, "000001", 99.99));
			repository.save(new Book("Lord of the Ring", "J. R. R. Tolkien", 1954, "000002", 39.95));
			
			log.info("fetch all the books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
