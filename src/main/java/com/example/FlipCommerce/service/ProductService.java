package com.example.FlipCommerce.service;

import com.example.FlipCommerce.Enum.Category;
import com.example.FlipCommerce.dto.RequestDto.ProductRequestDto;
import com.example.FlipCommerce.dto.ResponseDto.ProductResponseDto;
import com.example.FlipCommerce.exception.SellerNotFoundException;

import java.util.List;

public interface ProductService {
    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) throws SellerNotFoundException;
    public List<ProductResponseDto> getAllProductsByCategoryAndPrice(Category category, int price);
}
