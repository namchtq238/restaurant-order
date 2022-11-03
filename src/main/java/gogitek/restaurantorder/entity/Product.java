package gogitek.restaurantorder.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "sale_price")
    private Double salePrice;

    @Column(name = "percent_discount")
    private Double percentDiscount;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "hot")
    private Boolean isHot = false;

    @Column(name = "image")
    private String image;


    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "cate_id", referencedColumnName = "id")
    private Category category;

    @Column(name = "cost")
    private Double cost;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Set<PreOrder> preOrder = new HashSet<>();
}
