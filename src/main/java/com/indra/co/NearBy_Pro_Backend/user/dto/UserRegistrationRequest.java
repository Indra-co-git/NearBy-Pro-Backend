package com.indra.co.NearBy_Pro_Backend.user.dto;

import com.indra.co.NearBy_Pro_Backend.common.model.Address;
import com.indra.co.NearBy_Pro_Backend.common.model.Location;

import lombok.Data;

@Data
public class UserRegistrationRequest {
    private String fullName;
    private String phoneNumber;
    private String email;
    private Address address;
    private Location location;
} 