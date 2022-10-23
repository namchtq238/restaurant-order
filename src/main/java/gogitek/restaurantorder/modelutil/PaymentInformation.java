package gogitek.restaurantorder.modelutil;

import gogitek.restaurantorder.entity.Orders;
import gogitek.restaurantorder.entity.Product;
import gogitek.restaurantorder.entity.User;
import lombok.Data;

@Data
public class PaymentInformation {
     User user;
     Product product;
     Orders order;
}
