package gogitek.restaurantorder.service.serviceimp;

import gogitek.restaurantorder.constaint.Status;
import gogitek.restaurantorder.entity.OrderDetail;
import gogitek.restaurantorder.entity.Orders;
import gogitek.restaurantorder.modelutil.PaymentInformation;
import gogitek.restaurantorder.repository.OrdersRepo;
import gogitek.restaurantorder.service.OrderService;
import gogitek.restaurantorder.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class OrderServiceImp implements OrderService {
    private final OrdersRepo ordersRepo;
    private final UserService userService;

    public OrderServiceImp(OrdersRepo ordersRepo, UserService userService) {
        this.ordersRepo = ordersRepo;
        this.userService = userService;
    }

    @Override
    public Orders saveNewOrder(PaymentInformation information) {
        return ordersRepo.saveAndFlush(information.getOrder());
    }

    @Override
    public boolean saveOrder(Orders orders, Float totalPrice, String note, Set<OrderDetail> orderDetailList) {
        orders.setNote(note);
        orders.setTotalPrice(totalPrice);
        orders.setOrderDetails(orderDetailList);
        orders.setStatus(Status.APPROVED);
        orders.setCreateAt(new java.util.Date());
        ordersRepo.save(orders);
        return true;
    }

    @Override
    public List<Orders> getListOrderByCurrentUser() {
        return ordersRepo.getAllByUser(userService.getCurrentUser());
    }

    @Override
    public Orders getOrderById(int id) {
        return ordersRepo.getById(id);
    }

    @Override
    public void updateStatus(int id, Orders orders) {
        Orders defaultOrder = ordersRepo.getById(id);
        defaultOrder.setStatus(orders.getStatus());
        ordersRepo.save(defaultOrder);
    }
}
