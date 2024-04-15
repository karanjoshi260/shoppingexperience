package com.ecom.shoppingex.repository;

import com.ecom.shoppingex.entity.shopper.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

}
