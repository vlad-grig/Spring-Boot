package ro.sda.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.sda.spring.boot.dto.DoctorDTO;
import ro.sda.spring.boot.dto.PagebleDoctorResponseDTO;
import ro.sda.spring.boot.entity.Doctor;
import ro.sda.spring.boot.service.DoctorService;
import ro.sda.spring.boot.transformer.DoctorTransformer;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/doctor")
@CrossOrigin(origins = "*")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DoctorDTO> findDoctorById(@PathVariable("id") Long id) {
        Doctor doctor = doctorService.findDoctorById(id);
        DoctorDTO doctorDTO = DoctorTransformer.transformReversed(doctor);
        return ResponseEntity.ok(doctorDTO);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        doctorService.deleteDoctorById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        return ResponseEntity.ok(doctorService.saveDoctor(doctor));
    }

    @PutMapping
    public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor) {
        return ResponseEntity.ok(doctorService.saveDoctor(doctor));
    }

    @GetMapping
    public ResponseEntity<List<DoctorDTO>> getByFirstName(@RequestParam("first-name") String firstName) {
        List<Doctor> doctors = doctorService.findByFirstName(firstName);
        List<DoctorDTO> doctorDTOS = doctors.stream().map(DoctorTransformer::transformReversed).collect(Collectors.toList());
        return ResponseEntity.ok(doctorDTOS);
    }

    @GetMapping
    public ResponseEntity<List<DoctorDTO>> getDoctorsPageable(@RequestParam(value = "page") int page, @RequestParam(value = "size") int size) {
        List<Doctor> doctors = doctorService.findAllDoctorsPageable(page, size);
        List<DoctorDTO> doctorDTOS = doctors.stream().map(DoctorTransformer::transformReversed).collect(Collectors.toList());

        PagebleDoctorResponseDTO responseDTO = new PagebleDoctorResponseDTO();
        responseDTO.setDoctors(doctorDTOS);
        responseDTO.setPage(page);
        

        return ResponseEntity.ok(doctorDTOS);
    }
}
