package slot5.short107;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import slot5.Validator; // Import Validator

public class ReservationManager extends Menu<String> {
    
    private final List<Reservation> reservationList;
    
    // Sử dụng formatter từ Validator để nhất quán
    public static final DateTimeFormatter DATE_FORMATTER = Validator.DATE_FORMATTER;
    public static final DateTimeFormatter DATE_TIME_FORMATTER = Validator.DATE_TIME_FORMATTER;

    public ReservationManager() {
        super("*** Reservation Management ***", 
                new String[]{"Create new reservation", "Update reservation", 
                             "Delete reservation", "Print Flight Information", 
                             "Print all", "Exit"});
        this.reservationList = new ArrayList<>();
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1: createReservation(); break;
            case 2: updateReservation(); break;
            case 3: deleteReservation(); break;
            case 4: printFlightInformation(); break;
            case 5: printAllReservations(); break;
            case 6: 
                System.out.println("BYE AND SEE YOU NEXT TIME");
                // Menu.run() sẽ tự break sau khi thực thi case 6
                break;
            default: System.out.println("Invalid choice. Please select again.");
        }
    }

    private void createReservation() {
        System.out.println("\n*** Create new reservation ***");
        int numReservations = Validator.checkNumInt("Enter number of reservations to create: ", true);
        
        for (int i = 0; i < numReservations; i++) {
            System.out.println("\n--- Reservation " + (i + 1) + " ---");
            
            // 1. ID - 6 digits and unique
            String id;
            do {
                id = Validator.checkID("ID: ");
                if (findReservationById(id) != null) {
                    System.out.println("Data input is invalid (ID is not unique).");
                }
            } while (findReservationById(id) != null);
            
            String name = Validator.checkFullName("Name: ");
            String phone = Validator.checkPhoneNumber("Phone: ");
            String room = Validator.checkRoomNumber("RoomNumbers: ");
            LocalDateTime bookingDate = Validator.checkBookingDate("BookingDate: ");
            
            FlightInformation flightInfo = null;
            
            if (Validator.checkYesNo("Need airport pick up? (Y/N): ")) {
                String flight = Validator.checkString("Flight: ");
                String seat = Validator.checkString("Seat: ");
                // Dùng bookingDate vừa nhập
                LocalDateTime timePickUp = Validator.checkTimePickUp("TimePickUp: ", bookingDate);
                
                flightInfo = new FlightInformation(flight, seat, timePickUp);
            }
            
            Reservation newRes = new Reservation(id, name, phone, room, bookingDate, flightInfo);
            reservationList.add(newRes);
            System.out.println("Information saved successfully.");
        }
    }

    private void updateReservation() {
        System.out.println("\n*** Update reservation ***");
        Reservation res = findReservationInteractive();
        if (res == null) return;
        
        System.out.println("\n--- Current Information ---");
        printReservationHeader();
        System.out.println(res.toFullString());
        System.out.println("---------------------------");
        System.out.println("If you do not want to change the information, just press enter to skip.");
        
        // 1. Update Name - Dùng Getter để in ra, dùng Setter để cập nhật
        String nameInput = Validator.checkOptionalString("Name (" + res.getCustomerName() + "): ");
        if (!nameInput.isEmpty()) {
            if (Validator.NAME_PATTERN.matcher(nameInput).matches()) {
                res.setCustomerName(nameInput); 
            } else { System.out.println("Data input is invalid (Fullname...). Skipping update."); }
        }
        
        // 2. Update Phone
        String phoneInput = Validator.checkOptionalString("Phone (" + res.getPhoneNumber() + "): ");
        if (!phoneInput.isEmpty()) {
            if (Validator.PHONE_PATTERN.matcher(phoneInput).matches()) {
                res.setPhoneNumber(phoneInput);
            } else { System.out.println("Data input is invalid (Phone...). Skipping update."); }
        }
        
        // 3. Update Room
        String roomInput = Validator.checkOptionalString("RoomNumbers (" + res.getRoomNumber() + "): ");
        if (!roomInput.isEmpty() && Validator.ROOM_PATTERN.matcher(roomInput).matches()) { 
            res.setRoomNumber(roomInput); 
        } else if (!roomInput.isEmpty()) { System.out.println("Data input is invalid (Room...). Skipping update."); }

        // 4. Update Booking Date
    String dateInput = Validator.checkOptionalString("BookingDate (" + res.getBookingDate().format(DATE_FORMATTER) + "): ");
        if (!dateInput.isEmpty()) {
            try {
                // Tạo LocalDate từ input, sau đó chuyển thành LocalDateTime (00:00:00)
                LocalDateTime tempDate = LocalDate.parse(dateInput, DATE_FORMATTER).atStartOfDay();
                if (tempDate.toLocalDate().isAfter(LocalDateTime.now().toLocalDate())) {
                    res.setBookingDate(tempDate); 
                } else { System.out.println("Data input is invalid (Booking Date must be after present). Skipping update."); }
            } catch (Exception e) { System.out.println("Data input is invalid (Invalid date format). Skipping update."); }
        }
        
        // 5. Update Flight Information
        Boolean needPickup = Validator.checkYesNoOrSkip("Need airport pick up? (Y/N): ");
        if (needPickup != null) {
            if (needPickup) {
                // Lấy thông tin hiện tại (dùng Getters)
                String currentFlightNum = res.getFlightInformation() != null ? res.getFlightInformation().getFlightNumber() : "N/A";
                String currentSeatNum = res.getFlightInformation() != null ? res.getFlightInformation().getSeatNumber() : "N/A";

                String flight = Validator.checkString("Flight (" + currentFlightNum + "): ");
                String seat = Validator.checkString("Seat (" + currentSeatNum + "): ");
                
                // Dùng BookingDate đã được cập nhật (res.getBookingDate())
                LocalDateTime requiredTimePickUp = Validator.checkTimePickUp("TimePickUp: ", res.getBookingDate()); 
                
                // Nếu FlightInformation đã tồn tại, cập nhật nó. Nếu chưa, tạo mới.
                FlightInformation flightInfoToUpdate = res.getFlightInformation() != null ? res.getFlightInformation() : new FlightInformation();
                
                flightInfoToUpdate.setFlightNumber(flight);
                flightInfoToUpdate.setSeatNumber(seat);
                flightInfoToUpdate.setTimePickUp(requiredTimePickUp);
                
                res.setFlightInformation(flightInfoToUpdate); 
            } else { 
                res.setFlightInformation(null); // Xóa thông tin đón sân bay
            }
        }
        
        System.out.println("Information updated successfully.");
    }
    
    private void deleteReservation() {
        System.out.println("\n*** Delete reservation ***");
        Reservation res = findReservationInteractive();
        if (res == null) return;
        
        System.out.println("\n--- Information to Delete ---");
        printReservationHeader();
        System.out.println(res.toFullString());
        System.out.println("---------------------------");

        if (Validator.checkYesNo("Are you sure you want to delete this information? (Y/N): ")) {
            reservationList.remove(res);
            System.out.println("Information deleted successfully.");
        } else {
            System.out.println("Deletion cancelled.");
        }
    }

    private void printFlightInformation() {
        System.out.println("\n*** Flight Information ***");
        
        // Lọc và sắp xếp: Dùng Getters trong Comparator
        List<Reservation> pickupList = reservationList.stream()
                .filter(res -> res.getFlightInformation() != null)
                .sorted(Comparator.comparing(res -> res.getFlightInformation().getTimePickUp()))
                .toList(); 

        if (pickupList.isEmpty()) {
            System.out.println("No reservation needs airport pick up.");
            return;
        }
        
        System.out.println("----------------------------------------------------------------------------------");
        System.out.printf("%-6s %-20s %-12s %-10s %-8s %s\n", "ID", "Name", "Phone", "Flight", "Seat", "TimePickUp");
        System.out.println("----------------------------------------------------------------------------------");
        
        for (Reservation res : pickupList) {
            System.out.println(res.toFlightPickupString());
        }
        System.out.println("----------------------------------------------------------------------------------");
    }

    private void printAllReservations() {
        System.out.println("\n*** Reservation Information ***");
        
        if (reservationList.isEmpty()) {
            System.out.println("No information to view.");
            return;
        }
        
        printReservationHeader();
        
        for (Reservation res : reservationList) {
            System.out.println(res.toFullString());
        }
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
    }
    
    // --- Helper Methods ---
    
    private Reservation findReservationById(String id) {
        for (Reservation res : reservationList) {
            if (res.getBookingID().equalsIgnoreCase(id)) { // Dùng Getter
                return res;
            }
        }
        return null;
    }

    private Reservation findReservationInteractive() {
        String id;
        Reservation res = null;
        boolean findAgain = true;
        
        while (findAgain) {
            id = Validator.checkID("bookingID/ID: ");
            res = findReservationById(id);
            
            if (res == null) {
                System.out.println("No information found.");
                findAgain = Validator.checkYesNo("You want to find again? (Y/N): ");
            } else {
                findAgain = false;
            }
        }
        return res;
    }
    
    private void printReservationHeader() {
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-6s %-20s %-12s %-4s %-12s %-10s %-8s %s\n", 
                          "ID", "Name", "Phone", "Room", "BookingDate", "Flight", "Seat", "TimePickUp");
        System.out.println("---------------------------------------------------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        ReservationManager manager = new ReservationManager();
        manager.run();
    }
}