package com.simsys.warehouse.controller;

import com.simsys.warehouse.entity.CustomerEntity;
import com.simsys.warehouse.mapper.CustomerMapper;
import com.simsys.warehouse.requestdto.CustomerRequestDto;
import com.simsys.warehouse.responsedto.CustomerResponseDto;
import com.simsys.warehouse.service.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@Tag(name = "Customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerResponseDto> create(@RequestBody CustomerRequestDto dto) {
        CustomerEntity customer = customerService.create(dto);
        return ResponseEntity.ok(CustomerMapper.toResponseDto(customer));
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseDto>> findAll() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> findById(@PathVariable Long id) {
        return customerService.findById(id)
                .map(CustomerMapper::toResponseDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> update(@PathVariable Long id, @RequestBody CustomerRequestDto dto) {
        return customerService.update(id, dto)
                .map(CustomerMapper::toResponseDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return customerService.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
