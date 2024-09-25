package com.server.myvns.models.subject;

import com.server.myvns.common.controller.SimpleCrudController;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/subjects")
public class SubjectController implements SimpleCrudController<SubjectDto> {

    private final SubjectService subjectService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields("id", "timestamp");
    }

    @GetMapping
    @Override
    public ResponseEntity<List<SubjectDto>> getAll(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "1") Integer size
    ) {
        return ResponseEntity.ok(subjectService.getAll(page, size));
    }

    @PostMapping
    @Override
    public ResponseEntity<SubjectDto> save(@Valid @RequestBody SubjectDto entity) {
        return ResponseEntity.ok(subjectService.save(entity));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<SubjectDto> removeById(@PathVariable Long id) {
        return ResponseEntity.ok(subjectService.removeById(id));
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<SubjectDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(subjectService.getById(id));
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<SubjectDto> updatedById(@PathVariable Long id, @Valid @RequestBody SubjectDto entity) {
        return ResponseEntity.ok(subjectService.updatedById(id, entity));
    }
}
