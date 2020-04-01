package com.covidfyi.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "location")
public class LocationEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        private String state;
        private String district;

        @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "location")
        private List<VrdlEntity> vrdls;

}
