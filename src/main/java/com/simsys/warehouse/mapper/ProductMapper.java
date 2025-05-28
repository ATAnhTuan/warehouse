package com.simsys.warehouse.mapper;

import com.simsys.warehouse.entity.ProductEntity;
import com.simsys.warehouse.requestdto.ProductRequestDto;
import com.simsys.warehouse.responsedto.CategoryResponseDto;
import com.simsys.warehouse.responsedto.ProductResponseDto;
import com.simsys.warehouse.responsedto.VariantResponseDto;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    // Nếu bạn có thêm image trong request, nhớ thêm getter image vào ProductRequestDto
    public static ProductEntity toEntity(ProductRequestDto dto) {
        ProductEntity entity = new ProductEntity();
        entity.setName(dto.getName());
        entity.setQuantity(dto.getQuantity());
        entity.setDescription(dto.getDescription());
        entity.setStatus(dto.getStatus());
        entity.setCategoryGuid(dto.getCategoryGuid());
        entity.setVariantGuid(dto.getVariantGuid());
         entity.setImage(dto.getImage());
        return entity;
    }

    public static ProductResponseDto toResponseDto(ProductEntity entity) {
        CategoryResponseDto categoryResponseDto = null;
        if (entity.getCategory() != null) {
            categoryResponseDto = CategoryMapper.toResponseDto(entity.getCategory());
        }

        VariantResponseDto variantResponseDto = null;
        if (entity.getVariant() != null) {
            variantResponseDto = VariantMapper.toResponseDto(entity.getVariant());
        }

        return new ProductResponseDto(
                entity.getId(),
                entity.getName(),
                entity.getQuantity(),
                entity.getDescription(),
                entity.getStatus(),
                entity.getImage(),           // Thêm trường image
                entity.getGuid(),
                entity.getCategoryGuid(),
                entity.getVariantGuid(),
                entity.getConsignmentGuid(), // Thêm consignmentGuid
                categoryResponseDto,
                variantResponseDto
        );
    }

    public static List<ProductResponseDto> toResponseDtoList(List<ProductEntity> entities) {
        return entities.stream()
                .map(ProductMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
