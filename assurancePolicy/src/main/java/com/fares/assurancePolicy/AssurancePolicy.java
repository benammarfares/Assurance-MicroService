package com.fares.assurancePolicy;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AssurancePolicy {
    @Id
    private Integer id;
    private String policyHolder;
    private String policyType;
    private String policyDetails;
    private String coverageDetails;
    private double amountOfAssurance;
    private Date   policyStartDate;
    private Date   policyEndDate;
    private String policyStatus;

}
