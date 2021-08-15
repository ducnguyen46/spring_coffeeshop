package com.coffee.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coffee.dto.OrderDto;
import com.coffee.dto.UserDto;
import com.coffee.entity.Bill;
import com.coffee.entity.DeliveryInfo;
import com.coffee.entity.Item;
import com.coffee.entity.Order;
import com.coffee.entity.Shipment;
import com.coffee.entity.User;
import com.coffee.entity.Voucher;
import com.coffee.model.ItemModel;
import com.coffee.model.OrderModel;
import com.coffee.model.UserModel;
import com.coffee.repository.BillRepository;
import com.coffee.repository.DeliveryInfoRepository;
import com.coffee.repository.ItemRepository;
import com.coffee.repository.OrderRepository;
import com.coffee.repository.ShipmentRepository;
import com.coffee.repository.UserRepository;
import com.coffee.repository.VoucherRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private VoucherRepository voucherRepository;

	@Autowired
	private ShipmentRepository shipmentRepository;

	@Autowired
	private BillRepository billRepository;

	@Autowired
	private DeliveryInfoRepository deliveryInfoRepository;

	@Transactional
	public boolean createOrder(OrderDto orderDto) {
		double amount = 0;

		Order order = new Order();

		order.setOrderDate(new Date(System.currentTimeMillis()));

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUserName = authentication.getName();

			User user = userRepository.getUserByUsername(currentUserName).get(0);
			order.setUser(user);
			return false;
		}

		if (orderDto.getVoucherId() != null) {
			Voucher voucher = voucherRepository.getById(orderDto.getVoucherId());
			order.setVoucher(voucher);
			
			amount -= voucher.getValue();
		}

		Order orderSaved = orderRepository.save(order);

		// chuyen itemmodel ve item
		for (ItemModel itemModel : orderDto.getItems()) {
			Item item = new Item(itemModel);
			item.setOrder(orderSaved);
			itemRepository.save(item);

			amount += itemModel.getPriceIn();
		}

		// tao shipment
		Shipment shipment = new Shipment();

		DeliveryInfo deliveryInfo = deliveryInfoRepository.getById(orderDto.getDeliveryId());
		shipment.setOrder(orderSaved);
		shipment.setDeliveryInfo(deliveryInfo);
		shipment.setIsCompleted("false");
		shipment.setShipperId("HN001");
		shipment.setShipperName("Nguyen Ngoc Duc");
		shipment.setShipperPhone("0961465453");

		shipmentRepository.save(shipment);

		Bill bill = new Bill();
		bill.setOrder(orderSaved);
		bill.setAmount(amount);

		billRepository.save(bill);
		
		return true;
	}

	public List<OrderModel> getAllOrders() {
		List<OrderModel> orderModels = new ArrayList<>();

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			String currentUserName = authentication.getName();
			User user = userRepository.getUserByUsername(currentUserName).get(0);

			List<Order> orders = orderRepository.findByUser(user);

			for (Order order : orders) {
				OrderModel orderModel = new OrderModel(order);
				orderModels.add(orderModel);
			}
		}

		return orderModels;
	}
}
