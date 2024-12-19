package com.pid.deliotte.VenueService.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VenueAvailability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long venueId;
    private LocalDate availableDate;
    private Boolean isBooked;
    private String eventDate;

    public void setAvailable(boolean isAvailable) {
    }

    public void setEventDate(String eventDate) {
    }

    public Object isAvailable() {
        return null;
    }
}
