package com.server.myvns.models.schedule;

import com.server.myvns.common.controller.SimpleCrudController;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/schedules")
public class ScheduleController implements SimpleCrudController<ScheduleDto> {

    private final ScheduleService scheduleService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields("id", "timestamp");
    }

    @GetMapping
    @Override
    public ResponseEntity<List<ScheduleDto>> getAll(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(scheduleService.getAll(page, size));
    }

    @PostMapping
    @Override
    public ResponseEntity<ScheduleDto> save(@Valid @RequestBody ScheduleDto entity) {
        return ResponseEntity.ok(scheduleService.save(entity));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<ScheduleDto> removeById(@PathVariable Long id) {
        return ResponseEntity.ok(scheduleService.removeById(id));
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<ScheduleDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(scheduleService.getById(id));
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<ScheduleDto> updatedById(@PathVariable Long id, @Valid @RequestBody ScheduleDto entity) {
        return ResponseEntity.ok(scheduleService.updatedById(id, entity));
    }
}
