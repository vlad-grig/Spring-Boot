package ro.sda.spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ro.sda.spring.boot.entity.Doctor;
import ro.sda.spring.boot.exception.NotFoundException;
import ro.sda.spring.boot.repository.DoctorRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    private DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @PostConstruct
    public void init() {
        this.createDefaultDoctors();
//        this.getDoctor(2l);
//        this.countDoctors();
//        this.findAllDoctorsPageble(0, 2);
//        System.out.println("............next page..............");
//        this.findAllDoctorsPageble(1, 2);
//        System.out.println("............next page..............");
//        this.findAllDoctorsPageble(2, 2);
//        this.findByFirstName("Vlad");
//        this.findByFirstNameOrLastName("Adrian" , "Grigore");
//        this.findByStreetNumberGreaterThan(2l);
//        System.out.println(this.doctorRepository.countDoctorsByFirstName("Adrian"));
//        System.out.println(this.doctorRepository.countDoctorsByLastName("Juncu"));
    }

    private List<Doctor> findByFirstNameOrLastName(String firstName,String lastName) {
        List<Doctor> doctors = doctorRepository.findByFirstNameOrLastName(firstName, lastName);
        doctors.forEach(d -> System.out.println(d.toString()));
        return doctors;
    }

    private void createDefaultDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        Doctor doctor1 = new Doctor("Vlad", "Grigore", "Str. Alexandru cel Bun", 60l, "700609", "vladyg1986@gmail.com");
        Doctor doctor2 = new Doctor("Adrian", "Rotila", "Str. Sarariei", 22l, "700602", "adrian@gmail.com");
        Doctor doctor3 = new Doctor("George", "Nicolae", "Str. Nucului", 36l, "700601", "george@gmail.com");
        Doctor doctor4 = new Doctor("Nicolae", "Catalin", "Str. Ciresilor", 121l, "720609", "nicolae@gmail.com");
        Doctor doctor5 = new Doctor("Constantin", "Juncu", "Str. Magheru", 23l, "700309", "constantin@gmail.com");

        doctors.add(doctor1);
        doctors.add(doctor2);
        doctors.add(doctor3);
        doctors.add(doctor4);
        doctors.add(doctor5);

        doctorRepository.saveAll(doctors);
//        doctorRepository.save(doctor1);
//        doctorRepository.save(doctor2);
//        doctorRepository.save(doctor3);
//        doctorRepository.save(doctor4);
//        doctorRepository.save(doctor5);
    }

    public List<Doctor> findByStreetNumberGreaterThan(Long id) {
        Doctor doctor = this.findDoctorById(id);
        List<Doctor> doctors = doctorRepository.findByStreetNrGreaterThan(doctor.getStreetNr());
        doctors.forEach(d -> System.out.println(d.toString()));
        return doctors;
    }

    public List<Doctor> findByFirstName(String firstName) {
        List<Doctor> doctors = doctorRepository.findByFirstName(firstName);
        doctors.forEach(d -> d.toString());
        return doctors;
    }

    public List<Doctor> findAllDoctorsPageable(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<Doctor> doctors = doctorRepository.findAll(pageable).get().collect(Collectors.toList());
        doctors.forEach(d -> System.out.println(d.toString()));
        return doctors;
    }

    public void countDoctors() {
        System.out.println("There are " + doctorRepository.count() + " doctors");
    }

    public Doctor findDoctorById(Long id) {
        Optional<Doctor> optDoctor = doctorRepository.findById(id);
        if (optDoctor.isPresent()) {
            Doctor doctor = optDoctor.get();
            System.out.println(doctor.toString());
            return doctor;
        } else {
            System.out.println("Doctor with id " + id + " not exist.");
            throw new NotFoundException("Doctor with id " + id + " not exist.");
        }
    }

    public Doctor saveDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }

    public void deleteDoctorById(Long id){
        this.findDoctorById(id);
        doctorRepository.deleteById(id);
    }
}
