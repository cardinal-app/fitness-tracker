package com.jrsmth.cardinal.fittrack.week.paradigm.general.session;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.jrsmth.cardinal.fittrack.week.paradigm.Session;
import com.jrsmth.cardinal.fittrack.week.paradigm.general.General;
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
@Table(name = "general_session")
@Builder @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class GeneralSession extends Session {

    @Serial
    private static final long serialVersionUID = 8694720372493432886L;

    @ManyToOne
    @JoinColumn(name = "general_id", nullable = false)
    @JsonBackReference("general_sessions")
    private General general;

    @Column(name = "type")
    private GeneralType type;

    @ElementCollection
    @CollectionTable(
            name = "general_session_data_points_mapping",
            joinColumns = {@JoinColumn(name = "general_session_id", referencedColumnName = "id")}
    )
    @MapKeyColumn(name = "datum_name")
    @Column(name = "data_points")
    private Map<String, String> dataPoints;

}
