package com.server.myvns.common.service;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface SimpleCrudService<T> {
    List<T> getAll(@PathVariable(required = false) Integer page, @PathVariable(required = false) Integer size);

    T save(T entity);

    T removeById(Long id);

    T getById(Long id);

    T updatedById(Long id, T entity);
}
