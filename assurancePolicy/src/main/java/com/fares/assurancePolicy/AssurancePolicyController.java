package com.fares.assurancePolicy;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assurancePolicy")
@RequiredArgsConstructor
public class AssurancePolicyController {

    private final AssurancePolicyService assurancePolicyService;

    @PostMapping("/savePolicy")
    @ResponseStatus(HttpStatus.CREATED)
    public void savePolicy(@RequestBody AssurancePolicy assurancePolicy) {
          assurancePolicyService.save(assurancePolicy);
    }

    @GetMapping("/allPolicies")
    public ResponseEntity<List<AssurancePolicy>> findAllPolicies() {
        return ResponseEntity.ok(assurancePolicyService.getAll());
    }



}
