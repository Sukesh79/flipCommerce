package com.example.FlipCommerce.dto.ResponseDto;

import com.example.FlipCommerce.Enum.Category;
import com.example.FlipCommerce.Enum.ProductStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponseDto {

    String productName;
    String sellerName;
    Category category;
    int price;
    ProductStatus productStatus;
}
