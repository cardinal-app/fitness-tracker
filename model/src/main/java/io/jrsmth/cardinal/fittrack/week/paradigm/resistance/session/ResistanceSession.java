package io.jrsmth.cardinal.fittrack.week.paradigm.resistance.session;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.jrsmth.cardinal.fittrack.week.paradigm.resistance.Resistance;
import io.jrsmth.cardinal.fittrack.week.paradigm.Session;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.util.List;

@Entity
@Table(name = "resistance_session")
@Builder @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ResistanceSession extends Session {

    @Serial
    private static final long serialVersionUID = -51929308058883634L;

    @ManyToOne
    @JoinColumn(name = "resistance_id", nullable = false)
    @JsonBackReference("resistance_sessions")
    private Resistance resistance;

    @Column(name = "focus")
    private Focus focus;

    @OneToMany(mappedBy = "session")
    @JsonManagedReference("session_exercises")
    private List<Exercise> exercises;

}
