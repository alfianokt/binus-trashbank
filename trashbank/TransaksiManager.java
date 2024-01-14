package trashbank;

// Kelas untuk input transaksi
class TransaksiManager {
    public static final int KERTAS = 1;
    public static final int PLASTIK = 2;
    public static final int LOGAM = 3;

    public int inputTransaksi(int jenisBarang, int jumlah) {
        BankSampah bankSampah = new BankSampah();

        int harga = 0;
        switch (jenisBarang) {
            case KERTAS:
                harga = bankSampah.getHargaKertas();
                break;
            case PLASTIK:
                harga = bankSampah.getHargaPlastik();
                break;
            case LOGAM:
                harga = bankSampah.getHargaLogam();
                break;
            default:
                System.out.println("Jenis barang tidak valid.");
                return 0;
        }

        int totalHarga = harga * jumlah;

        return totalHarga;
    }
}