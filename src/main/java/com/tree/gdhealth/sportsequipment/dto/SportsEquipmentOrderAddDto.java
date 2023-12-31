package com.tree.gdhealth.sportsequipment.dto;

import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author 정인호
 */
@Builder
@AllArgsConstructor
@Data
public class SportsEquipmentOrderAddDto {
    @Positive
    private int employeeOrderer;
    @Positive
    private int branchNo;
    @Positive(message = "발주물품을 선택해야합니다")
    private Integer sportsEquipmentNo;
    @Positive(message = "발주할 수량은 양수여야 합니다.")
    private Integer quantity;
    @Positive
    private Integer employeeApprover;
}
