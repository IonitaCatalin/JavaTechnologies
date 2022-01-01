package com.javatech.labs8.entity;

import javax.enterprise.context.SessionScoped;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Document.findAll", query = "Select e from Document e"),
        @NamedQuery(name = "Document.countById" , query = "Select Count(e) from Document e where e.id = ?1"),
        @NamedQuery(name = "Document.countByName" , query = "Select Count(e) from Document e where e.name = ?1")
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

    @NotNull
    @Column(name = "content", nullable = false)
    String content;

    @NotNull
    @Column(name = "type", nullable = false)
    String type;


    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
             name = "authors",
             joinColumns = @JoinColumn(
                     name = "document_id",
                     referencedColumnName = "id"),
             inverseJoinColumns = @JoinColumn(
                     name = "user_id",
                     referencedColumnName = "id")
     )
    List<Account> authors = new ArrayList<>();

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
    List<Document> bibliography = new ArrayList<>();


    public Document(String name, String content, String type) {
        this.name = name;
        this.content = content;
        this.type = type;
    }

    public Document() {
    }

    public Document(Long id) {
        this.id = id;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Account> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Account> authors) {
        this.authors = authors;
    }

    public List<Document> getBibliography() {
        return bibliography;
    }

    public void setBibliography(List<Document> bibliography) {
        this.bibliography = bibliography;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", type='" + type + '\'' +
                ", authors=" + authors +
                ", bibliography=" + bibliography +
                '}';
    }
}
