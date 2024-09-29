package com.server.myvns.models.department;

import com.server.myvns.common.controller.SimpleCrudController;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/departments")
@RestController
public class DepartmentController implements SimpleCrudController<DepartmentDto> {

    private final DepartmentService departmentService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields("id", "timestamp");
    }

    //TODO Refactor all paging routes. if page and size == null, then show all entities
    @GetMapping
    @Override
    public ResponseEntity<List<DepartmentDto>> getAll(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "1") Integer size) {
        return ResponseEntity.ok(departmentService.getAll(page, size));
    }

    @PostMapping
    @Override
    public ResponseEntity<DepartmentDto> save(@Valid @RequestBody DepartmentDto entity) {
        return ResponseEntity.ok(departmentService.save(entity));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<DepartmentDto> removeById(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.removeById(id));
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<DepartmentDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.getById(id));
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<DepartmentDto> updatedById(@PathVariable Long id, @Valid @RequestBody DepartmentDto entity) {
        return ResponseEntity.ok(departmentService.updatedById(id, entity));
    }
}
