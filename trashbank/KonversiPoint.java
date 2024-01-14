package trashbank;

// Kelas untuk konversi point
class KonversiPoint {
  public void konversiPoint(User user, int jumlahPoint) {
      int saldoTambahan = jumlahPoint * 10;
      user.setSaldo(user.getSaldo() + saldoTambahan);
      System.out.println("Konversi point berhasil. Saldo saat ini: " + user.getSaldo());
  }
}
