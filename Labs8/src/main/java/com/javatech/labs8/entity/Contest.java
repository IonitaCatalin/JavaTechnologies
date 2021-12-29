package com.javatech.labs8.entity;

import javax.enterprise.context.SessionScoped;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = "Contest.findAll", query = "Select e from Contest e"),
})
@Entity
@SessionScoped
public class Contest implements Serializable, ApplicationEntity {

    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(
            name="contest_seq_id",
            sequenceName="contest_seq_id",
            allocationSize=1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="contest_seq_id")
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "start_time", nullable = false)
    private Date startTime;

    @NotNull
    @Column(name = "end_time", nullable = false)
    private Date endTime;

    @NotNull
    @Column(name = "resistration_stamp", nullable = false)
    private String registrationStamp;

    @OneToMany
    @JoinTable(
            name="entries",
            joinColumns = @JoinColumn(
                    name = "contest_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "document_id",
                    referencedColumnName = "id")
    )
    private Set<Document> entries;

    public Contest() {
    }

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

    public Set<Document> getEntries() {
        return entries;
    }
}
