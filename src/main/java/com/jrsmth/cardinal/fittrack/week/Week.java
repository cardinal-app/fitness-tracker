package com.jrsmth.cardinal.fittrack.week;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "weeks")
@Data @AllArgsConstructor @NoArgsConstructor
public class Week {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "block_no")
    private Integer block;

    @Column(name = "week_no")
    private Integer week;

    @Column(name = "volume_miles")
    private Integer volume;

    @Column(name = "activity")
    private String activity;

}
