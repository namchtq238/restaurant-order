package gogitek.restaurantorder.service;

import gogitek.restaurantorder.entity.User;

public interface UserService {
    boolean registerUser(User user);
    boolean checkExist(String email);
    User getCurrentUser();
    void updateUser(int id, User userRequest);
}
