package com.taktika.iera.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "barter_executions")
public class BarterExecution {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "execution_date")
    private Date executionDate;

    @OneToOne
    @JoinColumn(name = "id_place")
    private Place place;

    @OneToOne
    @JoinColumn(name = "id_barter")
    private Barter barter;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(Date executionDate) {
        this.executionDate = executionDate;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Barter getBarter() {
        return barter;
    }

    public void setBarter(Barter barter) {
        this.barter = barter;
    }
}
