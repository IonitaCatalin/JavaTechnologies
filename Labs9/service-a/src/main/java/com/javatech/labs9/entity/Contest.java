package com.javatech.labs9.entity;

import javax.enterprise.context.SessionScoped;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

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
    @Column(name = "resistration_stamp", nullable = false)
    private String registrationStamp;

    @NotNull
    @Column(name = "running", nullable = false)
    private boolean running;

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

    public String getRegistrationStamp() {
        return registrationStamp;
    }

    public void setRegistrationStamp(String registrationStamp) {
        this.registrationStamp = registrationStamp;
    }

    public Set<Document> getEntries() {
        return entries;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void setEntries(Set<Document> entries) {
        this.entries = entries;
    }
}

