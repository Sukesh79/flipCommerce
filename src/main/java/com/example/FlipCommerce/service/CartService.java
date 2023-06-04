package com.example.FlipCommerce.service;

import com.example.FlipCommerce.dto.RequestDto.CheckoutCartRequestDto;
import com.example.FlipCommerce.dto.RequestDto.ItemRequestDto;
import com.example.FlipCommerce.dto.ResponseDto.CartResponseDto;
import com.example.FlipCommerce.dto.ResponseDto.OrderResponseDto;
import com.example.FlipCommerce.exception.CustomerNotFoundException;
import com.example.FlipCommerce.exception.EmptyCartException;
import com.example.FlipCommerce.exception.InsufficientQuantityException;
import com.example.FlipCommerce.exception.InvalidCardException;
import com.example.FlipCommerce.model.Item;

public interface CartService {
    public CartResponseDto addToCart(Item item, ItemRequestDto itemRequestDto);
    public OrderResponseDto checkOutCart(CheckoutCartRequestDto checkoutCartRequestDto) throws CustomerNotFoundException, InvalidCardException, EmptyCartException, InsufficientQuantityException;
}
