package com.gary.service;

import com.gary.client.UserController;
import com.gary.dao.OrderDetailDao;
import com.gary.dao.OrderMasterDao;
import com.gary.dto.UserDto;
import com.gary.pojo.OrderMaster;
import com.gary.response.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Optional.*;

@Service
public class OrderService {

    @Autowired
    private OrderMasterDao orderMasterDao;

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Autowired
    private UserController userController;

    public OrderResponse getOrder(String orderNum){

        OrderResponse response = new OrderResponse();

        Optional<OrderMaster> orderMaster = orderMasterDao.findAllByOrderNum(orderNum);
        if(orderMaster.isPresent()){
            UserDto userDto = userController.getUser(orderMaster.get().getUserId());

            response.setOrderMaster(of(orderMaster.get()));
            response.setUserDto(userDto);
        }

        return response;
    }

}
