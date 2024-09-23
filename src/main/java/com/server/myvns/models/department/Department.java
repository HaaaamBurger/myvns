package com.server.myvns.models.department;

import com.server.myvns.models.NamedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "departments")
public class Department extends NamedEntity {
}
