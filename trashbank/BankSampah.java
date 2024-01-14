package trashbank;

// Kelas untuk informasi bank sampah
class BankSampah {
    private int hargaKertas;
    private int hargaPlastik;
    private int hargaLogam;

    public BankSampah() {
        hargaKertas = 100;
        hargaPlastik = 200;
        hargaLogam = 500;
    }

    public int getHargaKertas() {
        return hargaKertas;
    }

    public int getHargaPlastik() {
        return hargaPlastik;
    }

    public int getHargaLogam() {
        return hargaLogam;
    }
}