package com.simsys.warehouse.service;

import com.simsys.warehouse.entity.CategoryEntity;
import com.simsys.warehouse.entity.ProductEntity;
import com.simsys.warehouse.entity.VariantEntity;
import com.simsys.warehouse.mapper.ProductMapper;
import com.simsys.warehouse.repository.CategoryRepository;
import com.simsys.warehouse.repository.ProductRepository;
import com.simsys.warehouse.repository.VariantRepository;
import com.simsys.warehouse.requestdto.ProductRequestDto;
import com.simsys.warehouse.responsedto.ProductResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final VariantRepository variantRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, VariantRepository variantRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.variantRepository = variantRepository;
        this.categoryRepository = categoryRepository;
    }

    public ProductEntity create(ProductRequestDto dto) {
        ProductEntity product = ProductMapper.toEntity(dto);

        if (dto.getVariantGuid() != null) {
            VariantEntity variant = variantRepository.findByGuid(dto.getVariantGuid())
                    .orElseThrow(() -> new RuntimeException("Variant not found with guid: " + dto.getVariantGuid()));
            product.setVariant(variant);
        } else {
            product.setVariant(null);
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
                    existing.setImage(dto.getImage());
                    existing.setConsignmentGuid(dto.getConsignmentGuid());
                    existing.setPrice(dto.getPrice());

                    if (dto.getVariantGuid() != null) {
                        VariantEntity variant = variantRepository.findByGuid(dto.getVariantGuid())
                                .orElseThrow(() -> new RuntimeException("Variant not found with guid: " + dto.getVariantGuid()));
                        existing.setVariant(variant);
                    }

                    if (dto.getCategoryGuid() != null) {
                        CategoryEntity category = categoryRepository.findByGuid(dto.getCategoryGuid())
                                .orElseThrow(() -> new RuntimeException("Category not found with guid: " + dto.getCategoryGuid()));
                        existing.setCategory(category);
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

    public List<ProductResponseDto> findByCategoryGuid(UUID categoryGuid) {
        return ProductMapper.toResponseDtoList(productRepository.findByCategoryGuid(categoryGuid));
    }

    public List<ProductResponseDto> findByProductName(String name) {
        return ProductMapper.toResponseDtoList(productRepository.findByNameContainingIgnoreCase(name));
    }

    public List<ProductResponseDto> findByVariantGuid(UUID variantGuid) {
        return ProductMapper.toResponseDtoList(productRepository.findByVariant_Guid(variantGuid));
    }
}
