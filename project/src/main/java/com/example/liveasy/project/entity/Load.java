package com.example.liveasy.project.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "loads_info")
public class Load {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID loadId;

    private String loadingPoint;
    private String unloadingPoint;
    private String productType;
    private String truckType;
    private String noOfTrucks;
    private String weight;
    private String comment;
    private String shipperId;
    private String date;
}
