package io.jrsmth.cardinal.fittrack.week.paradigm.running;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.jrsmth.cardinal.model.AbstractEntity;
import io.jrsmth.cardinal.fittrack.week.paradigm.running.session.RunningSession;
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
@Table(name = "running")
@Builder @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Running extends AbstractEntity {

    @Serial
    private static final long serialVersionUID = 6933491552937273687L;

    @Column(name = "volume")
    private Integer volume;

    @OneToMany(mappedBy = "running", orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonManagedReference("running_sessions")
    private List<RunningSession> sessions = new ArrayList<>();

}
