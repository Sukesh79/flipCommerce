package com.example.FlipCommerce.service.impl;

import com.example.FlipCommerce.dto.RequestDto.CustomerRequestDto;
import com.example.FlipCommerce.dto.ResponseDto.CustomerResponseDto;
import com.example.FlipCommerce.dto.ResponseDto.ItemResponseDto;
import com.example.FlipCommerce.model.Cart;
import com.example.FlipCommerce.model.Customer;
import com.example.FlipCommerce.model.Item;
import com.example.FlipCommerce.repository.CustomerRepository;
import com.example.FlipCommerce.service.CustomerService;
import com.example.FlipCommerce.transformer.CustomerTransformer;
import com.example.FlipCommerce.transformer.ItemTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceimpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto){

        // dto -> entity
        Customer customer = CustomerTransformer.CustomerRequestDtoToCustomer(customerRequestDto);
        Cart cart = Cart.builder()
                .cartTotal(0)
                .customer(customer)
                .build();

        customer.setCart(cart);
        customer.setCards(new ArrayList<>());
        Customer savedCustomer = customerRepository.save(customer);  // saves both customer and cart
        // prepare response Dto
        return CustomerTransformer.CustomerToCustomerResponseDto(savedCustomer);

    }

    @Override
    public CustomerResponseDto getCustomer(String emailId) {
        Customer customer = customerRepository.findByEmailId(emailId);
        return CustomerTransformer.CustomerToCustomerResponseDto(customer);
    }

    @Override
    public CustomerResponseDto getCustomerByMobNo(String mobNo) {
        Customer customer = customerRepository.findByMobNo(mobNo);
        return CustomerTransformer.CustomerToCustomerResponseDto(customer);
    }

    @Override
    public List<ItemResponseDto> getItemsInCart(String emailId) {
        Customer customer = customerRepository.findByEmailId(emailId);
        Cart cart = customer.getCart();

        List<Item> items = cart.getItems();
        List<ItemResponseDto> itemResponseDtos = new ArrayList<>();
        for(Item item : items){
            itemResponseDtos.add(ItemTransformer.ItemToItemResponseDto(item));
        }

        return itemResponseDtos;
    }


}