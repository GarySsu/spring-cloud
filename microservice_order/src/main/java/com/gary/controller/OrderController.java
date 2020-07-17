package com.gary.controller;

import com.gary.client.UserController;
import com.gary.dto.UserDto;
import com.gary.response.OrderResponse;
import com.gary.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserController userController;

    @RequestMapping(value = "/{orderNum}",method = RequestMethod.GET)
    public OrderResponse getOrder(@PathVariable String orderNum){
        return orderService.getOrder(orderNum);
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public UserDto getUser(@PathVariable Integer id){
        return userController.getUser(id);
    }

}
