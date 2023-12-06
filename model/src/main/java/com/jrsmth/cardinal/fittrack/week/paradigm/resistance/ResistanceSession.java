package com.jrsmth.cardinal.fittrack.week.paradigm.resistance;

import com.jrsmth.cardinal.fittrack.week.paradigm.Session;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "resistance_session")
@Builder @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ResistanceSession extends Session {

    @ManyToOne
    @Column(name = "focus")
    private Focus focus;

    @ManyToMany // FixMe
    @Column(name = "exercises")
    private List<Exercise> exercises;


}
