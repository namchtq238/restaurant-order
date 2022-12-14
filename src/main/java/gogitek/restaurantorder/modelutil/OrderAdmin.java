package gogitek.restaurantorder.modelutil;
import gogitek.restaurantorder.constaint.Status;
import gogitek.restaurantorder.entity.Orders;
import lombok.Data;

import java.util.Date;

@Data
public class OrderAdmin {
    private Integer order_id;
    private String name;
    private Float totalPrice;
    private Status status;
    private Integer totalProduct;
    private String address;
    private String phoneNumber;
    private Float salePrice;
    private Date createAt;

    public OrderAdmin(Orders orders, Integer totalProduct) {
        this.order_id=orders.getId();
        this.name = orders.getUser().getFirstName() + " " + orders.getUser().getLastName();
        this.totalPrice = orders.getTotalPrice();
        this.status = orders.getStatus();
        this.phoneNumber = orders.getPhoneNumber();
        this.address = orders.getAddress();
        this.salePrice = orders.getTotalPrice();
        this.totalProduct = totalProduct;
        this.createAt = orders.getCreateAt();
    }
}
