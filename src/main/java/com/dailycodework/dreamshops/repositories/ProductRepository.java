package com.dailycodework.dreamshops.repositories;

import com.dailycodework.dreamshops.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByCategoryName(String category);
    List<Product> findByBrand(String brand);
    List<Product> findByCategoryNameAndBrand(String category, String brand);
    List<Product> findByName(String name);
    List<Product> findByBrandAndName(String brand, String name);
    Long countByBrandAndName(String brand, String name);



//    List<Product> getAllProducts();
//    List<Product> getProductsByCategory(String category);
//    List<Product> getProductsByBrand(String brand);
//    List<Product> getProductsByCategoryAndBrand(String category, String brand);
//    List<Product> getProductsByName(String name);
//    List<Product> getProductByBrandAndName(String brand, String name);

}
