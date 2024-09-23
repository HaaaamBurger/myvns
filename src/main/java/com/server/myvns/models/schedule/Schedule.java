package com.server.myvns.models.schedule;

import com.server.myvns.models.NamedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "schedules")
public class Schedule extends NamedEntity {
}
