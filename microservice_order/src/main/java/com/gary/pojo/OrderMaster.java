package com.gary.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "order_master")
public class OrderMaster {

    @Id
    @Column(name = "order_id")
    private Long id;

    @Column(name = "order_num")
    private String orderNum;

    @Column(name = "game")
    private String game;

    @Column(name = "device")
    private String device;

    @Column(name = "username")
    private String username;

    @Column(name = "user_id")
    private Integer userId;

}
