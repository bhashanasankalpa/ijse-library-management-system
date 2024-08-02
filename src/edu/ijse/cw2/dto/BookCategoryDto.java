package edu.ijse.cw2.dto;

public class BookCategoryDto {
    private String categoryId;
    private String categoryName;
    
    public BookCategoryDto() {
    }

    public BookCategoryDto(String categoryId, String categoryName) {
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
        return "BookCategoryDto [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
    }

    
    
}
