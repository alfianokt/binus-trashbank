package trashbank.model;

public class User {
    private String username;
    private String password;
    private String nama;
    private TransactionHistory[] histories;
    private int saldo;

    public User(String username, String password, String nama) {
        this.username = username;
        this.password = password;
        this.nama = nama;
        this.saldo = 0;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNama() {
        return nama;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public TransactionHistory[] getHistories() {
        return histories;
    }

    public void setHistories(TransactionHistory[] histories) {
        this.histories = histories;
    }

    public void addHistories(TransactionHistory newHistory) {
        if (histories == null) {
            histories = new TransactionHistory[1];
            histories[0] = newHistory;
        } else {
            TransactionHistory[] newHistories = new TransactionHistory[histories.length + 1];
            System.arraycopy(histories, 0, newHistories, 0, histories.length);
            newHistories[histories.length] = newHistory;
            histories = newHistories;
        }
    }
}