package com.example.FlipCommerce.service.impl;


import com.example.FlipCommerce.Enum.CardType;
import com.example.FlipCommerce.dto.RequestDto.CardRequestDto;
import com.example.FlipCommerce.dto.ResponseDto.CardResponseDto;
import com.example.FlipCommerce.exception.CustomerNotFoundException;
import com.example.FlipCommerce.model.Card;
import com.example.FlipCommerce.model.Customer;
import com.example.FlipCommerce.repository.CardRepository;
import com.example.FlipCommerce.repository.CustomerRepository;
import com.example.FlipCommerce.service.CardService;
import com.example.FlipCommerce.transformer.CardTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CardServiceimpl implements CardService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CardRepository cardRepository;
    public CardResponseDto addCard(CardRequestDto cardRequestDto) throws CustomerNotFoundException {

        Customer customer = customerRepository.findByEmailId(cardRequestDto.getEmailId());
        if(customer==null){
            throw new CustomerNotFoundException("Invalid email id!!!");
        }

        // dto -> entity
        Card card = CardTransformer.CardRequestDtoToCard(cardRequestDto);
        card.setCustomer(customer);
        customer.getCards().add(card);

        // save customer and card
        Customer savedCustomer = customerRepository.save(customer);

        // preapre response Dto
        return CardTransformer.CardToCardResponseDto(card);
    }

    @Override
    public List<CardType> getCardTypeMax() {
        List<Card> cards = cardRepository.findAll();
        List<CardType> ans = new ArrayList<>();
        Map<CardType, Integer> map = new HashMap<>();
        int maxCount = 0;
        for(Card card : cards){
            map.put(card.getCardType(), map.getOrDefault(card.getCardType(), 0) + 1);
            maxCount = Math.max(maxCount, map.get(card.getCardType()));
        }

        for(CardType cardType : map.keySet()){
            if(map.get(cardType) == maxCount) ans.add(cardType);
        }
        return ans;
    }

    @Override
    public List<CardType> getCardTypeMin() {
        List<Card> cards = cardRepository.findAll();
        List<CardType> ans = new ArrayList<>();
        Map<CardType, Integer> map = new HashMap<>();
        int minCount = 0;
        for(Card card : cards){
            map.put(card.getCardType(), map.getOrDefault(card.getCardType(), 0) + 1);
            minCount = Math.max(minCount, map.get(card.getCardType()));
        }

        for(CardType cardType : map.keySet()){
            if(map.get(cardType) == minCount) ans.add(cardType);
        }
        return ans;
    }
}