package com.server.myvns.models;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MappedSuperclass
public class NamedEntity extends BaseEntity {

    @Column(name = "name")
    @NotBlank(message = "name field cannot be blank")
    private String name;
}
