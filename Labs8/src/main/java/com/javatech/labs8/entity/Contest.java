package com.javatech.labs8.entity;

import javax.enterprise.context.SessionScoped;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@NamedQueries({
        @NamedQuery(name = "Contest.findAll", query = "Select e from Contest e"),
})
@Entity
@SessionScoped
public class Contest implements Serializable, ApplicationEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 5, max = 20)
    private String name;

    @NotNull
    private Date startTime;

    @NotNull
    private Date endTime;

    @NotNull
    private String registrationStamp;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getRegistrationStamp() {
        return registrationStamp;
    }

    public void setRegistrationStamp(String registrationStamp) {
        this.registrationStamp = registrationStamp;
    }
}
