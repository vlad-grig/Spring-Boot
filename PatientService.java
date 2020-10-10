package ro.sda.spring.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.spring.boot.entity.Patient;
import ro.sda.spring.boot.repository.PatientRepository;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class PatientService {

    private PatientRepository patientRepository;
    private Scanner scanner = new Scanner(System.in);

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @PostConstruct
    public void init() {
        //this.createDefaultPatient();
        //this.createPatient1();
        //this.findPatientById(3l);
        //this.deletePatientById(2l);
        //this.findAllPatientBornBefore(new Date(01,01,1990));
    }

    public Patient createPatient(Patient patient){
        return patientRepository.save(patient);
    }

//    public List<Patient> findAllPatientBornBefore(Date dateOfBirth) {
//        List<Patient> patientList = patientRepository.findAllPatientBornBefore();
//        patientList.forEach(p -> System.out.println(p.getFirstName() + " " + p.getDateOfBirth()));
//        return patientList;
//    }

    private void deletePatientById(Long patientId) {
        patientRepository.deleteById(patientId);
    }

    private Optional<Patient> findPatientById(Long patientId) {
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);
        Patient patient = optionalPatient.get();
        System.out.println("The patient with id number " + patientId + " is : " + patient.getFirstName() + " " + patient.getLastName());
        return optionalPatient;
    }

    private void createPatient1() {
        System.out.println("Welocome! Please complete next fields to create and add a new patient.");
        String firstName = getField("first name");
        String lastName = getField("last name");
        LocalDate dateOfBirth = LocalDate.parse(getField("date of birth"));
        String street = getField("street");
        Long streetNr = getFieldLong("street nr");
        Long postCode = getFieldLong("post code");
        BigDecimal height = BigDecimal.valueOf(getFieldLong("height"));
        BigDecimal weight = BigDecimal.valueOf(getFieldInt("weight"));

        Patient patient = new Patient(firstName, lastName, dateOfBirth, street, streetNr, postCode, height, weight);
        patientRepository.save(patient);
        System.out.println("New patient was added!");
    }

    public String getField(String field) {
        System.out.print("Please insert " + field + ": ");
        return scanner.nextLine();
    }

    public Double getFieldDouble(String field) {
        System.out.print("Please insert " + field + ": ");
        return scanner.nextDouble();
    }

    public Integer getFieldInt(String field) {
        System.out.print("Please insert " + field + ": ");
        return scanner.nextInt();
    }

    public Long getFieldLong(String field) {
        System.out.print("Please insert " + field + ": ");
        return scanner.nextLong();
    }

    private void createDefaultPatient() {
        List<Patient> patientList = new ArrayList<>();
        patientList.add(new Patient("Ion", "Creanga", LocalDate.of(1990,2,11), "Aleea Alunilior", 23l, 700227l, BigDecimal.valueOf(1.78), BigDecimal.valueOf(85.3)));
        patientList.add(new Patient("Mihai", "Eminescu", LocalDate.of(1990,2,11), "Aleea Ciresilor", 13l, 700715l, BigDecimal.valueOf(1.73), BigDecimal.valueOf(81.3)));
        patientList.add(new Patient("Tudor", "Arghezi", LocalDate.of(1990,2,11), "Aleea Nucului", 3l, 700701l, BigDecimal.valueOf(1.77), BigDecimal.valueOf(75.8)));
        patientList.add(new Patient("Marin", "Preda", LocalDate.of(1990,2,11), "Aleea Castanilor", 1l, 700690l, BigDecimal.valueOf(1.81), BigDecimal.valueOf(90.4)));
        patientList.add(new Patient("Andrei", "Ionescu", LocalDate.of(1990,2,11), "Aleea Castanilor", 11l, 701290l, BigDecimal.valueOf(1.80), BigDecimal.valueOf(100.2)));
        //new Patient("Adrian", "Avion", "Str. Carpenului", 12l, "500412",LocalDate.parse("1990-01-08"), 179l,BigDecimal.valueOf(83.4)))
        patientRepository.saveAll(patientList);
    }
}
