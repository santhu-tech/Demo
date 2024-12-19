package com.pid.deliotte.VenueService.Service;

import com.pid.deliotte.VenueService.Model.VenueAvailabilityResponse;

public interface VenueAvailabilityService {
    VenueAvailabilityResponse checkAvailability(Long venueId, String eventDate);
    void updateAvailability(Long venueId, String eventDate, boolean isAvailable);
}
