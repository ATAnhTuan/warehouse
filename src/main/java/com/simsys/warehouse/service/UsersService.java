package com.simsys.warehouse.service;

import com.simsys.warehouse.entity.UsersEntity;
import com.simsys.warehouse.mapper.UsersMapper;
import com.simsys.warehouse.repository.UsersRepository;
import com.simsys.warehouse.requestdto.UsersRequestDto;
import com.simsys.warehouse.responsedto.UsersResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UsersResponseDto create(UsersRequestDto dto) {
        UsersEntity user = UsersMapper.toEntity(dto);
        UsersEntity saved = usersRepository.save(user);
        return UsersMapper.toResponseDto(saved);
    }

    public List<UsersResponseDto> findAll() {
        return UsersMapper.toResponseDtoList(usersRepository.findAll());
    }

    public Optional<UsersResponseDto> findById(Long id) {
        return usersRepository.findById(id).map(UsersMapper::toResponseDto);
    }

    public Optional<UsersResponseDto> update(Long id, UsersRequestDto dto) {
        return usersRepository.findById(id).map(existing -> {
            existing.setUsername(dto.getUsername());
            existing.setPassword(dto.getPassword());
            existing.setEmail(dto.getEmail());
            existing.setContactInfo(dto.getContactInfo());
            existing.setIsActive(dto.getActive());
            existing.setRoleGuid(dto.getRoleGuid());
            return UsersMapper.toResponseDto(usersRepository.save(existing));
        });
    }

    public boolean delete(Long id) {
        if (usersRepository.existsById(id)) {
            usersRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
