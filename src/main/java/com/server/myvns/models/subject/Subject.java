package com.server.myvns.models.subject;

import com.server.myvns.models.NamedEntity;
import com.server.myvns.models.schedule.Schedule;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "subjects")
public class Subject extends NamedEntity {
}
