package com.fares.assurance;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assurance")
@RequiredArgsConstructor
public class AssuranceController {

    private final AssuranceService assuranceService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody AssuranceClaim assuranceClaim)
    {
        assuranceService.save(assuranceClaim);
    }

    @GetMapping("/allAssurances")
    public ResponseEntity<List<AssuranceClaim>> findAllAssurances()
    {
        return ResponseEntity.ok(assuranceService.getAll());
    }

    @GetMapping("/getAssurance/{id}")
    public ResponseEntity<AssuranceResponse> findAssuranceById(@PathVariable Integer id)
    {
        return ResponseEntity.ok(assuranceService.getAssurance(id));
    }




}
