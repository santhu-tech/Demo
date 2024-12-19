package com.pid.deliotte.VenueService.Model;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VenueRequest {

    @NotNull(message = "Venue name cannot be null")
    @Size(min = 3, max = 100, message = "Venue name should be between 3 and 100 characters")
    private String name;

    @NotNull(message = "Location cannot be null")
    private String location;

    @NotNull(message = "Capacity cannot be null")
    private Integer capacity;
}


