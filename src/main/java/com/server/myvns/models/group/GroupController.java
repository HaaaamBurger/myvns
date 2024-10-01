package com.server.myvns.models.group;

import com.server.myvns.common.controllers.SimpleCrudController;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/groups")
public class GroupController implements SimpleCrudController<GroupDto> {

    private final GroupService groupService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields("id", "timestamp");
    }

    @GetMapping
    @Override
    public ResponseEntity<List<GroupDto>> getAll(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "1") Integer size) {
        return ResponseEntity.ok(groupService.getAll(page, size));
    }

    @PostMapping
    @Override
    public ResponseEntity<GroupDto> save(@Valid @RequestBody GroupDto entity) {
        return ResponseEntity.ok(groupService.save(entity));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<GroupDto> removeById(@PathVariable Long id) {
        return ResponseEntity.ok(groupService.removeById(id));
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<GroupDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(groupService.getById(id));
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<GroupDto> updatedById(@PathVariable Long id, @Valid @RequestBody GroupDto entity) {
        return ResponseEntity.ok(groupService.updatedById(id, entity));
    }

    @PatchMapping("/{groupId}/schedule/{scheduleId}")
    public ResponseEntity<GroupDto> assignScheduleToGroup(@PathVariable Long groupId, @PathVariable Long scheduleId) {
        return ResponseEntity.ok(groupService.assignScheduleToGroup(groupId, scheduleId));
    }
}
