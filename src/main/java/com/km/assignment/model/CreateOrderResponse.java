package com.km.assignment.model;

import com.km.assignment.entity.Status;
import com.km.assignment.helper.OrderHelper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderResponse {

    private String orderId;
    private int bizDate;
    private String orderNo;
    private int status;

    public String getStatus() {
        return OrderHelper.convertStatus(status);
    }

}
