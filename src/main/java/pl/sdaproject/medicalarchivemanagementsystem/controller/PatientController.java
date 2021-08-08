package pl.sdaproject.medicalarchivemanagementsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sdaproject.medicalarchivemanagementsystem.dto.PatientRequest;
import pl.sdaproject.medicalarchivemanagementsystem.dto.PatientResponse;
import pl.sdaproject.medicalarchivemanagementsystem.mapper.PatientMapper;
import pl.sdaproject.medicalarchivemanagementsystem.model.Patient;
import pl.sdaproject.medicalarchivemanagementsystem.service.PatientService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/patient")
public class PatientController {

    private final PatientMapper patientMapper;
    private final PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientResponse> addPatient(@RequestBody @Valid PatientRequest request) {
        final Patient patient = patientService.createPatient(
                request.getFirstName(),
                request.getLastName(),
                request.getPesel()
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(patientMapper.mapPatientToPatientResponse(patient));
    }
}
