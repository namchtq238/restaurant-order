package gogitek.restaurantorder.repository;

import gogitek.restaurantorder.entity.Cart;
import gogitek.restaurantorder.entity.Product;
import gogitek.restaurantorder.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {
    Cart getCartByUserAndProductAndIsDelete(User user, Product product, boolean b);

    List<Cart> getCartByUserAndIsDelete(User user, boolean b);

    Integer countCartByUserAndIsDelete(User user, boolean b);

    @Query(value = "SELECT count(*) FROM (SELECT distinct user_id FROM orfarm.cart where is_delete = 0) as template", nativeQuery = true)
    Integer countCart();
}
