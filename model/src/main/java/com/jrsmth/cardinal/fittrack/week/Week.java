package com.jrsmth.cardinal.fittrack.week;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jrsmth.cardinal.fittrack.AbstractEntity;
import com.jrsmth.cardinal.fittrack.week.paradigm.misc.Misc;
import com.jrsmth.cardinal.fittrack.week.paradigm.resistance.Resistance;
import com.jrsmth.cardinal.fittrack.week.paradigm.running.Running;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.util.Date;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "week")
@Builder @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Week extends AbstractEntity {

    @Serial
    private static final long serialVersionUID = 8096224721154503814L;

    @Column(name = "block_no")
    private Integer block;

    @Column(name = "week_no")
    private Integer week;

    @Column(name = "week_commencing")
    private Date week_commencing;

    @Column
    @Enumerated
    @ElementCollection(targetClass = Flag.class)
    private List<Flag> flags;


    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "misc_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Misc miscellaneous;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "resistance_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Resistance resistance;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "running_id", referencedColumnName = "id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Running running;

}
