package com.devlimas.repositories;

import com.devlimas.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Produto p WHERE p.productName = :name")
    List<Product> findByProductName(@Param("name") String productName);
}
