package io.jrsmth.cardinal.fittrack.week.paradigm.resistance.session;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.jrsmth.cardinal.common.model.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
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
import java.util.List;

@Entity
@Table(name = "exercise")
@Builder @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Exercise extends AbstractEntity {

    @Serial
    private static final long serialVersionUID = 1939897512138913556L;

    @ManyToOne
    @JoinColumn(name = "session_id", nullable = false)
    @JsonBackReference("session_exercises")
    private ResistanceSession session;

    @Column(name = "name")
    private String name;

    @ElementCollection
    @Column(name = "set_reps")
    private List<Integer> setReps;

    @ElementCollection
    @Column(name = "resistance")
    private List<Integer> resistance;

    @Column(name = "notes")
    private String notes;

}
