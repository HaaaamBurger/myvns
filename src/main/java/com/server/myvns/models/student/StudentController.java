package com.server.myvns.models.student;

import com.server.myvns.common.controller.SimpleCrudController;
import com.server.myvns.common.repository.StudentRepository;
import com.server.myvns.common.util.RepositoryUtilService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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
        return ResponseEntity.ok(studentService.save(entity));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<StudentDto> removeById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.removeById(id));
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<StudentDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getById(id));
    }

    @Override
    public ResponseEntity<StudentDto> updatedById(Long id, StudentDto entity) {
        return null;
    }
}
