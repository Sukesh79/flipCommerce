package com.example.FlipCommerce.dto.ResponseDto;

import com.example.FlipCommerce.Enum.CardType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CardResponseDto {
    String customerName;
    String cardNo;
    CardType cardType;
}
