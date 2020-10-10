package ro.sda.spring.boot.transformer;

import org.springframework.beans.BeanUtils;
import ro.sda.spring.boot.dto.DoctorDTO;
import ro.sda.spring.boot.entity.Doctor;

public class DoctorTransformer {

    public static Doctor transformer(DoctorDTO doctorDTO){
        Doctor doctor = new Doctor();
        BeanUtils.copyProperties(doctorDTO, doctor);
        return doctor;
    }

    public static DoctorDTO transformReversed(Doctor doctor){
        DoctorDTO doctorDTO = new DoctorDTO();
        BeanUtils.copyProperties(doctor, doctorDTO);
        return doctorDTO;
    }
}
