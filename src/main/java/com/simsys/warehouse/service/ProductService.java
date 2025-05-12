package com.simsys.warehouse.service;

import com.simsys.warehouse.entity.ProductEntity;
import com.simsys.warehouse.entity.VariantEntity;
import com.simsys.warehouse.mapper.ProductMapper;
import com.simsys.warehouse.repository.ProductRepository;
import com.simsys.warehouse.repository.VariantRepository;
import com.simsys.warehouse.requestdto.ProductRequestDto;
import com.simsys.warehouse.responsedto.ProductResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final VariantRepository variantRepository;

    public ProductService(ProductRepository productRepository, VariantRepository variantRepository) {
        this.productRepository = productRepository;
        this.variantRepository = variantRepository;
    }

    public ProductEntity create(ProductRequestDto dto) {
        ProductEntity product = ProductMapper.toEntity(dto);

        if (dto.getVariantGuid() != null) {
            VariantEntity variant = variantRepository.findByGuid(dto.getVariantGuid())
                    .orElseThrow(() -> new RuntimeException("Variant not found with guid: " + dto.getVariantGuid()));
            product.setVariant(variant);
        }

        return productRepository.save(product);
    }

    public List<ProductResponseDto> findAll() {
        return ProductMapper.toResponseDtoList(productRepository.findAll());
    }

    public Optional<ProductEntity> findById(Long id) {
        return productRepository.findById(id);
    }

    public Optional<ProductEntity> update(Long id, ProductRequestDto dto) {
        return productRepository.findById(id)
                .map(existing -> {
                    existing.setName(dto.getName());
                    existing.setQuantity(dto.getQuantity());
                    existing.setDescription(dto.getDescription());
                    existing.setStatus(dto.getStatus());
                    existing.setCategoryGuid(dto.getCategoryGuid());

                    if (dto.getVariantGuid() != null) {
                        VariantEntity variant = variantRepository.findByGuid(dto.getVariantGuid())
                                .orElseThrow(() -> new RuntimeException("Variant not found with guid: " + dto.getVariantGuid()));
                        existing.setVariant(variant);
                    } else {
                        existing.setVariant(null);
                    }

                    return productRepository.save(existing);
                });
    }

    public boolean delete(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
