package gogitek.restaurantorder.service;

import gogitek.restaurantorder.entity.Cart;
import gogitek.restaurantorder.entity.Orders;
import gogitek.restaurantorder.entity.Product;

import java.util.List;

public interface CartService {
    boolean saveItemToCart(Product product, Integer quantity);
    List<Cart> getAllCartByUser();
    Integer countNumberOfItemInCart();
    boolean deleteAllItemInCart();
    void saveNewQuantity(List<Cart> cartList, List<Integer> soluong);
    boolean deleteAnItemInCart(int productId);
    void saveItemToCartByOrder(Orders orders);
}
