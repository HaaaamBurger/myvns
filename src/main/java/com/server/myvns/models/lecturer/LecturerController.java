package com.server.myvns.models.lecturer;

import com.fasterxml.jackson.annotation.JsonView;
import com.server.myvns.common.controllers.SimpleCrudController;
import com.server.myvns.common.views.View;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lecturers")
@RequiredArgsConstructor
public class LecturerController implements SimpleCrudController<LecturerDto> {

    private final LecturerService lecturerService;

    @JsonView(View.Private.class)
    @GetMapping
    @Override
    public ResponseEntity<List<LecturerDto>> getAll(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "1") Integer size) {
        return ResponseEntity.ok(lecturerService.getAll(page, size));
    }

    @PostMapping
    @Override
    public ResponseEntity<LecturerDto> save(@Valid @RequestBody LecturerDto entity) {
        return ResponseEntity.ok(lecturerService.save(entity));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<LecturerDto> removeById(@PathVariable Long id) {
        return ResponseEntity.ok(lecturerService.removeById(id));
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<LecturerDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(lecturerService.getById(id));
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<LecturerDto> updatedById(@PathVariable Long id, @Valid @RequestBody LecturerDto entity) {
        return ResponseEntity.ok(lecturerService.updatedById(id, entity));
    }
}
