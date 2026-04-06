package com.example.jpa.controllers;

import com.example.jpa.entities.ProductEntity;
import com.example.jpa.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final ProductRepository productRepository;
    private final int PAGE_SIZE =5;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

// sorting Example -URl: http://localhost:8080/products?sortBy=price
//    @GetMapping
//    public List<ProductEntity> getAllProductsSorted(@RequestParam(defaultValue = "id") String sortBy){
////        return  productRepository.findBy(Sort.by(Sort.Direction.DESC,sortBy, "price", "quantity"));
////          ByDefault it is ASC
//        return productRepository.findBy(Sort.by(
//                Sort.Order.desc(sortBy),Sort.Order.asc("price")));
//    }

    //Pagination Example- URL: http://localhost:8080/products?sortBy=price&pageNumber=2
//    @GetMapping
//    public Page<ProductEntity> getAllProducts(@RequestParam(defaultValue = "id") String sortBy,
//                                              @RequestParam(defaultValue = "1") Integer pageNumber){
//        Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE);
//         return productRepository.findAll(pageable);
//    }

//    @GetMapping
//    public List<ProductEntity> getAllProducts(@RequestParam(defaultValue = "id") String sortBy,
//                                              @RequestParam(defaultValue = "0") Integer pageNumber){
//        Pageable pageable = PageRequest.of(pageNumber, PAGE_SIZE,Sort.by(sortBy));
//        return productRepository.findAll(pageable).getContent();
//    }

    @GetMapping
    public List<ProductEntity> getAllProducts(@RequestParam(defaultValue = "") String title,
                                              @RequestParam(defaultValue = "id") String sortBy,
                                              @RequestParam(defaultValue = "0") Integer pageNumber){
        return productRepository.findByTitleContainingIgnoreCase(title,
                PageRequest.of(pageNumber,PAGE_SIZE, Sort.by(sortBy)));

    }
}
