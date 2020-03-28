package com.covidfyi.datacontracts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vrdl {

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
    private String details;
    private Date createdOn;
    private String state;
    private String district;
}
