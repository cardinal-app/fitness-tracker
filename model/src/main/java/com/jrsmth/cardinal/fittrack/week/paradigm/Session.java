package com.jrsmth.cardinal.fittrack.week.paradigm;

import com.jrsmth.cardinal.fittrack.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@MappedSuperclass @Getter @Setter
public abstract class Session extends AbstractEntity {

    @Column(name = "date")
    private Date date;

    @Column(name = "ante_meridiem")
    private Boolean anteMeridiem;

    @Column(name = "location")
    private String location;

    @Column(name = "notes")
    private String notes;

}
