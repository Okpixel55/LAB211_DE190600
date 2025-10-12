package slot5.short107;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Reservation {
    private String bookingID;
    private String customerName;
    private String phoneNumber;
    private String roomNumber;
    private LocalDateTime bookingDate;
    private FlightInformation flightInformation; // Composition

    // Default Constructor
    public Reservation() {
        this.bookingID = "";
        this.customerName = "";
        this.phoneNumber = "";
        this.roomNumber = "";
        this.bookingDate = LocalDateTime.now().plusDays(1);
        this.flightInformation = null;
    }

    // Parameterized Constructor
    public Reservation(String bookingID, String customerName, String phoneNumber, String roomNumber,
                       LocalDateTime bookingDate, FlightInformation flightInformation) {
        this.bookingID = bookingID;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.roomNumber = roomNumber;
        this.bookingDate = bookingDate;
        this.flightInformation = flightInformation;
    }

    // Getters and Setters
    public String getBookingID() { return bookingID; }
    public void setBookingID(String bookingID) { this.bookingID = bookingID; }
    
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    
    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }
    
    public LocalDateTime getBookingDate() { return bookingDate; }
    public void setBookingDate(LocalDateTime bookingDate) { this.bookingDate = bookingDate; }
    
    public FlightInformation getFlightInformation() { return flightInformation; }
    public void setFlightInformation(FlightInformation flightInformation) { this.flightInformation = flightInformation; }
    
    // Formatters (nên lấy từ Validator để thống nhất, nhưng định nghĩa lại để độc lập hơn)
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy h:mma");

    /** In ra tất cả thông tin (dùng cho Print All và Update) */
    public String toFullString() {
        String bookingDateStr = bookingDate.format(DATE_FORMATTER);
        // Sử dụng Getters của FlightInformation
        String flightNumber = flightInformation != null ? flightInformation.getFlightNumber() : "N/A";
        String seatNumber = flightInformation != null ? flightInformation.getSeatNumber() : "N/A";
        String timePickUp = flightInformation != null ? 
                            flightInformation.getTimePickUp().format(DATE_TIME_FORMATTER) : "N/A";

        return String.format("%-6s %-20s %-12s %-4s %-12s %-10s %-8s %s",
                bookingID, customerName, phoneNumber, roomNumber, 
                bookingDateStr, flightNumber, seatNumber, timePickUp);
    }
    
    /** In ra thông tin chỉ cho việc đón sân bay (dùng cho Print Flight Information) */
    public String toFlightPickupString() {
        if (flightInformation == null) return "";
        
        // Sử dụng Getters của FlightInformation
        String flightNumber = flightInformation.getFlightNumber();
        String seatNumber = flightInformation.getSeatNumber();
        String timePickUp = flightInformation.getTimePickUp().format(DATE_TIME_FORMATTER);
        
        return String.format("%-6s %-20s %-12s %-10s %-8s %s",
                bookingID, customerName, phoneNumber, flightNumber, seatNumber, timePickUp);
    }
}