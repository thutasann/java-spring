package com.thuta.trading_backend.service.order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thuta.trading_backend.entity.Asset;
import com.thuta.trading_backend.entity.Coin;
import com.thuta.trading_backend.entity.Order;
import com.thuta.trading_backend.entity.OrderItem;
import com.thuta.trading_backend.entity.User;
import com.thuta.trading_backend.enums.ORDER_STATUS;
import com.thuta.trading_backend.enums.ORDER_TYPE;
import com.thuta.trading_backend.repository.OrderItemRepository;
import com.thuta.trading_backend.repository.OrderRepository;
import com.thuta.trading_backend.service.asset.IAssetService;
import com.thuta.trading_backend.service.wallet.IWalletService;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private OrderItemRepository orderItemRepo;

    @Autowired
    private IWalletService walletService;

    @Autowired
    private IAssetService assetService;

    @Override
    public Order getOrderById(Long orderId) throws Exception {
        Optional<Order> order = orderRepo.findById(orderId);
        if (order.isEmpty()) {
            throw new Exception("Order not found with this Id " + orderId);
        }
        return order.get();
    }

    @Override
    public Order createOrder(User user, OrderItem orderItem, ORDER_TYPE orderType) throws Exception {

        double price = orderItem.getCoin().getCurrentPrice() * orderItem.getQuantity();

        Order order = new Order();
        order.setUser(user);
        order.setOrderItem(orderItem);
        order.setOrderType(orderType);
        order.setPrice(BigDecimal.valueOf(price));
        order.setTimestamp(LocalDateTime.now());
        order.setStatus(ORDER_STATUS.PENDING);

        return orderRepo.save(order);
    }

    @Override
    public List<Order> getAllOrdersOfUser(Long userId, ORDER_TYPE orderType, String assetSymbol) throws Exception {
        return orderRepo.findByUserId(userId);
    }

    @Override
    public Order processOrder(Coin coin, double quantity, ORDER_TYPE orderType, User user) {
        return null;
    }

    @Override
    @Transactional
    public Order buyAsset(Coin coin, double quantity, User user, Asset assetToBuy) throws Exception {
        // check quantity
        if (quantity <= 0) {
            throw new Exception("Quantity should be >0");
        }

        // get buy price
        double buyPrice = coin.getCurrentPrice();

        // create order item
        OrderItem orderItem = this.createOrderItem(quantity, coin, buyPrice, 0);

        // create order
        Order order = this.createOrder(user, orderItem, ORDER_TYPE.BUY);
        orderItem.setOrder(order);

        // pay order payment
        walletService.payOrderPayment(order, user);

        // set status and order_type
        order.setStatus(ORDER_STATUS.SUCCESS);
        order.setOrderType(ORDER_TYPE.BUY);

        // save order
        Order savedOrder = orderRepo.save(order);

        // create asset
        Asset createdAsset = assetService.createAsset(assetToBuy);
        createdAsset.setQuantity(quantity);

        return savedOrder;
    }

    @Override
    public Order sellAsset(Coin coin, double quantity, User user, Asset assetToSell) throws Exception {
        // check quantity
        if (quantity <= 0) {
            throw new Exception("Quantity should be >0");
        }

        // get buy price, sell price
        double sellPrice = coin.getCurrentPrice();
        double buyPrice = 0;

        // create order item
        OrderItem orderItem = this.createOrderItem(quantity, coin, buyPrice, sellPrice);

        // create order
        Order order = this.createOrder(user, orderItem, ORDER_TYPE.SELL);

        orderItem.setOrder(order);

        if (assetToSell.getQuantity() >= quantity) {
            order.setStatus(ORDER_STATUS.SUCCESS);
            order.setOrderType(ORDER_TYPE.SELL);

            Order savedOrder = orderRepo.save(order);

            // pay order payment
            walletService.payOrderPayment(order, user);

            // update asset
            Asset updatedAsset = assetService.updateAsset(assetToSell.getId(),
                    -quantity);

            if (updatedAsset.getQuantity() * coin.getCurrentPrice() <= 1) {
                assetService.deleteAsset(updatedAsset.getId());
            }

            return savedOrder;
        }
        throw new Exception("Insufficient quantity to sell");
    }

    /**
     * Create Order Item
     * 
     * @param quantity  - quantity
     * @param coin      - coin
     * @param buyPrice  - buy price
     * @param sellPrice - sell price
     * @return
     */
    private OrderItem createOrderItem(
            double quantity,
            Coin coin,
            double buyPrice,
            double sellPrice) {

        OrderItem orderItem = new OrderItem();
        orderItem.setCoin(coin);
        orderItem.setQuantity(quantity);
        orderItem.setBuyPrice(buyPrice);
        orderItem.setSellPrice(sellPrice);

        return orderItemRepo.save(orderItem);
    }
}
