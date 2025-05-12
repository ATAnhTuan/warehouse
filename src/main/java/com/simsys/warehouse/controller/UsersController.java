package com.simsys.warehouse.controller;

import com.simsys.warehouse.requestdto.UsersRequestDto;
import com.simsys.warehouse.responsedto.UsersResponseDto;
import com.simsys.warehouse.service.UsersService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@Tag(name = "Users")
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    public ResponseEntity<UsersResponseDto> create(@RequestBody UsersRequestDto dto) {
        return ResponseEntity.ok(usersService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<UsersResponseDto>> findAll() {
        return ResponseEntity.ok(usersService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsersResponseDto> findById(@PathVariable Long id) {
        return usersService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsersResponseDto> update(@PathVariable Long id, @RequestBody UsersRequestDto dto) {
        return usersService.update(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return usersService.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
