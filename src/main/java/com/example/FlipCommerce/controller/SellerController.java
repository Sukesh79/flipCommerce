package com.example.FlipCommerce.controller;

import com.example.FlipCommerce.dto.RequestDto.SellerRequestDto;
import com.example.FlipCommerce.dto.ResponseDto.ProductResponseDto;
import com.example.FlipCommerce.dto.ResponseDto.SellerResponseDto;
import com.example.FlipCommerce.model.Product;
import com.example.FlipCommerce.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    SellerService sellerService;

    @PostMapping("/add")
    public ResponseEntity addSeller(@RequestBody SellerRequestDto sellerRequestDto){

        SellerResponseDto sellerResponseDto = sellerService.addSeller(sellerRequestDto);
        return new ResponseEntity(sellerResponseDto, HttpStatus.CREATED);
    }

    @GetMapping("/getSellerByEmailId/{emailId}")
    public ResponseEntity getSellerByEmailId(@PathVariable("emailId") String emailId){
        SellerResponseDto sellerResponseDto = sellerService.getSellerByEmailId(emailId);
        return new ResponseEntity(sellerResponseDto, HttpStatus.FOUND);
    }

    @GetMapping("/getSellerByEmailId/{mobNo}")
    public ResponseEntity getSellerByMobile(@PathVariable("mobNo") String mobNo){
        SellerResponseDto sellerResponseDto = sellerService.getSellerByMobNo(mobNo);
        return new ResponseEntity(sellerResponseDto, HttpStatus.FOUND);
    }

    @GetMapping("/getAllProductsOfSeller/{emailId}")
    public ResponseEntity getAllProductsOfSeller(@PathVariable("emailId") String emailId){
        List<ProductResponseDto> products = sellerService.getAllProductsOfSeller(emailId);
        return new ResponseEntity(products, HttpStatus.FOUND);
    }


    // get all the sellers who sell products of a particular category

    // get all the products sold by a seller in a category

    // seller with highest number of products

    // seller with minimum number of products

    // seller(s) selling the costliest product

    // seller(s) selling the cheapest product
}