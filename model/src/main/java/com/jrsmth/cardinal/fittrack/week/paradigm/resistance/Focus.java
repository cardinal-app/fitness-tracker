package com.jrsmth.cardinal.fittrack.week.paradigm.resistance;

import com.jrsmth.cardinal.fittrack.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "focus")
@Builder @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Focus extends AbstractEntity {

    @Column(name = "name")
    private String name;

}
