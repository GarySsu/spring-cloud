package com.gary.service;

import com.gary.dao.UserDao;
import com.gary.dto.UserDto;
import com.gary.pojo.User;
import com.gary.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private DateUtils dateUtils;


    /**
     * query all user's info
     * @return
     */
    public List<User> getAllUsers(){
        return userDao.findAll();
    }

    /**
     * query user by id
     * @param id
     * @return
     */
    public UserDto getUser(Integer id){
        User user = userDao.findById(id).get();
        if(Optional.ofNullable(user).isPresent()){
            UserDto dto = new UserDto();
            dto.setId(user.getId());
            dto.setUsername(user.getUsername());
            dto.setAddress(user.getAddress());
            dto.setAge(user.getAge());
            dto.setLastLoginTime(dateUtils.toDateString(user.getLastLoginTime()));

            return dto;
        }
        else{
            return null;
        }

    }

    /**
     * add user
     * @param user
     */
    public void add(User user){
        userDao.save(user);
    }

    /**
     * update user by id
     * @param user
     */
    public void update(User user){ // user对象必须有数据库存在的id值
        userDao.save(user);
    }

    /**
     * delete user  by id
     * @param id
     */
    public void deleteById(Integer id){
        userDao.deleteById(id);
    }

}
