package com.km.assignment.entity;

import jakarta.validation.constraints.Min;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysSeq {

    private String id;
    private String seqKey;

    @Min(0)
    private long value;

}
