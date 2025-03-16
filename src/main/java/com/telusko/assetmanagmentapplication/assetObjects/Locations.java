package com.telusko.assetmanagmentapplication.assetObjects;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Locations")

public class Locations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Long locationId;

    @Column(name = "location_name")
    private String locationName;

    @Column(name = "location_code")
    private String locationCode;

    public Locations() {
    }

    public Locations(long locationId, String locationName, String locationCode) {
        this.locationId = locationId;
        this.locationName = locationName;
        this.locationCode = locationCode;
    }


}
