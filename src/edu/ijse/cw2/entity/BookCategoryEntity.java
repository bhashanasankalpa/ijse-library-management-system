package edu.ijse.cw2.entity;

public class BookCategoryEntity {
    private String categoryId;
    private String categoryName;

    public BookCategoryEntity() {
    }

    public BookCategoryEntity(String categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "BookCategoryEntity [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
    }

    
    
}
