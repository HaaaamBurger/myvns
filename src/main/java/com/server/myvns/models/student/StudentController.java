package com.server.myvns.models.student;

import com.server.myvns.common.controller.SimpleCrudController;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController implements SimpleCrudController<StudentDto> {

    private final StudentService studentService;

    @GetMapping
    @Override
    public ResponseEntity<List<StudentDto>> getAll(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "1") Integer size
    ) {
        return ResponseEntity.ok(studentService.getAll(page, size));
    }

    @PostMapping
    @Override
    public ResponseEntity<StudentDto> save(@Valid @RequestBody StudentDto entity) {
        System.out.println(entity);
        return ResponseEntity.ok(studentService.save(entity));
    }

    @Override
    public ResponseEntity<StudentDto> removeById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<StudentDto> getById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<StudentDto> updatedById(Long id, StudentDto entity) {
        return null;
    }
}
