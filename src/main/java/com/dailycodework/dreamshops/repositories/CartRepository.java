package com.dailycodework.dreamshops.repositories;

import com.dailycodework.dreamshops.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    void deleteCartById(Long id);

    Cart findByUserId(Long userId);


}
