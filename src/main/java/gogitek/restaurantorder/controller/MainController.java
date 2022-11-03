package gogitek.restaurantorder.controller;

import gogitek.restaurantorder.constaint.FormatPrice;
import gogitek.restaurantorder.entity.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Collections;
import java.util.List;

@Controller
@AllArgsConstructor
public class MainController {

    @GetMapping(value = {"/", "/index", "/home"})
    public String getViewHomepage() {
        return "index";
    }

    @GetMapping("/login")
    public String getViewLogin() {
        return "login";
    }

}
