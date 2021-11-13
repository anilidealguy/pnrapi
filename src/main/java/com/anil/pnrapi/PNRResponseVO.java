package com.anil.pnrapi;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PNRResponseVO {
    private List<Flight> flights;
    private String applicationId;
    private String scenarioCode;
}
