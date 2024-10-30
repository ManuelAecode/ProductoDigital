package com.aecode.webcoursesback.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "userdetail")
@SequenceGenerator(name = "userdetail_seq", sequenceName = "userdetail_sequence", allocationSize = 1)

public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userdetail_seq")
    private int detailsId;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private UserProfile userProfile;

    @Column( length = 255)
    private String profilepicture;

    @Column( length = 255)
    private String Country;

    @Column( length = 255)
    private String city;

    @Column(columnDefinition = "TEXT")
    private String bio;

    @Column
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate birthdate;

    @Column( length = 255)
    private String phoneNumber;

    public UserDetail() {
    }

    public UserDetail(int detailsId, UserProfile userProfile, String profilepicture, String country, String city, String bio, LocalDate birthdate, String phoneNumber) {
        this.detailsId = detailsId;
        this.userProfile = userProfile;
        this.profilepicture = profilepicture;
        Country = country;
        this.city = city;
        this.bio = bio;
        this.birthdate = birthdate;
        this.phoneNumber = phoneNumber;
    }

    public int getDetailsId() {
        return detailsId;
    }

    public void setDetailsId(int detailsId) {
        this.detailsId = detailsId;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public String getProfilepicture() {
        return profilepicture;
    }

    public void setProfilepicture(String profilepicture) {
        this.profilepicture = profilepicture;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
