package com.dailycodework.dreamshops.controllers;

import com.dailycodework.dreamshops.DTO.OrderDto;
import com.dailycodework.dreamshops.exceptions.ResourceNotFoundException;
import com.dailycodework.dreamshops.model.Order;
import com.dailycodework.dreamshops.response.ApiResponse;
import com.dailycodework.dreamshops.services.order.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/orders")
public class OrderController {
    private final IOrderService iOrderService;


    @PostMapping("/order")
    public ResponseEntity<ApiResponse> createOrder(@RequestParam Long userId){
        try {
            Order order = iOrderService.placeOrder(userId);
            OrderDto orderDto = iOrderService.convertToDto(order);
            return ResponseEntity.ok(new ApiResponse("Item Order Success!", orderDto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse("Error Occured!",e.getMessage()));
        }
    }

    @GetMapping("/{orderId}/order")
    public ResponseEntity<ApiResponse> getOrderById(@PathVariable Long orderId){
        try {
            OrderDto order = iOrderService.getOrder(orderId);
            return ResponseEntity.ok(new ApiResponse("Item Order Success!", order));
        } catch (ResourceNotFoundException e) {
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Oops!",e.getMessage()));
        }
    }


    @GetMapping("/{userId}/orders")
    public ResponseEntity<ApiResponse> getUserOrders(@PathVariable Long userId){
        try {
            List<OrderDto> userOrders = iOrderService.getUserOrders(userId);
            return ResponseEntity.ok(new ApiResponse("User Orders Success!", userOrders));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Oops!",e.getMessage()));
        }
    }
}
