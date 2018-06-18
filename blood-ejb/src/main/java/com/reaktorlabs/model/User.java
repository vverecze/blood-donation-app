package com.reaktorlabs.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Viki
 */
@Entity
@Table(name = "app_user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(max = 100)
    @Column(unique = true)
    private String email;
    @NotNull
    private String password;
    @NotNull
    @Size(max = 100)
    private String name;
    @NotNull
    @Enumerated(EnumType.STRING)
    private GenderType gender;
    @NotNull
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @NotNull
    private int weight;
    @NotNull
    @Size(max = 11)
    private String taj;
    @NotNull
    @Column(name = "blood_type")
    @Enumerated(EnumType.STRING)
    private BloodType bloodType;
    @NotNull
    @Column(name = "rh_type")
    @Enumerated(EnumType.STRING)
    private RhType rhType;
    private String role = "user";
    
    @XmlTransient
    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true, mappedBy = "user")
    private List<BloodDonation> donations = new ArrayList<>();
    
    @XmlTransient
    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true, mappedBy = "user")
    private List<SentEmail> sentEmails = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getTaj() {
        return taj;
    }

    public void setTaj(String taj) {
        this.taj = taj;
    }

    public BloodType getBloodType() {
        return bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }

    public RhType getRhType() {
        return rhType;
    }

    public void setRhType(RhType rhType) {
        this.rhType = rhType;
    }

    public List<BloodDonation> getDonations() {
        return donations;
    }

    public void setDonations(List<BloodDonation> donations) {
        this.donations = donations;
    }

    public List<SentEmail> getSentEmails() {
        return sentEmails;
    }

    public void setSentEmails(List<SentEmail> sentEmails) {
        this.sentEmails = sentEmails;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
