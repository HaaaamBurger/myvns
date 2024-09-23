package com.server.myvns.common.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface SimpleCrudController<T> {
    ResponseEntity<List<T>> getAll(@PathVariable(required = false) Integer page, @PathVariable(required = false) Integer size);

    ResponseEntity<T> save(T entity);

    ResponseEntity<T> removeById(Long id);

    ResponseEntity<T> getById(Long id);

    ResponseEntity<T> updatedById(Long id, T entity);
}
