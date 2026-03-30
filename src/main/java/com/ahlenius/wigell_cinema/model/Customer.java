package com.ahlenius.wigell_cinema.model;

import jakarta.persistence.*;

@Entity
@Table(name= "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name",length = 50, nullable = false)
    private String firstName;
    @Column(name = "last_name",length = 50, nullable = false)
    private String lastName;
    @Column(length = 50)
    private String address;
    @Column(length = 10, nullable = false)
    private String phone;
    @Column(length = 50, nullable = false, unique = true)
    private String username;
    @Column(name= "keycloak_user_id",unique = true, length = 36)
    private String keycloakUserId;

    public Customer(String firstName, String lastName, String address, String username) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.username = username;
    }

    protected Customer() {}

    public Long getId() {
        return id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getKeycloakUserId() {
        return keycloakUserId;
    }

    public void setKeycloakUserId(String keycloakUserId) {
        this.keycloakUserId = keycloakUserId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

