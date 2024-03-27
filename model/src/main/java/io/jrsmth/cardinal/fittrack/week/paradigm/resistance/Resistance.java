package io.jrsmth.cardinal.fittrack.week.paradigm.resistance;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.jrsmth.cardinal.fittrack.AbstractEntity;
import io.jrsmth.cardinal.fittrack.week.paradigm.resistance.session.ResistanceSession;
import jakarta.persistence.CascadeType;
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
@Table(name = "resistance")
@Builder @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Resistance extends AbstractEntity {

    @Serial
    private static final long serialVersionUID = 8096224721154503814L;

    @OneToMany(mappedBy = "resistance", orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonManagedReference("resistance_sessions")
    private List<ResistanceSession> sessions = new ArrayList<>();

}
