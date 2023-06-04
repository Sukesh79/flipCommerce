package com.example.FlipCommerce.service;

import com.example.FlipCommerce.Enum.CardType;
import com.example.FlipCommerce.dto.RequestDto.CardRequestDto;
import com.example.FlipCommerce.dto.ResponseDto.CardResponseDto;
import com.example.FlipCommerce.exception.CustomerNotFoundException;

import java.util.List;

public interface CardService {

    public CardResponseDto addCard(CardRequestDto cardRequestDto) throws CustomerNotFoundException;

    List<CardType> getCardTypeMax();

    List<CardType> getCardTypeMin();
}
