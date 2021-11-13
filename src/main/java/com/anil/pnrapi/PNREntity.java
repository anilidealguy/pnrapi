package com.anil.pnrapi;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class PNREntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToMany
    @JoinColumn(name = "flight_flight_number")
    private  List<Flight> flights;
    private String applicationId;
    private String scenarioCode;
    private int noOfPnr;
    private String fileId;

    public PNREntity(List<Flight> flights, String applicationId, String scenarioCode, int noOfPnr, String fileId) {
        this.flights = flights;
        this.applicationId = applicationId;
        this.scenarioCode = scenarioCode;
        this.noOfPnr = noOfPnr;
        this.fileId = fileId;
    }
}
