package com.pid.deliotte.VenueService.Repository;

import com.pid.deliotte.VenueService.Entity.Venue;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository extends JpaRepository<Venue,Long> {
}
