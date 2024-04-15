package com.ecom.shoppingex.shopper.repository;

import com.ecom.shoppingex.shopper.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

}
