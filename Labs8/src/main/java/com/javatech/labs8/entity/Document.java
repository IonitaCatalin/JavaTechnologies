package com.javatech.labs8.entity;

import javax.enterprise.context.SessionScoped;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = "Document.findAll", query = "Select e from Document e"),
})
@SessionScoped
public class Document implements Serializable, ApplicationEntity {

    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(
            name="document_seq_id",
            sequenceName="document_seq_id",
            allocationSize=1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator="document_seq_id")
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    String name;

    @Lob
    @NotNull
    @Basic(fetch = FetchType.LAZY)
    byte[] content;

    @NotNull
    @Column(name = "type", nullable = false)
    String type;


    @ManyToMany
    @JoinTable(
             name = "authors",
             joinColumns = @JoinColumn(
                     name = "user_id",
                     referencedColumnName = "id"),
             inverseJoinColumns = @JoinColumn(
                     name = "document_id",
                     referencedColumnName = "id")
     )
    Set<Account> authors;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="bibliographies",
            joinColumns = @JoinColumn(
                    name = "document_id",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "reference_document_id",
                    referencedColumnName = "id")
    )
    Set<Document> bibliography;

    public Document() {
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

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public Set<Account> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Account> authors) {
        this.authors = authors;
    }

    public Set<Document> getBibliography() {
        return bibliography;
    }

    public void setBibliography(Set<Document> bibliography) {
        this.bibliography = bibliography;
    }


}
