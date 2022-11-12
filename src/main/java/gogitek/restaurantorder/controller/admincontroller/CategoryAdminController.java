package gogitek.restaurantorder.controller.admincontroller;

import gogitek.restaurantorder.entity.Category;
import gogitek.restaurantorder.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
@RequiredArgsConstructor
public class CategoryAdminController {
    private CategoryService categoryService;
    private static final String currentDirectory = System.getProperty("user.dir");
    private static final Path path = Paths.get(currentDirectory + Paths.get("/target/classes/static/image/ImageOrFarm"));

    @GetMapping("/admin/category")
    public String getViewCategoryAdmin(Model model) {
        model.addAttribute("categoryList", categoryService.getListCategory());
        return "/admin-page/category";
    }

    @GetMapping("/admin/category/add")
    public String getViewAddCategory(Model model) {
        model.addAttribute("category", new Category());
        return "/admin-page/add-category";
    }

    @PostMapping("/admin/category/add")
    public String handleAddCategory(@ModelAttribute  Category category, @RequestParam MultipartFile photo, BindingResult result) {
        if (photo.isEmpty() || result.hasErrors()) return "redirect:/admin/category/add";
        try {
            InputStream inputStream = photo.getInputStream();
            Files.copy(inputStream, path.resolve(photo.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            category.setImage(photo.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }
        categoryService.addCategory(category);
        return "redirect:/admin/category";
    }

}
