package com.server.myvns.models.subject;

import com.server.myvns.models.NamedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "subjects")
public class Subject extends NamedEntity {
}
