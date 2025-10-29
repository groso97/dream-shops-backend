package com.dailycodework.dreamshops.services.cart;

import com.dailycodework.dreamshops.model.Cart;
import com.dailycodework.dreamshops.model.User;

import java.math.BigDecimal;

public interface ICartService {
    Cart getCartById(Long id);
    void clearCart(Long id);
    BigDecimal getTotalPrice(Long id);

    Cart initializeNewCart(User user);

    Cart getCartByUserId(Long userId);
}
