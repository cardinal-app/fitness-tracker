package com.jrsmth.cardinal.fittrack.week.paradigm.running;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jrsmth.cardinal.fittrack.AbstractEntity;
import com.jrsmth.cardinal.fittrack.week.paradigm.running.session.RunningSession;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
public class Running extends AbstractEntity {

    @Serial
    private static final long serialVersionUID = 6933491552937273687L;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "volume_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Volume volume;

    @OneToMany(mappedBy = "running", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<RunningSession> sessions = new ArrayList<>();

}