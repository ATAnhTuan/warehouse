package com.simsys.warehouse.service;

import com.simsys.warehouse.entity.CategoryEntity;
import com.simsys.warehouse.mapper.CategoryMapper;
import com.simsys.warehouse.repository.CategoryRepository;
import com.simsys.warehouse.requestdto.CategoryRequestDto;
import com.simsys.warehouse.responsedto.CategoryResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryEntity create(CategoryRequestDto dto) {
        CategoryEntity category = CategoryMapper.toEntity(dto);
        return categoryRepository.save(category);
    }

    public List<CategoryResponseDto> findAll() {
        List<CategoryEntity> categories = categoryRepository.findAll();
        return CategoryMapper.toResponseDtoList(categories);
    }

    public Optional<CategoryResponseDto> findById(Long id) {
        return categoryRepository.findById(id)
                .map(CategoryMapper::toResponseDto);
    }

    public Optional<CategoryResponseDto> update(Long id, CategoryRequestDto dto) {
        return categoryRepository.findById(id)
                .map(existing -> {
                    existing.setName(dto.getName());
                    existing.setDescription(dto.getDescription());
                    return CategoryMapper.toResponseDto(categoryRepository.save(existing));
                });
    }

    public boolean delete(Long id) {
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<CategoryEntity> findAllEntities() {
        return categoryRepository.findAll();
    }
}
