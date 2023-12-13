package com.jrsmth.cardinal.fittrack.week.paradigm.misc.session;

import com.jrsmth.cardinal.fittrack.AbstractEntity;
import com.jrsmth.cardinal.fittrack.week.paradigm.misc.Misc;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.time.DayOfWeek;

@Entity
@Table(name = "gpp_session")
@Builder @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class GPPSession extends AbstractEntity {

    @Serial
    private static final long serialVersionUID = 8710906525409016436L;

    @ManyToOne
    @JoinColumn(name = "misc_id")
//    @JoinColumn(name = "misc_id", nullable = false)
    private Misc misc;

    @Column(name = "day_of_week")
    private DayOfWeek day;

    @Column(name = "press_reps")
    private Integer press;

    @Column(name = "pull_reps")
    private Integer pull;

    @Column(name = "full_volume")
    private Boolean full;

}
