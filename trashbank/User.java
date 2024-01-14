package trashbank;

class User {
    private String username;
    private String password;
    private String nama;
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
}