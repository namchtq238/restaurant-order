package gogitek.restaurantorder.service;

import gogitek.restaurantorder.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getListCategory();
    Optional<Category> getCategoryById(int id);
    boolean addCategory(Category category);
    boolean deleteCategory(int id);
    void updateCategory(int id, Category category);
}
