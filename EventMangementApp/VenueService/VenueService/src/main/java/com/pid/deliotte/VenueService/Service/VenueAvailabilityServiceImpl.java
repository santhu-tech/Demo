package com.pid.deliotte.VenueService.Service;

import com.pid.deliotte.VenueService.Entity.VenueAvailability;
import com.pid.deliotte.VenueService.Exception.VenueAvailabilityNotFoundException;
import com.pid.deliotte.VenueService.Model.VenueAvailabilityResponse;
import com.pid.deliotte.VenueService.Repository.VenueAvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VenueAvailabilityServiceImpl implements VenueAvailabilityService {

    @Autowired
    private VenueAvailabilityRepository venueAvailabilityRepository;

    @Override
    public VenueAvailabilityResponse checkAvailability(Long venueId, String eventDate) {
        Optional<VenueAvailability> venueAvailability = venueAvailabilityRepository
                .findByVenueIdAndEventDate(venueId, eventDate);

        if (venueAvailability.isPresent()) {
            return new VenueAvailabilityResponse(venueAvailability.get().isAvailable());
        } else {
            throw new VenueAvailabilityNotFoundException("Availability data not found for the venue on this date.");
        }
    }

    @Override
    public void updateAvailability(Long venueId, String eventDate, boolean isAvailable) {
        VenueAvailability venueAvailability = new VenueAvailability();
        venueAvailability.setVenueId(venueId);
        venueAvailability.setEventDate(eventDate);
        venueAvailability.setAvailable(isAvailable);

        venueAvailabilityRepository.save(venueAvailability);
    }
}