package gogitek.restaurantorder.controller;

import gogitek.restaurantorder.constaint.FormatPrice;
import gogitek.restaurantorder.entity.*;
import gogitek.restaurantorder.service.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@AllArgsConstructor
public class OrderController {
//    private final CategoryService categoryService;
//    private final CartService cartService;
//    private final ProductService productService;
    private final UserService userService;
//    private final OrderService orderService;
//    private final OrderDetailService orderDetailService;
    private final FormatPrice formatPrice;

//    public OrderController(CategoryService categoryService, CartService cartService, ProductService productService, UserService userService, OrderService orderService, OrderDetailService orderDetailService, FormatPrice format) {
//        this.categoryService = categoryService;
//        this.cartService = cartService;
//        this.productService = productService;
//        this.userService = userService;
//        this.orderService = orderService;
//        this.orderDetailService = orderDetailService;
//        this.formatPrice = format;
//    }

    @ModelAttribute
    public void addAttributeToHeader(Model model) {
//        model.addAttribute("listCategory", categoryService.getListCategory());
        model.addAttribute("format", formatPrice);
//        model.addAttribute("countCartItem", cartService.countNumberOfItemInCart());
    }

    @GetMapping("/payment")
    public String getViewPayment(Model model, RedirectAttributes redirectAttributes) {
//        List<PreOrder> listPreOrder = cartService.getAllCartByUser();
//        if (listPreOrder.isEmpty()) {
//            redirectAttributes.addFlashAttribute("msg", "Không có sản phẩm nào để thanh toán");
//            return "redirect:/cart";
//        }
//        List<CartItem> listProductInCart = productService.getProductFromCart(listPreOrder);
//        Float tempPrice = productService.getTempPriceOfCart(listProductInCart);
//        Float ship = 20000f;
//        if (tempPrice > 50000) ship = 0f;
//        Float totalPrice = tempPrice + ship;
//        model.addAttribute("tempPrice", formatPrice.formatPrice(tempPrice));
//        model.addAttribute("ship", formatPrice.formatPrice(ship));
//        model.addAttribute("totalPrice", formatPrice.formatPrice(totalPrice));
//        model.addAttribute("productInCart", listProductInCart);
//        model.addAttribute("userInformation", userService.getCurrentUser());
//        model.addAttribute("paymentInformation", new PaymentInformation());
        return "payment";
    }

    @PostMapping("/payment/process")
    public String handlePaymentProcess() {
        User user = userService.getCurrentUser();
//        List<PreOrder> listPreOrder = cartService.getAllCartByUser();
//        List<CartItem> listProductInCart = productService.getProductFromCart(listPreOrder);
//        Orders orders = orderService.saveNewOrder(paymentInformation);
//        orders.setUser(user);
//        Set<OrderDetail> orderDetailList = new HashSet<>();
//        Float realPrice = 0f;
//        for (CartItem cart : listProductInCart) {
//            Product product = productService.getProductById(cart.getProductId());
//            OrderDetail orderDetail = orderDetailService.saveOrderDetail(
//                    product, orders,
//                    cart.getTotalPrice(), cart.getQuantity());
//            productService.saveAfterOrder(product, orderDetail);
//            realPrice += orderDetail.getPrice();
//            orderDetailList.add(orderDetail);
//        }
//        Float ship = 20000f;
//        if (realPrice > 50000) ship = 0f;
//        Float totalPrice = realPrice + ship;
//        orderService.saveOrder(orders, totalPrice, paymentInformation.getOrder().getNote(), orderDetailList);
//        cartService.deleteAllItemInCart();
        return "redirect:/payment/ordersucess";
    }

    @GetMapping("/payment/ordersucess")
    public String getViewOrderSucess() {
        return "success-order";
    }

}
