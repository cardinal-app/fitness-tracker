package com.jrsmth.cardinal.fittrack.week.paradigm.misc.session;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.jrsmth.cardinal.fittrack.week.paradigm.Session;
import com.jrsmth.cardinal.fittrack.week.paradigm.misc.Misc;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.util.Map;

@Entity
@Table(name = "misc_session")
@Builder @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class MiscSession extends Session {

    @Serial
    private static final long serialVersionUID = 8694720372493432886L;

    @ManyToOne
    @JoinColumn(name = "misc_id", nullable = false)
    @JsonBackReference("misc_sessions")
    private Misc misc;

    @Column(name = "type")
    private MiscType type;

    @ElementCollection
    @CollectionTable(
            name = "misc_session_data_points_mapping",
            joinColumns = {@JoinColumn(name = "misc_session_id", referencedColumnName = "id")}
    )
    @MapKeyColumn(name = "datum_name")
    @Column(name = "data_points")
    private Map<String, String> dataPoints;

}
