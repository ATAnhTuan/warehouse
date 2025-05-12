package com.simsys.warehouse.service;

import com.simsys.warehouse.entity.SuggestPurchaseOrderEntity;
import com.simsys.warehouse.mapper.SuggestPurchaseOrderMapper;
import com.simsys.warehouse.repository.SuggestPurchaseOrderRepository;
import com.simsys.warehouse.requestdto.SuggestPurchaseOrderRequestDto;
import com.simsys.warehouse.responsedto.SuggestPurchaseOrderResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuggestPurchaseOrderService {

    private final SuggestPurchaseOrderRepository suggestOrderRepository;

    public SuggestPurchaseOrderService(SuggestPurchaseOrderRepository suggestOrderRepository) {
        this.suggestOrderRepository = suggestOrderRepository;
    }

    public SuggestPurchaseOrderResponseDto create(SuggestPurchaseOrderRequestDto dto) {
        SuggestPurchaseOrderEntity entity = SuggestPurchaseOrderMapper.toEntity(dto);
        SuggestPurchaseOrderEntity saved = suggestOrderRepository.save(entity);
        return SuggestPurchaseOrderMapper.toResponseDto(saved);
    }

    public List<SuggestPurchaseOrderResponseDto> findAll() {
        return suggestOrderRepository.findAll().stream()
                .map(SuggestPurchaseOrderMapper::toResponseDto)
                .toList();
    }

    public SuggestPurchaseOrderResponseDto findById(Long id) {
        SuggestPurchaseOrderEntity entity = suggestOrderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Suggest Order not found"));
        return SuggestPurchaseOrderMapper.toResponseDto(entity);
    }

    public void deleteById(Long id) {
        suggestOrderRepository.deleteById(id);
    }
}
