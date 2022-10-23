package gogitek.restaurantorder.service;

import gogitek.restaurantorder.entity.OrderDetail;
import gogitek.restaurantorder.entity.Orders;
import gogitek.restaurantorder.entity.Product;

public interface OrderDetailService {
    OrderDetail saveOrderDetail(Product product, Orders orders, Float price, Integer quantity);
}
