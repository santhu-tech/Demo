package com.pid.deliotte.VenueService.Model;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class VenueAvailabilityRequest {
    @NotNull
    private Long venueId;
    @NotNull
    private LocalDate availableDate;
    @NotNull
    private Boolean isBooked;
}
