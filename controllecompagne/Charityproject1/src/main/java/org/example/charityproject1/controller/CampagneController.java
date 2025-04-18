package org.example.charityproject1.controller;

import jakarta.validation.Valid;
import org.example.charityproject1.dto.DonDTO;
import org.example.charityproject1.projection.CampagneResume;
import org.example.charityproject1.service.CampagneService;
import org.example.charityproject1.service.DonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/campagnes")
public class CampagneController {

    @Autowired
    private DonService donService;

    @Autowired
    private CampagneService campagneService;

    @GetMapping("/actives")
    public ResponseEntity<List<CampagneResume>> getCampagnesActives() {
        List<CampagneResume> campagnes = campagneService.getCampagnesActives();
        return ResponseEntity.ok(campagnes);
    }


    @PostMapping("/api/campagnes/{id}/dons")
    public ResponseEntity<?> faireDon(@PathVariable String campagneId, @RequestBody @Valid DonDTO donDTO) {
        try {
            DonDTO savedDonation = donService.enregistrerDon(campagneId, donDTO);
            return ResponseEntity.ok(savedDonation);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}