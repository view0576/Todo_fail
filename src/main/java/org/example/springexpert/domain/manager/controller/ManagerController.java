package org.example.springexpert.domain.manager.controller;

import lombok.RequiredArgsConstructor;
import org.example.springexpert.domain.manager.dto.request.ManagerSaveRequestDto;
import org.example.springexpert.domain.manager.dto.response.ManagerSimpleResponseDto;
import org.example.springexpert.domain.manager.service.ManagerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;

    @PostMapping("/todos/{todoId}/managers")
    public void saveManager(@PathVariable Long todoId, @RequestBody ManagerSaveRequestDto managerSaveRequestDto) {
        managerService.saveManager(todoId, managerSaveRequestDto);
    }

    @GetMapping("/todos/{todoId}/managers")
    public List<ManagerSimpleResponseDto> getManagers(@PathVariable Long todoId) {
        return managerService.getManagers(todoId);
    }

    @GetMapping("/todos/{todoId}/managers/optimized")
    public List<ManagerSimpleResponseDto> getManagersOptimized(@PathVariable Long todoId) {
        return managerService.getManagersOptimized(todoId);
    }

    // @DeleteMapping은 한 번 스스로 해보세요!
}
