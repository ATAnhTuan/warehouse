package com.simsys.warehouse.repository;

import com.simsys.warehouse.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByCategoryGuid(UUID categoryGuid);
    List<ProductEntity> findByNameContainingIgnoreCase(String name); // tìm gần đúng
    List<ProductEntity> findByVariant_Guid(UUID variantGuid); // nếu Variant là entity
}
