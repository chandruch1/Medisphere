package com.medisphere.controller;

import com.medisphere.dto.DoctorRequest;
import com.medisphere.dto.DoctorResponse;
import com.medisphere.service.DoctorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    // Add Doctor
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public DoctorResponse addDoctor(
            @Valid @RequestBody DoctorRequest request) {

        return doctorService.addDoctor(request);
    }

    // Get All Doctors
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<DoctorResponse> getAllDoctors() {

        return doctorService.getAllDoctors();
    }

    // Get Doctor By Id
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public DoctorResponse getDoctorById(
            @PathVariable Long id) {

        return doctorService.getDoctorById(id);
    }

    // Update Doctor
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public DoctorResponse updateDoctor(
            @PathVariable Long id,
            @Valid @RequestBody DoctorRequest request) {

        return doctorService.updateDoctor(id, request);
    }

    // Delete Doctor
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String deleteDoctor(
            @PathVariable Long id) {

        doctorService.deleteDoctor(id);

        return "Doctor deleted successfully.";
    }
}