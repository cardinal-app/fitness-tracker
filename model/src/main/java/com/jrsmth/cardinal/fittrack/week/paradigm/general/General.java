package com.jrsmth.cardinal.fittrack.week.paradigm.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jrsmth.cardinal.fittrack.AbstractEntity;
import com.jrsmth.cardinal.fittrack.week.paradigm.general.activity.Activity;
import com.jrsmth.cardinal.fittrack.week.paradigm.general.session.GeneralSession;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
@Table(name = "general")
@Builder @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class General extends AbstractEntity {

    @Serial
    private static final long serialVersionUID = -6901075776089719635L;

    @OneToMany(mappedBy = "general", orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonManagedReference("general_activities")
    private List<Activity> activities = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "gym_id", referencedColumnName = "id")
    private Gym gym;

    @OneToMany(mappedBy = "general", orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonManagedReference("general_sessions")
    private List<GeneralSession> sessions = new ArrayList<>();

}
