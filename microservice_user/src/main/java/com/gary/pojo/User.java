package com.gary.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "sys_user")
public class User implements Serializable {

    @Id
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "address")
    private String address;

    @Column(name = "age")
    private int age;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "last_login_time")
    private Date lastLoginTime;

    @Column(name = "enabled")
    private boolean enabled;

}