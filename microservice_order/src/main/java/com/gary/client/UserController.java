package com.gary.client;

import com.gary.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "microservice-user",fallback = UserControllerImpl.class)
public interface UserController {

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public UserDto getUser(@PathVariable(value = "id") Integer id);

}
