package com.example.manytomany.Product;

import com.example.manytomany.Order.Order;
import com.example.manytomany.OrderDetail;
import com.example.manytomany.OrderDetailId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }
    public Product save(Product obj){
        productRepository.save(obj);
        return obj;
    }
    public Optional<Product> findById(int productId){
        return productRepository.findById(productId);
    }

    public boolean AddProductToOrder(Product product, Order order){
        try {
            Set<OrderDetail> orderDetails = product.getOrderDetailSet();
            if (orderDetails==null){
                orderDetails = new HashSet<>();
            }
            OrderDetail orderDetail = new OrderDetail();

            orderDetail.setId(new OrderDetailId(product.getId(), order.getId()));

            orderDetail.setOrder(order);

            orderDetail.setProduct(product);

            orderDetails.add(orderDetail);

            product.setOrderDetailSet(orderDetails);

            productRepository.save(product);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;

    }
}
