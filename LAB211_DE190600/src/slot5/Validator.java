package slot5;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Validator {
    private static final Scanner scanner = new Scanner(System.in);
    
    // Regular Expressions (Rút gọn logic)
    public static final Pattern ID_PATTERN = Pattern.compile("^\\d{6}$"); // 6 digits
    public static final Pattern PHONE_PATTERN = Pattern.compile("^\\d{12}$"); // 12 digits
    public static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z\\s]+$"); // alphabet and blanks
    public static final Pattern ROOM_PATTERN = Pattern.compile("^\\d{4}$"); // 4 digits

    // Date/Time formatters
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy h:mma");
    
    // Hàm kiểm tra chuỗi không rỗng
    public static String checkString(String message) {
        String input;
        while (true) {
            System.out.print(message);
            input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Data input is invalid (Input cannot be empty).");
        }
    }
    
    // Hàm kiểm tra theo Pattern (chung)
    private static String checkPattern(String message, Pattern pattern, String errorMessage) {
        String input;
        while (true) {
            System.out.print(message);
            input = scanner.nextLine().trim();
            if (pattern.matcher(input).matches()) {
                return input;
            }
            System.out.println("Data input is invalid (" + errorMessage + ").");
        }
    }
    
    // Các hàm kiểm tra cụ thể
    public static String checkID(String message) { return checkPattern(message, ID_PATTERN, "ID must be 6 digits"); }
    public static String checkFullName(String message) { return checkPattern(message, NAME_PATTERN, "Fullname must be alphabet and blanks only"); }
    public static String checkPhoneNumber(String message) { return checkPattern(message, PHONE_PATTERN, "Phone number must be 12 digits"); }
    public static String checkRoomNumber(String message) { return checkPattern(message, ROOM_PATTERN, "Room number must be 4 digits"); }
    
    // Hàm kiểm tra Booking Date (phải sau hiện tại)
    public static LocalDateTime checkBookingDate(String message) {
        LocalDate today = LocalDate.now();
        while (true) {
            System.out.print(message + " (Format: DD/MM/YYYY): ");
            String input = scanner.nextLine().trim();
            try {
                LocalDate datePart = LocalDate.parse(input, DATE_FORMATTER);
                
                if (datePart.isAfter(today)) {
                    return datePart.atStartOfDay(); // Lấy thời gian là 00:00:00
                }
                System.out.println("Data input is invalid (Booking Date must be after present).");
            } catch (DateTimeParseException e) {
                System.out.println("Data input is invalid (Invalid date format or value).");
            }
        }
    }
    
    // Hàm kiểm tra Time Pick Up (sau hiện tại VÀ trước/cùng ngày Booking Date)
    public static LocalDateTime checkTimePickUp(String message, LocalDateTime bookingDate) {
        LocalDateTime now = LocalDateTime.now();
        while (true) {
            System.out.print(message + " (Format: DD/MM/YYYY H:MM[AM/PM]): ");
            String input = scanner.nextLine().trim();
            try {
                LocalDateTime timePickUp = LocalDateTime.parse(input, DATE_TIME_FORMATTER);
                
                if (timePickUp.isAfter(now)) {
                    if (!timePickUp.toLocalDate().isAfter(bookingDate.toLocalDate())) {
                        return timePickUp;
                    }
                    System.out.println("Data input is invalid (Time Pick Up must be before or on Booking Date).");
                } else {
                    System.out.println("Data input is invalid (Time Pick Up must be after present).");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Data input is invalid (Invalid date/time format, e.g., 22/12/2024 10:00AM).");
            }
        }
    }
    
    // Hàm kiểm tra chuỗi có thể rỗng (dùng cho Update)
    public static String checkOptionalString(String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }
    
    public static String checkOptionalString2(String message, String currentValue) {
        System.out.print(message + " (Current: " + currentValue + ", Enter to skip): ");
        return scanner.nextLine().trim();
    }
    
    // Hàm kiểm tra Y/N có thể Skip (trả về null nếu Skip)
    public static Boolean checkYesNoOrSkip(String message) {
        String input;
        while (true) {
            System.out.print(message);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                return null; // Skip update
            }
            input = input.toUpperCase();
            if (input.equals("Y")) {
                return true;
            } else if (input.equals("N")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'Y', 'N', or press Enter to skip.");
            }
        }
    }

    public static boolean checkYesNo(String message) {
        String input;
        while (true) {
            System.out.print(message);
            input = scanner.nextLine().trim().toUpperCase();
            if (input.equals("Y")) {
                return true;
            } else if (input.equals("N")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            }
        }
    }
    
    // Hàm kiểm tra số nguyên
    public static int checkNumInt(String message, boolean requirePositive) {
        int number;
        while (true) {
            System.out.print(message);
            try {
                number = Integer.parseInt(scanner.nextLine().trim());
                if (requirePositive && number < 0) { 
                    System.out.println("The number must be non-negative. Please try again.");
                } else {
                    return number;
                }
            } catch (NumberFormatException e) {
                System.out.println("Data input is invalid. Please enter a valid integer.");
            }
        }
    }
    
    // Hàm kiểm tra số nguyên (dùng cho Credits)
    public static int checkCredits(String message) {
        int number;
        while (true) {
            System.out.print(message);
            try {
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) { // Cho phép Enter để skip trong Update
                    return -1; // Mã hóa giá trị skip
                }
                number = Integer.parseInt(input);
                if (number > 0) { // Credits phải > 0
                    return number;
                }
                System.out.println("Data input is invalid (Credits must be greater than 0).");
            } catch (NumberFormatException e) {
                System.out.println("Data input is invalid (Please enter a valid integer).");
            }
        }
    }
    
    // Hàm kiểm tra Date (Begin) - phải là ngày trong tương lai
    public static LocalDate checkFutureDate(String message) {
        LocalDate today = LocalDate.now();
        while (true) {
            System.out.print(message + " (Format: D/M/YYYY): ");
            String input = scanner.nextLine().trim();
            try {
                LocalDate datePart = LocalDate.parse(input, DATE_FORMATTER);
                
                if (datePart.isAfter(today)) { 
                    return datePart; 
                }
                System.out.println("Data input is invalid (Date must be a future date).");
            } catch (DateTimeParseException e) {
                System.out.println("Data input is invalid (Invalid date format or value).");
            }
        }
    }
    
    // Hàm kiểm tra End Date (phải sau Begin Date)
    public static LocalDate checkEndDate(String message, LocalDate beginDate) {
        LocalDate today = LocalDate.now();
        while (true) {
            System.out.print(message + " (Format: D/M/YYYY): ");
            String input = scanner.nextLine().trim();
            try {
                LocalDate datePart = LocalDate.parse(input, DATE_FORMATTER);
                
                if (datePart.isAfter(today)) {
                    if (datePart.isAfter(beginDate)) { 
                        return datePart; 
                    }
                    System.out.println("Data input is invalid (End date must be after Begin date).");
                } else {
                    System.out.println("Data input is invalid (Date must be a future date).");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Data input is invalid (Invalid date format or value).");
            }
        }
    }
    
    // Hàm kiểm tra loại khóa học (O/F)
    public static String checkCourseType(String message) {
        String input;
        while(true) {
            System.out.print(message);
            input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("O") || input.equalsIgnoreCase("F")) {
                return input.toUpperCase();
            }
            System.out.println("Data input is invalid (Please enter 'O' for Online or 'F' for Offline).");
        }
    }
    
    // Hàm kiểm tra ID có thể rỗng (dùng trong tìm kiếm)
    public static String checkOptionalID(String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }
    
    // Hàm kiểm tra in loại khóa học (A/O/F)
    public static String checkPrintType(String message) {
        String input;
        while(true) {
            System.out.print(message + " (A/O/F): ");
            input = scanner.nextLine().trim().toUpperCase();
            if (input.equals("A") || input.equals("O") || input.equals("F")) {
                return input;
            }
            System.out.println("Invalid input. Please enter 'A' (All), 'O' (Online), or 'F' (Offline).");
        }
    }
    
}