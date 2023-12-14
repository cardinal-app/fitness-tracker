package com.jrsmth.cardinal.fittrack.week.paradigm.running;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jrsmth.cardinal.fittrack.AbstractEntity;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.util.Map;

@Entity
@Table(name = "volume")
@Builder @Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Volume extends AbstractEntity {

    @Serial
    private static final long serialVersionUID = -5913709031270731217L;

    @Column(name = "total_miles")
    private Integer miles;

    @ElementCollection
    @CollectionTable(
            name = "volume_activity_mapping",
            joinColumns = {@JoinColumn(name = "volume_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "activity_name")
    @Column(name = "activities")
    private Map<String, Integer> activities;

}
