package com.km.assignment.model;

import com.km.assignment.helper.OrderHelper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdatePaymentToPaidResponse {

    private String orderId;
    private int status;

    public String getStatus() {
        return OrderHelper.convertStatus(status);
    }

}
