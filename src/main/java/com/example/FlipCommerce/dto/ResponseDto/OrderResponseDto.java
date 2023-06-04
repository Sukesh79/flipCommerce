package com.example.FlipCommerce.dto.ResponseDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderResponseDto {
    String customerName;
    String orderNo;
    int totalValue;

    String cardUsed;
    Date orderDate;
    List<ItemResponseDto> items;
}
