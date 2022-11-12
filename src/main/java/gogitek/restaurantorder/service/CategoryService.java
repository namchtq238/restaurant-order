package gogitek.restaurantorder.service;

import gogitek.restaurantorder.entity.Category;

import java.util.List;

public interface CategoryService {
    Category addCategory(Category category);
    List<Category> getListCategory();
}
