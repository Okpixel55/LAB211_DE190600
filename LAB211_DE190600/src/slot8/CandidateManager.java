/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package slot8;


import java.util.*;

// LOP QUAN LY UNG VIEN (CandidateManager)
// Quan ly danh sach (them, tim, hien thi) cac loai ung vien
public class CandidateManager {
    // Danh sach luu tru cac doi tuong Ung Vien (Candidate)
    private final ArrayList<Candidate> list = new ArrayList<>();
    // Doi tuong de doc du lieu tu ban phim (input)
    private final Scanner sc = new Scanner(System.in);

    // ==== PHUONG THUC HO TRO NHAP LIEU ====
    
    // Nhap mot chuoi (String) don gian
    private String input(String msg) {
        System.out.print(msg);
        return sc.nextLine().trim(); // Doc va xoa khoang trang du thua
    }

    // Nhap mot so nguyen (int) trong pham vi (min, max)
    private int inputInt(String msg, int min, int max) {
        while (true) {
            try {
                System.out.print(msg);
                int n = Integer.parseInt(sc.nextLine());
                if (n >= min && n <= max) return n; // Hop le thi tra ve
            } catch (Exception ignored) {}
            System.out.println("→ Invalid number! Please enter between " + min + " and " + max);
        }
    }

    // Nhap dia chi Email, kiem tra dinh dang co ban
    private String inputEmail() {
        while (true) {
            String e = input("Email: ");
            if (e.matches("\\w+@\\w+\\.\\w+")) return e; // Kiem tra Regex
            System.out.println("→ Invalid email format!");
        }
    }

    // Nhap So Dien Thoai (Phone), toi thieu 10 chu so
    private String inputPhone() {
        while (true) {
            String p = input("Phone: ");
            if (p.matches("\\d{10,}")) return p; // Kiem tra 10+ chu so
            System.out.println("→ Phone number must have at least 10 digits!");
        }
    }

    // ==== CHUC NANG TAO UNG VIEN ====
    
    // Tao ung vien moi theo loai (type: 0-Exp, 1-Fresh, 2-Intern)
    public void createCandidate(int type) {
        while (true) {
            System.out.println("\n--- Create " + getTypeName(type) + " Candidate ---");
            // Nhap thong tin chung
            String id = input("ID: ");
            String fn = input("First name: ");
            String ln = input("Last name: ");
            int birth = inputInt("Birth year: ", 1900, Calendar.getInstance().get(Calendar.YEAR));
            String addr = input("Address: ");
            String phone = inputPhone();
            String email = inputEmail();

            Candidate c = null;
            // Nhap thong tin rieng cho tung loai ung vien
            switch (type) {
                case 0 -> { // Ung vien KINH NGHIEM (Experience)
                    int exp = inputInt("Years of experience: ", 0, 100);
                    String skill = input("Professional Skill: ");
                    c = new Experience(id, fn, ln, birth, addr, phone, email, exp, skill);
                }
                case 1 -> { // Ung vien MOI RA TRUONG (Fresher)
                    int grad = inputInt("Graduation year: ", 1900, Calendar.getInstance().get(Calendar.YEAR));
                    String rank;
                    while (true) { // Nhap Hang Tot Nghiep (rank)
                        rank = input("Graduation Rank (Excellence/Good/Fair/Poor): ");
                        if (rank.matches("(?i)(Excellence|Good|Fair|Poor)")) break;
                        System.out.println("→ Invalid rank!");
                    }
                    String edu = input("University: ");
                    c = new Fresher(id, fn, ln, birth, addr, phone, email, grad, rank, edu);
                }
                case 2 -> { // THUC TAP SINH (Intern)
                    String major = input("Majors: ");
                    int sem = inputInt("Semester: ", 1, 12);
                    String uni = input("University: ");
                    c = new Intern(id, fn, ln, birth, addr, phone, email, major, sem, uni);
                }
            }

            list.add(c); // Them vao danh sach
            System.out.print("Do you want to continue (Y/N)? ");
            if (!sc.nextLine().trim().equalsIgnoreCase("Y")) break; // Dung neu nhap 'N'
        }
        displayAll(); // Hien thi toan bo danh sach
    }

    // ==== CHUC NANG HIEN THI ====
    
    // Tra ve ten loai ung vien tu ma so (0, 1, 2)
    private String getTypeName(int type) {
        return switch (type) {
            case 0 -> "Experience";
            case 1 -> "Fresher";
            case 2 -> "Intern";
            default -> "Unknown";
        };
    }

    // Hien thi ten day du cua tat ca ung vien, phan theo loai
    public void displayAll() {
        System.out.println("\n===== EXPERIENCE =====");
        // Loc va in ten Ung vien Kinh nghiem (Type 0)
        list.stream().filter(c -> c.getType() == 0).forEach(c -> System.out.println(c.getFullName()));
        System.out.println("===== FRESHER =====");
        // Loc va in ten Ung vien Moi ra truong (Type 1)
        list.stream().filter(c -> c.getType() == 1).forEach(c -> System.out.println(c.getFullName()));
        System.out.println("===== INTERN =====");
        // Loc va in ten Thuc tap sinh (Type 2)
        list.stream().filter(c -> c.getType() == 2).forEach(c -> System.out.println(c.getFullName()));
    }

    // ==== CHUC NANG TIM KIEM ====
    
    // Tim kiem ung vien theo Ten (mot phan) va Loai
    public void search() {
        if (list.isEmpty()) {
            System.out.println("No candidates available!");
            return;
        }
        displayAll(); // Hien thi tong quan
        // Nhap ten can tim (first name HOAC last name)
        String name = input("Enter candidate name (first or last): ").toLowerCase();
        // Nhap loai ung vien
        int type = inputInt("Enter candidate type (0:Exp, 1:Fresh, 2:Intern): ", 0, 2);

        System.out.println("\nCandidates found:");
        // Loc danh sach:
        // 1. Phai khop loai (type)
        // 2. Ten (hoac ten dem/ten) co chua chuoi tim kiem (name)
        // 3. In ra thong tin ung vien tim duoc
        list.stream()
                .filter(c -> c.getType() == type &&
                        (c.firstName.toLowerCase().contains(name) ||
                         c.lastName.toLowerCase().contains(name)))
                .forEach(System.out::println);
    }
}