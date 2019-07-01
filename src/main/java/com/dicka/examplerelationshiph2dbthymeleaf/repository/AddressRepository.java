package com.dicka.examplerelationshiph2dbthymeleaf.repository;

import com.dicka.examplerelationshiph2dbthymeleaf.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
