package com.edu.serviceIml;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.entity.Customer;
import com.edu.entity.Items;
import com.edu.entity.Medicine;
import com.edu.entity.Order;
import com.edu.exception.ErrorType;
import com.edu.exception.SystemException;
import com.edu.repository.CustomerRepository;
import com.edu.repository.MedicineRepository;
import com.edu.repository.OrderItemRepository;
import com.edu.repository.OrderRepository;
import com.edu.service.OrderService;
import com.edu.utility.OrderStatus;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private OrderItemRepository orderItemRepo;

	@Autowired
	private MedicineRepository medicineRepo;

	@Override
	public Order createOrder(Order orderDetails) throws SystemException {

		Customer customer = customerRepo.findBycustomerId(orderDetails.getCustomer().getCustomerId());
		orderDetails.setCustomer(customer);
		BigDecimal totalAmount = BigDecimal.ZERO;
		for (Items orderItem : orderDetails.getItems()) {
			Medicine medicine = medicineRepo.findBymedicineId(orderItem.getMedicine().getMedicineId());
			orderItem.setMedicine(medicine);

			totalAmount = totalAmount
					.add(BigDecimal.valueOf(orderItem.getQuantity()).multiply(orderItem.getMedicine().getPrice()));

			updateMedicineDetail(BigDecimal.valueOf(orderItem.getQuantity()),
					orderItem.getMedicine().getMedicineId());

		}

		if (orderDetails == null || orderDetails.getItems() == null || orderDetails.getCustomer() == null) {
			throw new SystemException(ErrorType.INVALID_REQUEST, "Invalid Order Details");
		}
		orderDetails.setTotalAmount(totalAmount);
		orderDetails.setStatus(OrderStatus.CREATED.getName());

		return orderRepo.save(orderDetails);
	}

	private void updateMedicineDetail(BigDecimal quantity, String medicineId) {

		medicineRepo.updateSaleAmount(quantity, medicineId);

	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepo.findAll();
	}

	@Override
	public Order getOrderById(Long orderId) {
		return orderRepo.findByorderId(orderId);
	}

	@Override
	public Order updateOrder(Long orderId, Order order) throws SystemException {
		Optional<Order> existingOrderOptional = orderRepo.findById(orderId);

		if (existingOrderOptional.isEmpty()) {
			throw new SystemException(ErrorType.INVALID_REQUEST, "Invalid Order Details");
		}

		Order existingOrder = existingOrderOptional.get();

		existingOrder.setCustomer(order.getCustomer());
		existingOrder.setItems(order.getItems());
		BigDecimal totalAmount = BigDecimal.ZERO;
		for (Items orderItem : order.getItems()) {
			totalAmount = totalAmount.add(orderItem.getMedicine().getUnitPrice());
		}
		existingOrder.setTotalAmount(totalAmount);
		existingOrder.setStatus(order.getStatus());

		Order updatedOrder = orderRepo.save(existingOrder);

		return updatedOrder;
	}

	@Override
	public void deleteOrder(Order order, Long customerId) throws SystemException {
		if (order == null) {
			throw new SystemException(ErrorType.NOT_FOUND, "Invalid customer");
		}
		orderRepo.delete(order);

	}

}
