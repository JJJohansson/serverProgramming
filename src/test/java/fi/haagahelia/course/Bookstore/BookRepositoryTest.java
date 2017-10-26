package fi.haagahelia.course.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.course.Bookstore.domain.Book;
import fi.haagahelia.course.Bookstore.domain.Category;
import fi.haagahelia.course.Bookstore.domain.BookRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
	
		@Autowired
		private BookRepository brepository;
		
		@Test // TESTING SEARCH
		public void findByTitleShouldReturnBook() {
			List<Book> books = brepository.findByTitle("The Book");
			
			assertThat(books).hasSize(1);
			assertThat(books.get(0).getTitle()).isEqualTo("A Book"); // "Should be "The Book" but instead is "A Book". The test will notify the developer of this :) IT'S ALL ACCORDING TO THE PLAN! I SWEAR!
			
		}
		
		@Test // TESTING SAVE
		public void saveShouldSaveNewBook() {
			Book book = new Book("Test Book", "Test Author", 1999, "TEST ISBN", 55.99, new Category("TEST"));
			brepository.save(book);
			assertThat(book.getTitle()).isNotNull();
		}
		
		@Test // TESTING DELETE
		public void deleteShouldDeleteBook() {
			List<Book> books = brepository.findByTitle("The Book");
			brepository.delete(books);
			assertThat(brepository.findByTitle("The Book")).isEmpty();
		}

}
