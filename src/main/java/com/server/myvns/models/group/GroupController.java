package com.server.myvns.models.group;

import com.server.myvns.common.controller.SimpleCrudController;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/groups")
public class GroupController implements SimpleCrudController<GroupDto> {

    private final GroupService groupService;

    @GetMapping
    @Override
    public ResponseEntity<List<GroupDto>> getAll(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(groupService.getAll(page, size));
    }

    @Override
    public ResponseEntity<GroupDto> save(GroupDto entity) {
        return null;
    }

    @Override
    public ResponseEntity<GroupDto> removeById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<GroupDto> getById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<GroupDto> updatedById(Long id, GroupDto entity) {
        return null;
    }
}
