package com.server.myvns.common.util;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RepositoryUtilService<T, ID> {
    public T findEntityOrThrowException(JpaRepository<T, ID> repository, ID id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity wasn't found by id: %s".formatted(id)));
    }
}
