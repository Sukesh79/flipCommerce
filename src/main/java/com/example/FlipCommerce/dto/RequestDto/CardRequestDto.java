package com.example.FlipCommerce.dto.RequestDto;


import com.example.FlipCommerce.Enum.CardType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CardRequestDto {
    String emailId;
    String cardNo;
    int cvv;
    CardType cardType;
    Date validTill;

}
