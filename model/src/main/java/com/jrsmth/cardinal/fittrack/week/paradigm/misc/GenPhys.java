package com.jrsmth.cardinal.fittrack.week.paradigm.misc;


import com.jrsmth.cardinal.fittrack.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.List;

@Entity
@Table(name = "gen_phys")
@Builder @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class GenPhys extends AbstractEntity {

    @Serial
    private static final long serialVersionUID = 8710906525409016436L;

    @ElementCollection
    @Column(name = "entries")
    List<Entry> entries;

    @Data @Builder
    @AllArgsConstructor @NoArgsConstructor
    public static class Entry implements Serializable {

        @Serial
        private static final long serialVersionUID = -6359131713121512701L;

        @Column(name = "day")
        private DayOfWeek day;

        @Column(name = "press_reps")
        private Integer press;

        @Column(name = "pull_reps")
        private Integer pull;

        @Column(name = "full_volume")
        private Boolean full;
    }

}
