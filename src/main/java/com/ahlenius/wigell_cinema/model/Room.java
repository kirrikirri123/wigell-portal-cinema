package com.ahlenius.wigell_cinema.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, length = 25)
    private String name;
    @Column(name = "max_guest",length = 3, nullable = false)
    private int maxGuest;
    @Column(length = 75)
    private String equipment; // enum?
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Booking> bookingList= new ArrayList<>();


    protected Room() {
    }

    public Room(String name, int maxGuest, String equipment) {
        this.name = name;
        this.maxGuest = maxGuest;
        this.equipment = equipment;
    }
    public void addBooking(Booking booking) {
        bookingList.add(booking);
        booking.setRoom(this);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxGuest() {
        return maxGuest;
    }

    public void setMaxGuest(int maxGuest) {
        this.maxGuest = maxGuest;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }
}

