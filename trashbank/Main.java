package trashbank;

import java.util.Scanner;

public class Main {
    private static final int MENU_REGISTER = 1;
    private static final int MENU_LOGIN = 2;
    private static final int MENU_PROFILE = 3;
    private static final int MENU_BANK_INFO = 4;
    private static final int MENU_INPUT_TRANSACTION = 5;
    private static final int MENU_CONVERT_POINTS = 6;
    private static final int MENU_EXIT = 7;

    private static Scanner scanner = new Scanner(System.in);
    private static UserManager userManager = new UserManager();
    private static User loggedInUser;

    private static void showMenu() {
        System.out.println("\n=== Sistem Bank Sampah ===");
        if (loggedInUser == null) {
            System.out.println("1. Registrasi Pengguna");
            System.out.println("2. Masuk");
        } else {
            System.out.println("3. Profile Pengguna");
            System.out.println("4. Informasi Bank Sampah");
            System.out.println("5. Input Transaksi");
            System.out.println("6. Konversi Point");
        }
        System.out.println("7. Keluar");
        System.out.print("Pilih menu: ");
    }

    private static void registerUser() {
        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();

        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        System.out.print("Masukkan nama: ");
        String name = scanner.nextLine();

        userManager.registerUser(username, password, name);

        System.out.println("Pendaftaran pengguna berhasil.");
    }

    private static void loginUser() {
        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();

        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        loggedInUser = userManager.authenticateUser(username, password);

        if (loggedInUser != null) {
            System.out.println("Login berhasil.");
        } else {
            System.out.println("Login gagal. Periksa kembali username dan password Anda.");
        }
    }

    private static void userProfile() {
        System.out.println("=== Profile Pengguna ===");
        System.out.println("Username\t: " + loggedInUser.getUsername());
        System.out.println("Nama\t\t: " + loggedInUser.getNama());
        System.out.println("Point\t\t: " + loggedInUser.getSaldo());
    }

    private static void bankInfo() {
        System.out.println("=== Informasi Bank Sampah ===");
        System.out.println("Bank Sampah XYZ adalah bank sampah terkemuka \nyang berkomitmen untuk mendaur ulang sampah \ndan memberikan insentif kepada pengguna.");
    }

    private static void inputTransaction() {
        System.out.println("=== Input Transaksi ===");
        System.out.println("Jenis Barang:");
        System.out.println("1. Kertas");
        System.out.println("2. Plastik");
        System.out.println("3. Logam");
        System.out.print("Pilih jenis sampah: ");
        int jenisBarang = scanner.nextInt();

        System.out.print("Masukkan jumlah sampah: ");
        int jumlah = scanner.nextInt();

        TransaksiManager transaksiManager = new TransaksiManager();
        int totalPoint = transaksiManager.inputTransaksi(jenisBarang, jumlah);

        if (totalPoint > 0) {
            loggedInUser.setSaldo(loggedInUser.getSaldo() + totalPoint);
            System.out.println("Transaksi berhasil. Saldo saat ini: " + loggedInUser.getSaldo());
        } else {
            System.out.println("Transaksi gagal. Saldo tidak valid.");
        }
    }

    private static void convertPoints() {
        System.out.println("=== Konversi Point ===");
        int totalPoints = loggedInUser.getSaldo();

        System.out.println("Jumlah poin Anda: " + totalPoints);
        System.out.println("Nilai poin: 1 koin = 1 rupiah");

        System.out.print("Masukkan jumlah koin yang ingin dikonversi: ");
        int jumlahKoin = scanner.nextInt();

        int rupiah = jumlahKoin * 1;
        System.out.println("Jumlah rupiah yang Anda dapatkan: " + rupiah);
    }

    public static void main(String[] args) {
        int choice;

        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Membersihkan karakter newline di buffer

            switch (choice) {
                case MENU_REGISTER:
                    registerUser();
                    break;
                case MENU_LOGIN:
                    loginUser();
                    break;
                case MENU_PROFILE:
                    if (loggedInUser != null) {
                        userProfile();
                    } else {
                        System.out.println("Anda harus masuk terlebih dahulu.");
                    }
                    break;
                case MENU_BANK_INFO:
                    if (loggedInUser != null) {
                        bankInfo();
                    } else {
                        System.out.println("Anda harus masuk terlebih dahulu.");
                    }
                    break;
                case MENU_INPUT_TRANSACTION:
                    if (loggedInUser != null) {
                        inputTransaction();
                    } else {
                        System.out.println("Anda harus masuk terlebih dahulu.");
                    }
                    break;
                case MENU_CONVERT_POINTS:
                    if (loggedInUser != null) {
                        convertPoints();
                    } else {
                        System.out.println("Anda harus masuk terlebih dahulu.");
                    }
                    break;
                case MENU_EXIT:
                    System.out.println("Terima kasih! Sampai jumpa.");
                    break;
                default:
                    System.out.println("Menu tidak valid. Silakan pilih lagi.");
                    break;
            }
        } while (choice != MENU_EXIT);
    }
}