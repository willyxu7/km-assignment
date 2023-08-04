package com.km.assignment.model;

import com.km.assignment.entity.Status;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderSalesResponse {

    private String id;
    private String orderNo;
    private int bizDate;
    private int status;
    private String creator;
    private String productCode;
    private String productName;
    private Long quantity;
    private String unit;

    public String getStatus() {
        String statusMessage = null;
        switch (status) {
            case 1:
                statusMessage = String.valueOf(Status.PENDING_PAYMENT);
                break;
            case  2:
                statusMessage = String.valueOf(Status.PAID);
                break;
            case  3:
                statusMessage = String.valueOf(Status.PAYMENT_FAILED);
                break;
            case  4:
                statusMessage = String.valueOf(Status.REFUND);
                break;
        }
        return statusMessage;
    }

}
