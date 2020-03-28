package com.covidfyi.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "vrdl")
@JsonIgnoreProperties(ignoreUnknown = true)
public class VrdlEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String drName;
    private String primaryEmail;
    private String secondaryEmail;
    private String primaryPhone;
    private String secondaryPhone;
    private String extension;
    private String sourceLink;
    private String source;

    @Column(length = 2048)
    private String details;

    private Date createdOn;

    private String state;
    private String district;
}
