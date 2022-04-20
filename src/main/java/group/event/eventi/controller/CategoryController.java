package group.event.eventi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import group.event.eventi.model.Category;
import group.event.eventi.repository.CategoryRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	CategoryRepository categoryRepository;

	@GetMapping("/categories")
	public ResponseEntity<List<Category>> getAllCategories() {
		try {
			List<Category> categories = new ArrayList<Category>();

            categoryRepository.findAll().forEach(categories::add);

			if (categories.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(categories, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/categories/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable("id") long id) {
		Optional<Category> categoryData = categoryRepository.findById(id);

		if (categoryData.isPresent()) {
			return new ResponseEntity<>(categoryData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
