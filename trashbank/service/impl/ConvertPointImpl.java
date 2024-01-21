package trashbank.service.impl;

import trashbank.model.User;
import trashbank.service.ConvertPoint;

public class ConvertPointImpl extends ConvertPoint {
  @Override
  public int konversiPoint(User user, int jumlahPoint) {
      int saldoTambahan = jumlahPoint * 10;
      user.setSaldo(user.getSaldo() + saldoTambahan);

      System.out.println("Konversi point berhasil. Saldo saat ini: " + user.getSaldo());

      return user.getSaldo();
  }
}
