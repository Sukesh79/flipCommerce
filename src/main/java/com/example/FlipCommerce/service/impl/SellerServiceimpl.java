package com.example.FlipCommerce.service.impl;

import com.example.FlipCommerce.dto.RequestDto.SellerRequestDto;
import com.example.FlipCommerce.dto.ResponseDto.ProductResponseDto;
import com.example.FlipCommerce.dto.ResponseDto.SellerResponseDto;
import com.example.FlipCommerce.model.Product;
import com.example.FlipCommerce.model.Seller;
import com.example.FlipCommerce.repository.SellerRepository;
import com.example.FlipCommerce.service.SellerService;
import com.example.FlipCommerce.transformer.ProductTransformer;
import com.example.FlipCommerce.transformer.SellerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SellerServiceimpl implements SellerService {

    @Autowired
    SellerRepository sellerRepository;

    public SellerResponseDto addSeller(SellerRequestDto sellerRequestDto){

        // dto -> entity
        Seller seller = SellerTransformer.SellerRequestDtoToSeller(sellerRequestDto);
        Seller savedSeller = sellerRepository.save(seller);
        // prepare response Dto
        return SellerTransformer.SellerToSellerResponseDto(savedSeller);
    }

    @Override
    public SellerResponseDto getSellerByEmailId(String emailId) {
        return SellerTransformer.SellerToSellerResponseDto(sellerRepository.findByEmailId(emailId));
    }

    @Override
    public SellerResponseDto getSellerByMobNo(String mobNo) {
        return SellerTransformer.SellerToSellerResponseDto(sellerRepository.findByMobNo(mobNo));
    }

    @Override
    public List<ProductResponseDto> getAllProductsOfSeller(String emailId) {
        List<Product> products = sellerRepository.findByEmailId(emailId).getProducts();
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();

        for(Product product : products){
            productResponseDtos.add(ProductTransformer.ProducToProductResponseDto(product));
        }

        return productResponseDtos;
    }
}