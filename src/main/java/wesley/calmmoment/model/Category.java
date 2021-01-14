package wesley.calmmoment.model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long categoryId;
    @Type(type = "org.hibernate.type.TextType")
    private String categoryName;
    @Type(type = "org.hibernate.type.TextType")
    private String categoryTitle;
    @OneToOne
    private AppUser categoryWriter;
    @Type(type = "org.hibernate.type.TextType")
    private String categoryImage;
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Situation> categorySituation;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public AppUser getCategoryWriter() {
        return categoryWriter;
    }

    public void setCategoryWriter(AppUser categoryCreator) {
        this.categoryWriter = categoryCreator;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

    public List<Situation> getCategorySituation() {
        return categorySituation;
    }

    public void setCategorySituation(List<Situation> categorySituation) {
        this.categorySituation = categorySituation;
    }
}
