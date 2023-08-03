package com.km.assignment.model;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequest {

    private String itemId;

    private String userId;

    @Min(0)
    private Long quantity;

    private String remark;

}
