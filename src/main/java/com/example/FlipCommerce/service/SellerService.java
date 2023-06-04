package com.example.FlipCommerce.service;

import com.example.FlipCommerce.dto.RequestDto.SellerRequestDto;
import com.example.FlipCommerce.dto.ResponseDto.ProductResponseDto;
import com.example.FlipCommerce.dto.ResponseDto.SellerResponseDto;

import java.util.List;

public interface SellerService {
    public SellerResponseDto addSeller(SellerRequestDto sellerRequestDto);

    SellerResponseDto getSellerByEmailId(String emailId);

    SellerResponseDto getSellerByMobNo(String mobNo);

    List<ProductResponseDto> getAllProductsOfSeller(String emailId);
}
