package com.example.FlipCommerce.controller;

import com.example.FlipCommerce.dto.RequestDto.CustomerRequestDto;
import com.example.FlipCommerce.dto.ResponseDto.CustomerResponseDto;
import com.example.FlipCommerce.dto.ResponseDto.ItemResponseDto;
import com.example.FlipCommerce.model.Customer;
import com.example.FlipCommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity addCustomer(@RequestBody CustomerRequestDto customerRequestDto){

        CustomerResponseDto customerResponseDto = customerService.addCustomer(customerRequestDto);
        return new ResponseEntity(customerResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/getByEmailId/{emailId}")
    public ResponseEntity getCustomerByEmailId(@PathVariable("emailId") String emailId){
        CustomerResponseDto customerResponseDto = customerService.getCustomer(emailId);
        return new ResponseEntity(customerResponseDto, HttpStatus.FOUND);
    }

    @GetMapping("/getByEmailId/{mobNo}")
    public ResponseEntity getCustomerByMobNo(@PathVariable("mobNo") String mobNo){
        CustomerResponseDto customerResponseDto = customerService.getCustomerByMobNo(mobNo);
        return new ResponseEntity(customerResponseDto, HttpStatus.FOUND);
    }

    @GetMapping("/getItemsInCart/{emailId}")
    public ResponseEntity getItemsInCart(@PathVariable("emailId") String emailId){
        List<ItemResponseDto> items = customerService.getItemsInCart(emailId);
        return new ResponseEntity(items, HttpStatus.FOUND);
    }
}