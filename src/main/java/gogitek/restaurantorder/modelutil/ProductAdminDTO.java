package gogitek.restaurantorder.modelutil;

import gogitek.restaurantorder.entity.Product;
import lombok.Data;

@Data
public class ProductAdminDTO {
    private Long id;
    private String name;
    private Double salePrice;
    private Integer quantityProd;
    private Double cost;
    private String cate_name;

    public ProductAdminDTO(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.salePrice = product.getSalePrice();
        this.quantityProd = product.getQuantity();
        this.cost = product.getCost();
        this.cate_name = product.getCategory().getName();
    }
}
