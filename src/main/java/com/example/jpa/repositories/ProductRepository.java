package com.example.jpa.repositories;

import com.example.jpa.entities.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

//    List<ProductEntity> findByTitle(String title);

    List<ProductEntity> findByCreatedAtAfter(LocalDateTime after);

    List<ProductEntity> findByQuantityGreaterThanOrPriceLessThan(int quantity, BigDecimal price);

    List<ProductEntity> findByTitleLike(String title);

    List<ProductEntity> findByTitleContaining(String title);

    List<ProductEntity> findByTitleContainingIgnoreCase(String title);

//    @Query("select e from ProductEntity e where e.title =?1 and e,price =?2")
//    or,
//    @Query("select e from ProductEntity e where e.title =:title and e,price =:price")
    ProductEntity findByTitleAndPrice(String title, BigDecimal price);

    //for sorting, we can use orderBy, Asc and Desc
    List<ProductEntity> findByOrderByPrice(); //this is tightly coupled so we can use SortBy for loose Coupling

    List<ProductEntity> findBy(Sort sortBy);

    //Pagination
    List<ProductEntity> findByTitleContainingIgnoreCase(String title, Pageable pageable);
}
