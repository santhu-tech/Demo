package com.pid.deliotte.VenueService.Repository;

import com.pid.deliotte.VenueService.Entity.VenueAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VenueAvailabilityRepository extends JpaRepository<VenueAvailability , Long> {
    Optional<VenueAvailability> findByVenueIdAndEventDate(Long venueId, String eventDate);
}
