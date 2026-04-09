package com.ahlenius.wigell_cinema.model;

import jakarta.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "street", length = 15, nullable = false)
    private String street;
    @Column(name = "zipcode",length = 7, nullable = false)
    private String zipcode;
    @Column(length = 15, nullable = false)
    private String city;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    protected Address() {
    }

    public Address( String street,String zipcode,String city) {
        this.street = street;
        this.zipcode = zipcode;
        this.city = city;
    }

    public Address(String street, String zipcode, String city, Customer customer) {
        this.street = street;
        this.zipcode = zipcode;
        this.city = city;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
