package fi.haagahelia.course.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.course.Bookstore.domain.User;
import fi.haagahelia.course.Bookstore.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository urepository;
	
	/*@Test // TESTNG SEARCH
	public void findByUsernameShouldReturnUser() {
		List<User> users = urepository.findByUsernames("ADMIN");
		
		assertThat(users).hasSize(1);
		assertThat(users.get(0).getUsername()).isEqualTo("ADMIN");
	}*/

}
