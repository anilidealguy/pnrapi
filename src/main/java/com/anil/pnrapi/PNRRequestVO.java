package com.anil.pnrapi;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PNRRequestVO {
    private List<Flight> planes;
    private String applicationId;
    private String scenarioCode;
    private int noOfPnr;
    private String fId;
}
