package com.example.FlipCommerce.dto.RequestDto;

import com.example.FlipCommerce.Enum.Category;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductRequestDto {
    String sellerEmailId;
    String name;
    Integer price;
    Category category;
    Integer quantity;
}
