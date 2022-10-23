package gogitek.restaurantorder.service.serviceimp;

import gogitek.restaurantorder.entity.OrderDetail;
import gogitek.restaurantorder.entity.Orders;
import gogitek.restaurantorder.entity.Product;
import gogitek.restaurantorder.repository.OrderDetailRepo;
import gogitek.restaurantorder.service.OrderDetailService;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImp implements OrderDetailService {

    private final OrderDetailRepo orderDetailRepo;

    public OrderDetailServiceImp(OrderDetailRepo orderDetailRepo) {
        this.orderDetailRepo = orderDetailRepo;
    }

    @Override
    public OrderDetail saveOrderDetail(
            Product product, Orders orders, Float price, Integer quantity) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrders(orders);
        orderDetail.setProduct(product);
        if(product.getQuantityProd() <= quantity) orderDetail.setQuantity(product.getQuantityProd());
        else orderDetail.setQuantity(quantity);
        orderDetail.setPrice(orderDetail.getQuantity()* product.getSalePrice() * (100-product.getPercentDiscount())/100);
        return orderDetailRepo.saveAndFlush(orderDetail);
    }
}
