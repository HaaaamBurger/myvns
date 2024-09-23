package com.server.myvns.models;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class PersonEntity extends BaseEntity {

    @Column(name = "first_name")
    @NotBlank(message = "firstname field cannot be blank")
    private String firstname;

    @Column(name = "last_name")
    @NotBlank(message = "lastname field cannot be blank")
    private String lastname;
}
