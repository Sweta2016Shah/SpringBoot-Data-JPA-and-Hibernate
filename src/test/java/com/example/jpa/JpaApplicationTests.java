package com.example.jpa;

import com.example.jpa.entities.ProductEntity;
import com.example.jpa.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class JpaApplicationTests {

	@Autowired
	private ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

//	@Test
//	void testRepository(){
//		ProductEntity productEntity = ProductEntity.builder()
//				.sku("Ness")
//				.title("nes cho")
//				.price(BigDecimal.valueOf(12.1))
//				.quantity(12)
//				.build();
//		ProductEntity saveEntity = productRepository.save(productEntity);
//		System.out.println(saveEntity);
//	}

	@Test
	void getRepository(){
		List<ProductEntity> allProduct = productRepository
				.findByCreatedAtAfter(LocalDateTime.of(2026,4,5,0,0,0));
		System.out.println(allProduct);
	}

}
