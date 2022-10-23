package gogitek.restaurantorder.service;

import gogitek.restaurantorder.entity.Cart;
import gogitek.restaurantorder.entity.OrderDetail;
import gogitek.restaurantorder.entity.Product;
import gogitek.restaurantorder.modelutil.CartItem;
import gogitek.restaurantorder.modelutil.ProductAdminDTO;

import java.util.List;
public interface ProductService {
    List<Product> getListProductByCategoryId(int id);
    long getTotalPageByFill(float start, float end, int id);
    List<Product> getListProductFillByPage(float start, float end, long currentPage, int id);
    int getTotalByFill(float start, float end, int id);
    int getTotal(int id);
    List<Product> getListProductByHot();
    List<Product> getListSaleProduct();
    Product getProductById(int id);
    long getTotalPage(int id);
    List<Product> getByPage(long currentPage, int id);
    int getCategoryId(int id);
    List<CartItem> getProductFromCart(List<Cart> cartList);
    Float getTempPriceOfCart(List<CartItem> itemList);
    boolean addProduct(Product product);
    boolean deleteProduct(int id);
    void updateProduct(int id, Product product);
    List<ProductAdminDTO> findAll();
    List<Product> findProductByName(int id, String keyWord, long currentPage);
    long getTotalPageByName(int id, String keyWord);
    void saveAfterOrder(Product product, OrderDetail orderDetail);
}
