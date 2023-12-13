package com.jrsmth.cardinal.fittrack.week.paradigm.misc;


import com.jrsmth.cardinal.fittrack.AbstractEntity;
import com.jrsmth.cardinal.fittrack.week.paradigm.misc.session.AuxiliarySession;
import com.jrsmth.cardinal.fittrack.week.paradigm.misc.session.GPPSession;
import com.jrsmth.cardinal.fittrack.week.paradigm.misc.session.MiscSession;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "misc")
@Builder @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Misc extends AbstractEntity {

    @Serial
    private static final long serialVersionUID = -6901075776089719635L;

    @Column(name = "overall_week_notes")
    private String weekNotes;

    @OneToMany(mappedBy = "misc", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<AuxiliarySession> auxiliaries = new ArrayList<>();

    @OneToMany(mappedBy = "misc", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<GPPSession> gpp = new ArrayList<>();

    @OneToMany(mappedBy = "misc", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<MiscSession> sessions = new ArrayList<>();

}
