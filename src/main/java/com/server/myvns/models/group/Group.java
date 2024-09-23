package com.server.myvns.models.group;

import com.server.myvns.models.NamedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "groups")
public class Group extends NamedEntity {
}
