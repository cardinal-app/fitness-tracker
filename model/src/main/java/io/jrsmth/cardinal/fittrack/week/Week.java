package io.jrsmth.cardinal.fittrack.week;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.jrsmth.cardinal.common.model.AbstractEntity;
import io.jrsmth.cardinal.fittrack.week.paradigm.Flag;
import io.jrsmth.cardinal.fittrack.week.paradigm.resistance.Resistance;
import io.jrsmth.cardinal.fittrack.week.paradigm.general.General;
import io.jrsmth.cardinal.fittrack.week.paradigm.running.Running;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") // FixMe
    @Column(name = "week_commencing")
    private Date weekCommencing;

    @Column(name = "week_notes")
    private String weekNotes;

    @Column
    @Enumerated
    @ElementCollection(targetClass = Flag.class)
    private List<Flag> flags;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "general_id", referencedColumnName = "id")
    private General general;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "resistance_id", referencedColumnName = "id")
    private Resistance resistance;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "running_id", referencedColumnName = "id")
    private Running running;

}
