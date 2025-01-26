package com.thuta.trading_backend.controller;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thuta.trading_backend.entity.Coin;
import com.thuta.trading_backend.entity.Order;
import com.thuta.trading_backend.entity.User;
import com.thuta.trading_backend.enums.ORDER_TYPE;
import com.thuta.trading_backend.request.CreateOrderRequest;
import com.thuta.trading_backend.response.DataResponse;
import com.thuta.trading_backend.service.coin.ICoinService;
import com.thuta.trading_backend.service.order.IOrderService;
import com.thuta.trading_backend.service.user.IUserService;
import com.thuta.trading_backend.service.wallet_transaction.IWalletTransactionService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("${api.prefix}/order")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @Autowired
    private IUserService userService;

    @Autowired
    private ICoinService coinService;

    @SuppressWarnings("unused")
    @Autowired
    private IWalletTransactionService walletTransactionService;

    @PostMapping("/pay")
    public ResponseEntity<DataResponse> payOrderPayment(
            @RequestHeader("Authorization") String jwt,
            @RequestBody CreateOrderRequest req) {
        try {
            User user = userService.findUserProfileByJwt(jwt);
            Coin coin = coinService.findById(req.getCoinId());

            Order order = orderService.processOrder(coin, req.getQuantity(), req.getOrderType(), user);

            return ResponseEntity.ok(new DataResponse("pay order payment", order));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new DataResponse("An unexpected error occurred", null));
        }
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<DataResponse> getOrderById(
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long orderId) {
        try {
            User user = userService.findUserProfileByJwt(jwt);

            Order order = orderService.getOrderById(orderId);

            if (order.getUser().getId().equals(user.getId())) {
                return ResponseEntity.ok(new DataResponse("get order by Id", order));
            }
            return ResponseEntity.status(NOT_FOUND)
                    .body(new DataResponse("Order not found", null));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new DataResponse("An unexpected error occurred", null));
        }
    }

    @GetMapping("/")
    public ResponseEntity<DataResponse> getAllOrdersForUser(
            @RequestHeader("Authorization") String jwt,
            @RequestParam(required = false) ORDER_TYPE orderType,
            @RequestParam(required = false) String asset_symbol) {
        try {
            User user = userService.findUserProfileByJwt(jwt);

            List<Order> orders = orderService.getAllOrdersOfUser(user.getId(), orderType, asset_symbol);

            return ResponseEntity.ok(new DataResponse("get all orders for user", orders));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR)
                    .body(new DataResponse("An unexpected error occurred", null));
        }
    }
}
