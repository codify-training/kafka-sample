package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class BusBooking {

    @JsonProperty("bookingMsg")
    private String bookingMsg;

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("seatNumber")
    private String seatNumber;

    @JsonProperty("timestamp")
    private long timestamp;

}
