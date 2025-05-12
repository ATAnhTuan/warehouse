package com.simsys.warehouse.service;

import com.simsys.warehouse.entity.CustomerEntity;
import com.simsys.warehouse.mapper.CustomerMapper;
import com.simsys.warehouse.repository.CustomerRepository;
import com.simsys.warehouse.requestdto.CustomerRequestDto;
import com.simsys.warehouse.responsedto.CustomerResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerEntity create(CustomerRequestDto dto) {
        CustomerEntity customer = CustomerMapper.toEntity(dto);
        return customerRepository.save(customer);
    }

    public List<CustomerResponseDto> findAll() {
        return CustomerMapper.toResponseDtoList(customerRepository.findAll());
    }

    public Optional<CustomerEntity> findById(Long id) {
        return customerRepository.findById(id);
    }

    public Optional<CustomerEntity> update(Long id, CustomerRequestDto dto) {
        return customerRepository.findById(id).map(existing -> {
            existing.setName(dto.getName());
            existing.setPhone(dto.getPhone());
            existing.setEmail(dto.getEmail());
            existing.setAddress(dto.getAddress());
            existing.setBankCard(dto.getBankCard());
            return customerRepository.save(existing);
        });
    }

    public boolean delete(Long id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
