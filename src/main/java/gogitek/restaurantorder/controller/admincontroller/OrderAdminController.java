package gogitek.restaurantorder.controller.admincontroller;

import gogitek.restaurantorder.constaint.FormatPrice;
import gogitek.restaurantorder.constaint.Status;
import gogitek.restaurantorder.entity.Orders;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
@AllArgsConstructor
public class OrderAdminController {

//    private final AdminService adminService;
    private final FormatPrice formatPrice;
//    private final OrderService orderService;


    @GetMapping("/admin/order")
    public String getListOrderAdmin(Model model, HttpServletRequest request) {
//        model.addAttribute("topOder", adminService.getTopOrderDetail());
//        model.addAttribute("countOrder", adminService.countOrders());
//        model.addAttribute("countCart", adminService.countCart());
//        model.addAttribute("dateFill", new DateFilterDTO());
//        model.addAttribute("orderAdmin", adminService.getOrderAdmin());
//        model.addAttribute("countProcessing", adminService.countByStatus(Status.PROCESSING.getValue()));
//        model.addAttribute("countCancel", adminService.countByStatus(Status.CANCELED.getValue()));
//        model.addAttribute("countDelivered", adminService.countByStatus(Status.DELIVERED.getValue()));
//        model.addAttribute("countApproved", adminService.countByStatus(Status.APPROVED.getValue()));
        return "admin-page/order";
    }

    @GetMapping("/admin/order/{id}")
    public String getViewOrderAdmin(@PathVariable int id, Model model) {
//        model.addAttribute("order", orderService.getOrderById(id));
        return "admin-page/view-order";
    }

    @PostMapping("/admin/order/edit/{id}")
    public String handleEditStatusOrderAdmin(@PathVariable int id, @ModelAttribute Orders orders,
                                             @RequestParam Status status) {
        orders.setStatus(status);
//        orderService.updateStatus(id, orders);
        return "redirect:/admin/order/{id}";
    }
    @PostMapping("/admin/resultFilter")
    public String handleFillByDate(RedirectAttributes redirectAttributes,
                                   BindingResult bindingResult) {
//        adminService.getListOrderAdminByFilter(dateFilterDTO.getStartFill(), dateFilterDTO.getEndFill()).forEach(orderAdmin -> System.err.println(orderAdmin.toString()));
//        redirectAttributes.addFlashAttribute("orderAdmin", adminService.getListOrderAdminByFilter(dateFilterDTO.getStartFill(), dateFilterDTO.getEndFill()));
        return "redirect:/admin/orderFilter";
    }
    @GetMapping("/admin/orderFilter")
    public String getListOrderFillAdmin(Model model){
        //        model.addAttribute("countOrder", adminService.countOrders());
//        model.addAttribute("countCart", adminService.countCart());
//        model.addAttribute("countProcessing", adminService.countByStatus(Status.PROCESSING.getValue()));
//        model.addAttribute("countCancel", adminService.countByStatus(Status.CANCELED.getValue()));
//        model.addAttribute("countDelivered", adminService.countByStatus(Status.DELIVERED.getValue()));
//        model.addAttribute("countApproved", adminService.countByStatus(Status.APPROVED.getValue()));
        return "admin-page/order-fill";
    }

//    @GetMapping("/admin/order/fill-by-status/{value}")
//    public String handleFillOrderByStatus(@PathVariable Status value, Model model){
//        model.addAttribute("orderAdmin", adminService.findOrdersByStatus(value.getValue()));
//        return "admin-page/order";
//    }
}
