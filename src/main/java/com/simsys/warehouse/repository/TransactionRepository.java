package com.simsys.warehouse.repository;

import com.simsys.warehouse.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Integer> {
}
