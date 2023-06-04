package com.example.FlipCommerce.dto.RequestDto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderRequestDto {

    String emailId;
    int productId;
    String cardNo;
    int cvv;
    int requiredQuantity;
}
