package com.jtechnologies.labs5.models;

import com.jtechnologies.labs5.enums.ResourceType;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "exams_resources", schema = "public")
@NamedQueries({
        @NamedQuery(name = "Resource.findAll", query = "Select e from Resource e")
})
public class Resource implements Serializable,Model {

    @Id
    @SequenceGenerator(name="resource_id_seq",
            sequenceName="resource_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator="resource_id_seq")
    @Column(name = "id")
    private Integer id;

    @Column(name = "exam_id")
    @Basic(optional = false)
    private int studentId;

    @Column(name = "resource_type")
    @Basic(optional = false)
    private ResourceType resourceType;


    @Override
    public Integer getId() {
        return id;
    }

    public int getStudentId() {
        return studentId;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }
}
