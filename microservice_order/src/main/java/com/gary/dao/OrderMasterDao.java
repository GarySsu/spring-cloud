package com.gary.dao;

import com.gary.pojo.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderMasterDao extends JpaRepository<OrderMaster, Long> {

    public Optional<OrderMaster> findAllByOrderNum(String orderNum);

    public OrderMaster findAllByUsername(String username);
}
