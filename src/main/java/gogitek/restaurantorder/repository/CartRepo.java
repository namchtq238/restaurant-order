package gogitek.restaurantorder.repository;

import gogitek.restaurantorder.entity.PreOrder;
import gogitek.restaurantorder.entity.Product;
import gogitek.restaurantorder.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<PreOrder, Integer> {
}
