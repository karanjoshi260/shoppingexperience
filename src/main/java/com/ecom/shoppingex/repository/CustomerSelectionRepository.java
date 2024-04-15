package com.ecom.shoppingex.repository;

import com.ecom.shoppingex.entity.shopper.CustomerSelection;
import com.ecom.shoppingex.entity.shopper.CustomerSelectionPK;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerSelectionRepository extends JpaRepository<CustomerSelection, CustomerSelectionPK>, JpaSpecificationExecutor<CustomerSelection> {

    Page<CustomerSelection> findAll(Specification specification, Pageable pageable);
}
