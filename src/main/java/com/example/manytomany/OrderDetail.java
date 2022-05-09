package com.example.manytomany;

import com.example.manytomany.Order.Order;
import com.example.manytomany.Product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "order_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {
    @EmbeddedId
    private OrderDetailId id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "orderId")
    private Order order;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "productId")
    private Product product;


    // thông tin thêm.
    private int quantity;
    private double unitPrice;
}