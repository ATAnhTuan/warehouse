package com.simsys.warehouse.repository;

import com.simsys.warehouse.entity.UsersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, Long> {
    boolean existsByGuid(UUID guid);

    Optional<UsersEntity> findByUsername(String username);

}
