package io.jrsmth.cardinal.fittrack.week.paradigm.general.activity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.jrsmth.cardinal.common.model.AbstractEntity;
import io.jrsmth.cardinal.fittrack.week.paradigm.general.General;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;

@Entity
@Table(name = "activity")
@Builder @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Activity extends AbstractEntity {

    @Serial
    private static final long serialVersionUID = 7509879044796284402L;

    @ManyToOne
    @JoinColumn(name = "general_id", nullable = false)
    @JsonBackReference("general_activities")
    private General general;

    @Column(name = "type")
    private ActivityType type;

    @Column(name = "number")
    private Integer number;

    @Column(name = "notes")
    private String notes;

}

