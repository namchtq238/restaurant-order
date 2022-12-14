package gogitek.restaurantorder.controller;

import gogitek.restaurantorder.constaint.FormatPrice;
import gogitek.restaurantorder.entity.User;
import gogitek.restaurantorder.modelutil.PasswordDTO;
import gogitek.restaurantorder.service.CartService;
import gogitek.restaurantorder.service.CategoryService;
import gogitek.restaurantorder.service.OrderService;
import gogitek.restaurantorder.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    private final UserService userService;
    private final CategoryService categoryService;
    private final CartService cartService;
    private final OrderService orderService;
    private final FormatPrice formatPrice;

    public UserController(UserService userService, CategoryService categoryService,
                          CartService cartService, OrderService orderService, FormatPrice formatPrice) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.cartService = cartService;
        this.orderService = orderService;
        this.formatPrice = formatPrice;
    }

    @ModelAttribute
    public void addAttributeToHeader(Model model) {
        model.addAttribute("listCategory", categoryService.getListCategory());
        model.addAttribute("format", formatPrice);
        model.addAttribute("countCartItem", cartService.countNumberOfItemInCart());
    }

    @GetMapping("/login")
    public String getViewLogin() {
        return "login";
    }

    @GetMapping("/createAccount")
    public String getViewCreateAccount(Model model) {
        model.addAttribute("user", new User());
        return "createAccount";
    }

    @PostMapping("/processRegister")
    public String handleCreateAccount(@ModelAttribute User user,
                                      BindingResult bindingResult,
                                      RedirectAttributes redirectAttributes) {
        if (userService.checkExist(user.getEmail()))
            bindingResult.rejectValue("email", "invalid", "T??i kho???n kh??ch h??ng ???? c?? trong h??? th???ng");
        if (bindingResult.hasErrors()) return "/createAccount";
        userService.registerUser(user);
        redirectAttributes.addFlashAttribute("msg", "T???o t??i kho???n th??nh c??ng");
        return "redirect:/login";
    }

    @GetMapping("/user/personal-information")
    public String getViewUserInformation(Model model) {
        User user = userService.getCurrentUser();
        model.addAttribute("userInfo", user);
        model.addAttribute("checkpassword", new PasswordDTO());
        return "personal-infor";
    }

    @PostMapping("/user/edit-user")
    public String handleEditUser(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
        userService.updateUser(userService.getCurrentUser().getId(), user);
        redirectAttributes.addFlashAttribute("msg", "C???p nh???t th??ng tin th??nh c??ng");
        return "redirect:/user/personal-information";
    }

    @PostMapping("/user/edit-password")
    public String handleEditPassword(RedirectAttributes redirectAttributes, @ModelAttribute PasswordDTO passwordDTO) {
        String msg;
        if (userService.updatePassword(passwordDTO)) msg = "Thay ?????i m???t kh???u th??nh c??ng";
        else msg = "Thay ?????i m???t kh???u th???t b???i";
        redirectAttributes.addFlashAttribute("msg", msg);
        return "redirect:/user/personal-information";
    }

    @GetMapping("/user/order-history")
    public String getViewOrderHistory(Model model) {
        model.addAttribute("listOrder", orderService.getListOrderByCurrentUser());
        return "order-history";
    }

}
