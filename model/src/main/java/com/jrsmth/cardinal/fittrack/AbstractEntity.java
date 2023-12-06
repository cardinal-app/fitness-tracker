package com.jrsmth.cardinal.fittrack;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

import static jakarta.persistence.GenerationType.IDENTITY;

@MappedSuperclass @Getter @Setter
public abstract class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Version
    @Column(name = "last_modified", nullable = false)
    protected Timestamp lastModified;

    @Column(name = "created_date", nullable = false, updatable = false)
    protected Timestamp createdDate = new Timestamp(System.currentTimeMillis());

}
