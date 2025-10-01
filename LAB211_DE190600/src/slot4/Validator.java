/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot4;

/**
 *
 * @author ADMIN
 */
import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator {
    private static final Scanner scanner = new Scanner(System.in);

    
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

    
    public static String checkID(String message) {
        String id;
        Pattern idPattern = Pattern.compile("^\\d{6}$"); // Regex cho 6 chữ số
        while (true) {
            System.out.print(message);
            id = scanner.nextLine().trim();
            if (idPattern.matcher(id).matches()) {
                return id;
            }
            System.out.println("Data input is invalid (ID must be 6 digits).");
        }
    }

    
    public static String checkFullName(String message) {
        String name;
        Pattern namePattern = Pattern.compile("^[a-zA-Z\\s]+$"); 
        while (true) {
            System.out.print(message);
            name = scanner.nextLine().trim();
            if (namePattern.matcher(name).matches() && !name.isEmpty()) {
                return name;
            }
            System.out.println("Data input is invalid (Fullname must be alphabet and blanks only).");
        }
    }

    
    public static String checkPhoneNumber(String message) {
        String phone;
        Pattern phonePattern = Pattern.compile("^\\d{12}$"); 
        while (true) {
            System.out.print(message);
            phone = scanner.nextLine().trim();
            if (phonePattern.matcher(phone).matches()) {
                return phone;
            }
            System.out.println("Data input is invalid (Phone number must be 12 digits).");
        }
    }

    
    public static String checkMajor(String message) {
        String major;
        while (true) {
            System.out.print(message);
            major = scanner.nextLine().trim();
            if (!major.isEmpty() && major.length() <= 30) {
                return major;
            }
            System.out.println("Data input is invalid (Major cannot be empty and max 30 characters).");
        }
    }

    
    public static int checkYear(String message, int minYear, int maxYear) {
        int year;
        while (true) {
            System.out.print(message);
            try {
                year = Integer.parseInt(scanner.nextLine().trim());
                if (year >= minYear && year <= maxYear) {
                    return year;
                }
                System.out.println("Data input is invalid (Year must be between " + minYear + " and " + maxYear + ").");
            } catch (NumberFormatException e) {
                System.out.println("Data input is invalid (Please enter a valid integer for Year).");
            }
        }
    }

    
    public static int checkYearOfBirth(String message) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return checkYear(message, 1900, currentYear - 1); 
    }
    
    
    public static double checkDoubleInRange(String message, double min, double max) {
        double number;
        while (true) {
            System.out.print(message);
            try {
                number = Double.parseDouble(scanner.nextLine().trim());
                if (number >= min && number <= max) {
                    return number;
                }
                System.out.println("Data input is invalid (Number must be between " + min + " and " + max + ").");
            } catch (NumberFormatException e) {
                System.out.println("Data input is invalid (Please enter a valid number).");
            }
        }
    }

    
    public static String checkContractType(String message) {
        String type;
        while (true) {
            System.out.print(message);
            type = scanner.nextLine().trim();
            if (type.equalsIgnoreCase("Long") || type.equalsIgnoreCase("Short")) {
                return type;
            }
            System.out.println("Data input is invalid (Contract type must be 'Long' or 'Short').");
        }
    }

    
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
    
    public static double checkNumDouble(String message, boolean requirePositive) {
        double number;
        while (true) {
            System.out.print(message);
            try {
                number = Double.parseDouble(scanner.nextLine().trim());
                if (requirePositive && number < 0) { 
                    System.out.println("The number must be non-negative. Please try again.");
                } else {
                    return number;
                }
            } catch (NumberFormatException e) {
                System.out.println("Data input is invalid. Please enter a valid number.");
            }
        }
    }

     // Hàm kiểm tra Course Name (Java, .Net, C/C++)
    public static String checkCourseName(String message) {
        String course;
        while (true) {
            System.out.print(message);
            course = scanner.nextLine().trim();
            if (course.equalsIgnoreCase("Java") || 
                course.equalsIgnoreCase(".Net") || 
                course.equalsIgnoreCase("C/C++")) {
                // Chuẩn hóa tên Course
                return course.substring(0, 1).toUpperCase() + course.substring(1).toLowerCase();
            }
            System.out.println("Invalid course. Only accept: Java, .Net, C/C++. Please try again.");
        }
    }

    // Hàm kiểm tra lựa chọn Y/N
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
    
    // Hàm kiểm tra lựa chọn Update/Delete (U/D)
    public static String checkUpdateDelete(String message) {
        String input;
        while (true) {
            System.out.print(message);
            input = scanner.nextLine().trim().toUpperCase();
            if (input.equals("U") || input.equals("D")) {
                return input;
            } else {
                System.out.println("Invalid input. Please enter 'U' (Update) or 'D' (Delete).");
            }
        }
    }
    
}
