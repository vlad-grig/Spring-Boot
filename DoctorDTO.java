package ro.sda.spring.boot.dto;

import ro.sda.spring.boot.entity.BaseEntity;

import java.time.LocalDateTime;

public class DoctorDTO extends BaseDTO {

    private Long id;

    private String firstName;

    private String lastName;

    private String street;

    private Long streetNr;

    private String postCode;

    private String email;

    public DoctorDTO(Long id, LocalDateTime createdTime, LocalDateTime lastUpdateTime, Long id1, String firstName, String lastName, String street, Long streetNr, String postCode, String email) {
        super(id, createdTime, lastUpdateTime);
        this.id = id1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.streetNr = streetNr;
        this.postCode = postCode;
        this.email = email;
    }

    public DoctorDTO(Long id, LocalDateTime createdTime, LocalDateTime lastUpdateTime) {
        super(id, createdTime, lastUpdateTime);
    }

    public DoctorDTO() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Long getStreetNr() {
        return streetNr;
    }

    public void setStreetNr(Long streetNr) {
        this.streetNr = streetNr;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

