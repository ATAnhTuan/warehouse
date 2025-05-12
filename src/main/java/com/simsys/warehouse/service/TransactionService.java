package com.simsys.warehouse.service;

import com.simsys.warehouse.entity.TransactionEntity;
import com.simsys.warehouse.mapper.TransactionMapper;
import com.simsys.warehouse.repository.TransactionRepository;
import com.simsys.warehouse.requestdto.TransactionRequestDto;
import com.simsys.warehouse.responsedto.TransactionResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public TransactionEntity create(TransactionRequestDto dto) {
        TransactionEntity transaction = TransactionMapper.toEntity(dto);
        return transactionRepository.save(transaction);
    }

    public List<TransactionResponseDto> findAll() {
        return TransactionMapper.toResponseDtoList(transactionRepository.findAll());
    }

    public Optional<TransactionEntity> findById(Long id) {
        return transactionRepository.findById(id);
    }

    public Optional<TransactionEntity> update(Long id, TransactionRequestDto dto) {
        return transactionRepository.findById(id).map(existing -> {
            existing.setMoney(dto.getMoney());
            existing.setDescription(dto.getDescription());
            return transactionRepository.save(existing);
        });
    }

    public boolean delete(Long id) {
        if (transactionRepository.existsById(id)) {
            transactionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
