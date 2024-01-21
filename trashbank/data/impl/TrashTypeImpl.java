package trashbank.data.impl;

import trashbank.data.TrashType;

public class TrashTypeImpl implements TrashType {
  private int hargaKertas = 100;
  private int hargaPlastik = 200;
  private int hargaLogam = 500;

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
