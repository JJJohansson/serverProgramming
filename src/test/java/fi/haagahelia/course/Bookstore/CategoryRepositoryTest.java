package fi.haagahelia.course.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.course.Bookstore.domain.Category;
import fi.haagahelia.course.Bookstore.domain.CategoryRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTest {

	@Autowired
	private CategoryRepository crepository;
	
	@Test // TESTING SEARCH
	public void findByNameShouldReturnCategory() {
		List<Category> categories = crepository.findByName("Horror");
		
		assertThat(categories).hasSize(1);
		assertThat(categories.get(0).getName()).isEqualTo("Horror");
	}
	
	@Test // TESTING SAVE
	public void saveShouldSaveNewCategory() {
		Category category = new Category("TEST");
		crepository.save(category);
		assertThat(category.getName()).isNotNull();
	}
	
	@Test // TESTING DELETE
	public void deleteShouldDeleteCategory() {
		List<Category> categories = crepository.findByName("Diary");
		crepository.delete(categories);
		assertThat(crepository.findByName("Diary")).isEmpty();
	}

}