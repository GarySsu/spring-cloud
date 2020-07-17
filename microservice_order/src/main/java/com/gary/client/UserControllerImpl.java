package com.gary.client;

import com.gary.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserControllerImpl implements UserController {

    @Override
    public UserDto getUser(Integer id) {
        System.out.println("excute hysrix .....");
        return null;
    }
}
