package com.jrsmth.cardinal.fittrack.week.paradigm.running.session;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.jrsmth.cardinal.fittrack.week.paradigm.Session;
import com.jrsmth.cardinal.fittrack.week.paradigm.running.Running;
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
@Table(name = "running_session")
@Builder @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class RunningSession extends Session {

    @Serial
    private static final long serialVersionUID = -5171173816050359694L;

    @ManyToOne
    @JoinColumn(name = "running_id", nullable = false)
    @JsonBackReference("running_sessions")
    private Running running;

    @Column(name = "type")
    private RunType type;

    @ElementCollection
    @CollectionTable(
            name = "running_session_data_points_mapping",
            joinColumns = {@JoinColumn(name = "running_session_id", referencedColumnName = "id")}
    )
    @MapKeyColumn(name = "datum_name")
    @Column(name = "data_points")
    private Map<String, String> dataPoints;

}
