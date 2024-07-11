package com.fares.assurance;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssuranceService {

    private final AssuranceRepository assuranceRepository;

    public void save(AssuranceClaim assuranceClaim) {
        assuranceRepository.save(assuranceClaim);
    }
     public List<AssuranceClaim> getAll()
     {
            return assuranceRepository.findAll();
     }




}
