package com.pid.deliotte.VenueService.Model;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class VenueResponse {
    private Long id;
    private String name;
    private String location;
    private Integer capacity;
    private Boolean availability;
}
