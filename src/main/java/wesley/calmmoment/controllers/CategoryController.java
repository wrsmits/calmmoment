package wesley.calmmoment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import wesley.calmmoment.model.AppUser;
import wesley.calmmoment.model.Category;
import wesley.calmmoment.model.Situation;
import wesley.calmmoment.services.CategoryService;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<CategorySimple> getCategories() {
        List<Category> categories = categoryService.getCategories();
        List<CategorySimple> categorySimple = new ArrayList<CategorySimple>();
        for (Category c : categories) {
            categorySimple.add(new CategorySimple(c.getCategoryId(), c.getCategoryName(), c.getCategoryTitle(), c.getCategoryWriter(), c.getCategoryImage(), c.getCategorySituation()));
        }

        return categorySimple;
    }

    @GetMapping("/categories-no-situations")
    public List<SimpleCategory> getCategoriesWOC() {
        List<Category> categories = categoryService.getCategories();
        List<SimpleCategory> simpleCategory = new ArrayList<SimpleCategory>();
        for (Category c : categories) {
            simpleCategory.add(new SimpleCategory(c.getCategoryId(), c.getCategoryName(), c.getCategoryTitle(), c.getCategoryImage()));
        }

        return simpleCategory;
    }

    @GetMapping("/categories/{categoryId}")
    public Category getCategory(@PathVariable Long categoryId) {
        return categoryService.getCategory(categoryId);
    }

    class CategorySimple {
        private Long categoryId;
        private String categoryName;
        private String categoryTitle;
        private AppUser categoryWriter;
        private String categoryImage;
        private List<Situation> categorySituation;

        public CategorySimple(Long categoryId, String categoryName, String categoryTitle, AppUser categoryWriter, String categoryImage, List<Situation> categorySituation) {
            this.categoryId = categoryId;
            this.categoryName = categoryName;
            this.categoryTitle = categoryTitle;
            this.categoryWriter = categoryWriter;
            this.categoryImage = categoryImage;
            this.categorySituation = categorySituation;
        }

        public Long getCategoryId() {
            return categoryId;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public String getCategoryTitle() {
            return categoryTitle;
        }

        public AppUser getCategoryWriter() {
            return categoryWriter;
        }

        public String getCategoryImage() {
            return categoryImage;
        }

        public List<Situation> getCategorySituation() {
            return categorySituation;
        }
    }

    class SimpleCategory {
        private Long categoryId;
        private String categoryName;
        private String categoryTitle;
        private String categoryImage;

        public SimpleCategory(Long categoryId, String categoryName, String categoryTitle, String categoryImage) {
            this.categoryId = categoryId;
            this.categoryName = categoryName;
            this.categoryTitle = categoryTitle;
            this.categoryImage = categoryImage;
        }

        public Long getCategoryId() {
            return categoryId;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public String getCategoryTitle() {
            return categoryTitle;
        }

        public String getCategoryImage() {
            return categoryImage;
        }

    }
}
