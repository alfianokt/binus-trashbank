package trashbank.service;

import java.util.ArrayList;
import java.util.List;

import trashbank.model.User;

public class UserManager {
  private List<User> users;

  public UserManager() {
    users = new ArrayList<>();
  }

  public void registerUser(String username, String password, String nama) {
    User user = new User(username, password, nama);
    users.add(user);
    System.out.println("Pendaftaran pengguna berhasil.");
  }

  public User authenticateUser(String username, String password) {
    for (User user : users) {
      if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
        return user;
      }
    }
    return null;
  }

  public User findUserByUsername(String username) {
    for (User user : users) {
      if (user.getUsername().equals(username)) {
        return user;
      }
    }
    return null;
  }
}