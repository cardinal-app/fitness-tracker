package com.jrsmth.cardinal.fittrack.week.paradigm.misc.session;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.jrsmth.cardinal.fittrack.week.paradigm.Session;
import com.jrsmth.cardinal.fittrack.week.paradigm.misc.Misc;
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
@Table(name = "aux_session")
@Builder @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class AuxiliarySession extends Session {

    @Serial
    private static final long serialVersionUID = -6047444873319721359L;

    @ManyToOne
    @JoinColumn(name = "misc_id", nullable = false)
    @JsonBackReference("misc_auxiliaries")
    private Misc misc;

    @Column(name = "type")
    private AuxType type;

    @Column(name = "notes")
    private String notes;

}
