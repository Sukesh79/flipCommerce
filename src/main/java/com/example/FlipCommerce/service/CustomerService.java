package com.example.FlipCommerce.service;

import com.example.FlipCommerce.dto.RequestDto.CustomerRequestDto;
import com.example.FlipCommerce.dto.ResponseDto.CustomerResponseDto;
import com.example.FlipCommerce.dto.ResponseDto.ItemResponseDto;

import java.util.List;

public interface CustomerService {
    public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto);

    CustomerResponseDto getCustomer(String emailId);

    CustomerResponseDto getCustomerByMobNo(String mobNo);

    List<ItemResponseDto> getItemsInCart(String emailId);
}
