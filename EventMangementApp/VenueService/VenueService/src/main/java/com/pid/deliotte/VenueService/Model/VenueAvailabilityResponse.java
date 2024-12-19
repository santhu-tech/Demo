package com.pid.deliotte.VenueService.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VenueAvailabilityResponse {
    private Long id;
    private Long venueId;
    private LocalDate availableDate;
    private Boolean isBooked;

    public VenueAvailabilityResponse(Object available) {
    }
}

