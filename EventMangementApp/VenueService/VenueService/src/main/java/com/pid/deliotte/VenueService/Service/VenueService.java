package com.pid.deliotte.VenueService.Service;

import com.pid.deliotte.VenueService.Model.VenueRequest;
import com.pid.deliotte.VenueService.Model.VenueResponse;

import java.util.List;

public interface VenueService {
    VenueResponse createVenue(VenueRequest request);
    VenueResponse getVenueById(Long id);
    List<VenueResponse> getAllVenues();
}
