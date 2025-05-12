package com.simsys.warehouse.service;

import com.simsys.warehouse.entity.VariantEntity;
import com.simsys.warehouse.mapper.VariantMapper;
import com.simsys.warehouse.repository.VariantRepository;
import com.simsys.warehouse.requestdto.VariantRequestDto;
import com.simsys.warehouse.responsedto.VariantResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VariantService {

    private final VariantRepository variantRepository;

    public VariantService(VariantRepository variantRepository) {
        this.variantRepository = variantRepository;
    }

    public VariantEntity create(VariantRequestDto dto) {
        VariantEntity variant = VariantMapper.toEntity(dto);
        return variantRepository.save(variant);
    }

    public List<VariantResponseDto> findAll() {
        return VariantMapper.toResponseDtoList(variantRepository.findAll());
    }

    public Optional<VariantEntity> findById(Long id) {
        return variantRepository.findById(id);
    }

    public Optional<VariantEntity> update(Long id, VariantRequestDto dto) {
        return variantRepository.findById(id)
                .map(existing -> {
                    existing.setColor(dto.getColor());
                    existing.setSize(dto.getSize());
                    return variantRepository.save(existing);
                });
    }

    public boolean delete(Long id) {
        if (variantRepository.existsById(id)) {
            variantRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
