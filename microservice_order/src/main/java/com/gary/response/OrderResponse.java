package com.gary.response;

import com.gary.dto.UserDto;
import com.gary.pojo.OrderDetail;
import com.gary.pojo.OrderMaster;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
public class OrderResponse extends BaseResponse {

    private Optional<OrderMaster> orderMaster;
    private UserDto userDto;
    private List<OrderDetail> orderDetails;

}
