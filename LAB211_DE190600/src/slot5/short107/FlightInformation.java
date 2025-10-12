
package slot5.short107;

import java.time.LocalDateTime;

public class FlightInformation {
    private String flightNumber;
    private String seatNumber;
    private LocalDateTime timePickUp;

    // Default Constructor
    public FlightInformation() {
        this.flightNumber = "";
        this.seatNumber = "";
        // Giả định thời gian hiện tại cho constructor mặc định
        this.timePickUp = LocalDateTime.now(); 
    }

    // Parameterized Constructor
    public FlightInformation(String flightNumber, String seatNumber, LocalDateTime timePickUp) {
        this.flightNumber = flightNumber;
        this.seatNumber = seatNumber;
        this.timePickUp = timePickUp;
    }

    // Getters and Setters (Phần code dài ra do phải viết tay)
    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }

    public String getSeatNumber() { return seatNumber; }
    public void setSeatNumber(String seatNumber) { this.seatNumber = seatNumber; }

    public LocalDateTime getTimePickUp() { return timePickUp; }
    public void setTimePickUp(LocalDateTime timePickUp) { this.timePickUp = timePickUp; }
}