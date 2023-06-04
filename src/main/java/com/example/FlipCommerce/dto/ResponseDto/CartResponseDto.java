package com.example.FlipCommerce.dto.ResponseDto;

import com.example.FlipCommerce.dto.RequestDto.ItemRequestDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartResponseDto {
    int cartTotal;
    String customerName;
    List<ItemResponseDto> items;
}
