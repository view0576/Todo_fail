package org.example.springexpert.domain.todo.controller;

import lombok.RequiredArgsConstructor;
import org.example.springexpert.domain.todo.dto.request.TodoSaveRequestDto;
import org.example.springexpert.domain.todo.dto.request.TodoUpdateRequestDto;
import org.example.springexpert.domain.todo.dto.response.TodoSimpleResponseDto;
import org.example.springexpert.domain.todo.dto.response.TodoDetailResponseDto;
import org.example.springexpert.domain.todo.dto.response.TodoSaveResponseDto;
import org.example.springexpert.domain.todo.dto.response.TodoUpdateResponseDto;
import org.example.springexpert.domain.todo.service.TodoService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/todos")
    public ResponseEntity<TodoSaveResponseDto> saveTodo(@RequestBody TodoSaveRequestDto todoSaveRequestDto) {
        return ResponseEntity.ok(todoService.saveTodo(todoSaveRequestDto));
    }

    @GetMapping("/todos")
    public ResponseEntity<Page<TodoDetailResponseDto>> getTodos(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(todoService.getTodos(page, size));
    }

    // 최적화한 getTodos
    @GetMapping("/todos/optimized")
    public ResponseEntity<Page<TodoDetailResponseDto>> getTodosOptimized(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(todoService.getTodosOptimized(page, size));
    }

    @GetMapping("/todos/{todoId}")
    public ResponseEntity<TodoSimpleResponseDto> getTodo(@PathVariable Long todoId) {
        return ResponseEntity.ok(todoService.getTodo(todoId));
    }

    @PutMapping("/todos/{todoId}")
    public ResponseEntity<TodoUpdateResponseDto> updateTodo(@PathVariable Long todoId, @RequestBody TodoUpdateRequestDto todoUpdateRequestDto) {
        return ResponseEntity.ok(todoService.updateTodo(todoId, todoUpdateRequestDto));
    }

    @DeleteMapping("/todos/{todoId}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long todoId) {
        todoService.deleteTodo(todoId);
        return ResponseEntity.ok().build();
    }
}
