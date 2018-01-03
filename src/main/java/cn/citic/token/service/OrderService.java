package cn.citic.token.service;

import cn.citic.token.entity.Order;
import cn.citic.token.repository.OrderRepository;
import io.shardingjdbc.core.keygen.DefaultKeyGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by rockywoo on 2017/12/11.
 */
@Service
public class OrderService {

	@Autowired
    private OrderRepository orderRepository;


    public void demo() {
        for (int i = 0; i < 1000; i++) {
            Order order = new Order();
            order.setUserId(51);
//            DefaultKeyGenerator d=new DefaultKeyGenerator();
//            order.setOrderId(d.generateKey().longValue());
            orderRepository.save(order);
        }

    }
}
