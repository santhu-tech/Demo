package com.pid.deliotte.VenueService.Service;

import com.pid.deliotte.VenueService.Entity.Venue;
import com.pid.deliotte.VenueService.Exception.VenueNotFoundException;
import com.pid.deliotte.VenueService.Model.VenueRequest;
import com.pid.deliotte.VenueService.Model.VenueResponse;
import com.pid.deliotte.VenueService.Repository.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VenueServiceImpl implements VenueService {

    @Autowired
    private VenueRepository venueRepository;

    @Override
    public VenueResponse createVenue(VenueRequest request) {
        Venue venue = Venue.builder()
                .name(request.getName())
                .location(request.getLocation())
                .capacity(request.getCapacity())
                .availability(true) // Default to true
                .build();

        venue = venueRepository.save(venue);
        return mapToVenueResponse(venue);
    }

    @Override
    public VenueResponse getVenueById(Long id) {
        Venue venue = venueRepository.findById(id)
                .orElseThrow(() -> new VenueNotFoundException("Venue with ID " + id + " not found"));
        return mapToVenueResponse(venue);
    }

    @Override
    public List<VenueResponse> getAllVenues() {
        List<Venue> venues = venueRepository.findAll();
        return venues.stream()
                .map(this::mapToVenueResponse)
                .collect(Collectors.toList());
    }

    // Utility method to map Venue entity to VenueResponse
    private VenueResponse mapToVenueResponse(Venue venue) {
        return VenueResponse.builder()
                .id(venue.getId())
                .name(venue.getName())
                .location(venue.getLocation())
                .capacity(venue.getCapacity())
                .availability(venue.getAvailability()) // Map availability correctly
                .build();
    }
}
