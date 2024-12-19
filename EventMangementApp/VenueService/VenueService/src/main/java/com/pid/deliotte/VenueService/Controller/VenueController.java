package com.pid.deliotte.VenueService.Controller;

import com.pid.deliotte.VenueService.Model.*;
import com.pid.deliotte.VenueService.Service.VenueAvailabilityService;
import com.pid.deliotte.VenueService.Service.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venues")
@Validated
public class VenueController {

    @Autowired
    private VenueService venueService;

    @Autowired
    private VenueAvailabilityService venueAvailabilityService;

    @PostMapping
    public ResponseEntity<ApiResponse<VenueResponse>> createVenue(@RequestBody VenueRequest request) {
        VenueResponse venueResponse = venueService.createVenue(request);
        ApiResponse<VenueResponse> apiResponse = new ApiResponse<>("SUCCESS", "Venue created successfully", venueResponse);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<VenueResponse>> getVenueById(@PathVariable Long id) {
        VenueResponse venueResponse = venueService.getVenueById(id);
        ApiResponse<VenueResponse> apiResponse = new ApiResponse<>("SUCCESS", "Venue retrieved successfully", venueResponse);
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/{venueId}")
    public ResponseEntity<ApiResponse<VenueAvailabilityResponse>> checkAvailability(
            @PathVariable Long venueId,
            @RequestParam String eventDate) {
        VenueAvailabilityResponse response = venueAvailabilityService.checkAvailability(venueId, eventDate);
        ApiResponse<VenueAvailabilityResponse> apiResponse = new ApiResponse<>(
                "SUCCESS", "Availability checked successfully", response);
        return ResponseEntity.ok(apiResponse);
    }
    @GetMapping
    public ResponseEntity<ApiResponse<List<VenueResponse>>> getAllVenues() {
        List<VenueResponse> venueResponses = venueService.getAllVenues();
        ApiResponse<List<VenueResponse>> apiResponse = new ApiResponse<>("SUCCESS", "All venues retrieved successfully", venueResponses);
        return ResponseEntity.ok(apiResponse);
    }
}