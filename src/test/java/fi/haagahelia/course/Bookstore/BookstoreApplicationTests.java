package fi.haagahelia.course.Bookstore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;


import fi.haagahelia.course.Bookstore.web.BookController;
import fi.haagahelia.course.Bookstore.web.UserController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookstoreApplicationTests {
	
	@Autowired
	private BookController bookController;
	private UserController userController;

	@Test
	public void contextLoads() {
		assertThat(bookController).isNotNull();
		assertThat(userController).isNotNull();
	}

}
