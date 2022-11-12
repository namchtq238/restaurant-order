package gogitek.restaurantorder.service.serviceimp;

import gogitek.restaurantorder.entity.Category;
import gogitek.restaurantorder.repository.CategoryRepo;
import gogitek.restaurantorder.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImp implements CategoryService {
    private CategoryRepo categoryRepo;

    @Override
    public Category addCategory(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public List<Category> getListCategory() {
        return categoryRepo.findAll();
    }
}
