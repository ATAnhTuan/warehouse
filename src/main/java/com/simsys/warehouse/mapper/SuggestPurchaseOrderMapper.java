package com.simsys.warehouse.mapper;

import com.simsys.warehouse.entity.SuggestPurchaseOrderEntity;
import com.simsys.warehouse.entity.SuggestPurchaseOrderProductEntity;
import com.simsys.warehouse.requestdto.SuggestPurchaseOrderRequestDto;
import com.simsys.warehouse.responsedto.SuggestPurchaseOrderProductResponseDto;
import com.simsys.warehouse.responsedto.SuggestPurchaseOrderResponseDto;

import java.util.List;

public class SuggestPurchaseOrderMapper {

    public static SuggestPurchaseOrderEntity toEntity(SuggestPurchaseOrderRequestDto dto) {
        SuggestPurchaseOrderEntity entity = new SuggestPurchaseOrderEntity();
        entity.setQuantity(dto.getQuantity());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setIsActive(dto.getIsActive());
        entity.setUserGuid(dto.getUserGuid());
        entity.setSupplierGuid(dto.getSupplierGuid());

        List<SuggestPurchaseOrderProductEntity> productEntities = dto.getProducts().stream()
                .map(productDto -> {
                    SuggestPurchaseOrderProductEntity product = new SuggestPurchaseOrderProductEntity();
                    product.setProductGuid(productDto.getProductGuid());
                    product.setQuantity(productDto.getQuantity());
                    product.setPrice(productDto.getPrice());
                    product.setSuggestOrder(entity);
                    return product;
                }).toList();

        entity.setProducts(productEntities);
        return entity;
    }

    public static SuggestPurchaseOrderResponseDto toResponseDto(SuggestPurchaseOrderEntity entity) {
        List<SuggestPurchaseOrderProductResponseDto> productDtos = entity.getProducts().stream()
                .map(product -> {
                    SuggestPurchaseOrderProductResponseDto dto = new SuggestPurchaseOrderProductResponseDto();
                    dto.setProductGuid(product.getProductGuid());
                    dto.setQuantity(product.getQuantity());
                    dto.setPrice(product.getPrice());
                    return dto;
                }).toList();

        SuggestPurchaseOrderResponseDto dto = new SuggestPurchaseOrderResponseDto();
        dto.setId(entity.getId());
        dto.setGuid(entity.getGuid());
        dto.setQuantity(entity.getQuantity());
        dto.setDescription(entity.getDescription());
        dto.setPrice(entity.getPrice());
        dto.setIsActive(entity.getIsActive());
        dto.setCreateDate(entity.getCreateDate());
        dto.setUserGuid(entity.getUserGuid());
        dto.setSupplierGuid(entity.getSupplierGuid());
        dto.setProducts(productDtos);
        return dto;
    }
}
