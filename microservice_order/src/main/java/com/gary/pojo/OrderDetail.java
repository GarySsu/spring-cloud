package com.gary.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "order_detail")
public class OrderDetail {

    @Id
    @Column(name = "order_detail_id")
    private Long id;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "weapon")
    private String weapon;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "status")
    private int status;

}
