package com.cg.cars.dao;

<<<<<<< HEAD
import java.util.List;

import com.cg.cars.entities.Payment;

public interface IPaymentRepository {
	public Payment addPayment(Payment payment);
	public Payment removePayment(long id);
	public Payment updatePayment(long id, Payment payment);
	public Payment getPaymentDetails(long id);
	public List<Payment> getAllPaymentDetails();
=======
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.cars.entities.Payment;

@Repository
public interface IPaymentRepository extends JpaRepository<Payment,Integer> {

>>>>>>> refs/remotes/origin/avinash
}
