package com.moon.accessDate.JPA.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.moon.accessDate.JPA.entity.M_Customer;
import com.moon.accessDate.JPA.entity.M_Order;

public interface OrderRepository extends CrudRepository<M_Order, Integer>{
	// And
	Iterable<M_Order> findByOrderStatusAndCustomer(Integer orderStatus, M_Customer customer);
	// Or
	Iterable<M_Order> findByOrderStatusOrOrderType(Integer orderStatus, Integer orderType);
	// is equals
	Iterable<M_Order> findByOrderStatus(Integer orderStatus);
	// between 
	Iterable<M_Order> findByOrderDateBetween(Date minDate, Date maxDate);
	// lessThan
	Iterable<M_Order> findByOrderStatusLessThan(Integer maxOrderStatus);
	// lessThan equal
	Iterable<M_Order> findByOrderStatusLessThanEqual(Integer maxOrderStatus);
	// greater than
	Iterable<M_Order> findByOrderStatusGreaterThan(Integer minOrderStatus);
	// greater than equal
	Iterable<M_Order> findByOrderStatusGreaterThanEqual(Integer minOrderStatus);
	// after
	Iterable<M_Order> findByOrderDateAfter(Date minDate);
	// before
	Iterable<M_Order> findByOrderDateBefore(Date maxDate);
	// isNull
	Iterable<M_Order> findByCustomerIsNull();
	// isNotNull
	Iterable<M_Order> findByCustomerIsNotNull();
	// like
	Iterable<M_Order> findByOrderNoLike(String str);
	// not like
	Iterable<M_Order> findByOrderNoNotLike(String str);
	// starting with
	Iterable<M_Order> findByOrderNoStartingWith(String str);
	// ending with
	Iterable<M_Order> findByOrderNoEndingWith(String str);
	// containing 
	Iterable<M_Order> findByOrderNoContaining(String str);
	// in 
	Iterable<M_Order> findByIdIn(List<Integer> ids);
	// not in 
	Iterable<M_Order> findByCustomerNotIn(List<M_Customer> customers);
	// ignore case
	Iterable<M_Order> findByOrderNoIgnoreCase(String orderNo);
	// order by
	Iterable<M_Order> findAllByOrderByOrderDateDesc();
	
	@Query("select o from M_Order o, M_Customer c where o.customer.id = c.id and upper(c.customerName) = upper(?1) or o.orderStatus = ?2")
	Iterable<M_Order> queryByCustomerNameAndOrderStatus(String customerName, Integer orderStatus);
	@Query("select o from M_Order o, M_Customer c where o.customer.id = c.id and upper(c.customerName) like %:customerName% or o.orderStatus = :orderStatus")
	Iterable<M_Order> queryByCustomerNameAndOrderStatus2(String customerName, Integer orderStatus);
	@Query(value = "select o.* from m_order o, m_customer c where o.customer_id = c.id and upper(c.customer_name) = upper(:customerName) or o.order_status = :orderStatus", nativeQuery = true)
	Iterable<M_Order> queryByCustomerNameAndOrderStatus3(String customerName, Integer orderStatus);
	
	@Transactional
	@Modifying(clearAutomatically=true)
	@Query(value="update m_order o set o.order_status=:orderStatus where o.id=(select id from m_order where customer_id=(select c.id from m_customer c where c.customer_name=:customerName))", nativeQuery=true)
	int updateOrderStatus(@Param("customerName") String customerName, @Param("orderStatus") Integer orderStatus);
	
	@Transactional
	@Modifying(clearAutomatically=true)
	@Query("update M_Order o set o.orderStatus=:orderStatus where o.customer=:customer")
	int updateOrderStatus2(@Param("customer") M_Customer customer, @Param("orderStatus") Integer orderStatus);
}
