package com.empresa.buscaloproductapi.persistence.repository;

import com.empresa.buscaloproductapi.persistence.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
