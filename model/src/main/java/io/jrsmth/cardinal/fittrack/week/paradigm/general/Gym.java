package io.jrsmth.cardinal.fittrack.week.paradigm.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.jrsmth.cardinal.model.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "gym")
@Builder @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Gym extends AbstractEntity {

    @Serial
    private static final long serialVersionUID = 8184684344415987967L;

    @Column(name = "max_press")
    private Integer maxPress;

    @Column(name = "max_pull")
    private Integer maxPull;

    @Column(name = "total_press")
    private Integer totalPress;

    @Column(name = "total_pull")
    private Integer totalPull;

    @Column(name = "core_exercise")
    private String coreExerciseName;

    @ElementCollection
    @Column(name = "core_set_reps")
    private List<Integer> coreSetReps;

    @Column(name = "notes")
    private String notes;

}

