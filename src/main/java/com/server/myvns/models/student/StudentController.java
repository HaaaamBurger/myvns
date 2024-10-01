package com.server.myvns.models.student;

import com.server.myvns.common.controllers.SimpleCrudController;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController implements SimpleCrudController<StudentDto> {

    private final StudentService studentService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields("id", "timestamp");
    }

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

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<StudentDto> updatedById(@PathVariable Long id, @Valid @RequestBody StudentDto entity) {
        return ResponseEntity.ok(studentService.updatedById(id, entity));
    }
}
