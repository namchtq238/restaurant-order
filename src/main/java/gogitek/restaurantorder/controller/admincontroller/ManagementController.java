package gogitek.restaurantorder.controller.admincontroller;

import gogitek.restaurantorder.entity.User;
import gogitek.restaurantorder.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@AllArgsConstructor
public class ManagementController {
//    private final AdminService adminService;
    private final UserService userService;

//    public ManagementController(AdminService adminService, UserService userService) {
//        this.adminService = adminService;
//        this.userService = userService;
//    }

    @GetMapping("/admin/staffManager")
    public String getViewStaff(Model model) {
//        model.addAttribute("staffList", adminService.getListUserByRole(Role.STAFF));
        return "admin-page/staff";
    }

    @GetMapping("/admin/staffManager/addStaff")
    public String getViewAddStaff(Model model) {
        model.addAttribute("staff", new User());
        return "/admin-page/add-staff";
    }

    @PostMapping("/admin/staffManager/addStaff")
    public String handleAddStaff(RedirectAttributes redirectAttributes, @ModelAttribute User user, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) return "redirect:/admin/staffManager/addStaff";
//        if (adminService.addStaff(user))
//            redirectAttributes.addFlashAttribute("msg", "Thêm nhân viên thành công");
        return "redirect:/admin/staffManager";
    }

    @GetMapping("/admin/staffManager/editStaff/{id}")
    public String getViewEditStaff(Model model, @PathVariable("id") int id) {
//        model.addAttribute("staff", adminService.getUserById(id));
        return "/admin-page/add-staff";
    }

    @PostMapping("/admin/staffManager/editStaff/{id}")
    public String handleEditStaff(RedirectAttributes redirectAttributes,
                                  @ModelAttribute User user, @PathVariable("id") int id) {
//        if (adminService.updateStaff(id, user))
//            redirectAttributes.addFlashAttribute("msg", "Thêm nhân viên thành công");
        return "redirect:/admin/staffManager";
    }

    @GetMapping("admin/staffManager/deleteStaff/{id}")
    public String handleDeleteStaff(@PathVariable("id") int id) {
//        adminService.deleteStaff(id);
        return "redirect:/admin/staffManager";
    }

    @GetMapping("/admin/userManager")
    public String getViewCustomer(Model model) {
//        model.addAttribute("customerList", adminService.getListUserByRole(Role.CUSTOMER));
        return "/admin-page/user";
    }

    @GetMapping("/admin/userManager/delete/{id}")
    public String handleDeleteUser(@PathVariable int id) {
//        adminService.deleteStaff(id);
        return "redirect:/admin/userManager";
    }


    @GetMapping("/admin/personal-infor")
    public String getViewPersonalInfo(Model model) {
        model.addAttribute("user", userService.getCurrentUser());
        return "/admin-page/personal-infor-admin";
    }

    @PostMapping("/admin/edit-user")
    public String handleEditUser(@ModelAttribute User user) {
//        userService.updateUser(userService.getCurrentUser().getId(), user);
        return "redirect:/admin/personal-infor";
    }

    @PostMapping("/admin/edit-password")
    public String handleEditPassword(RedirectAttributes redirectAttributes) {
        return "redirect:/admin/personal-infor";
    }
}
