package databasedemo.com.example.raj.ivy.dao;

import java.util.ArrayList;

import databasedemo.com.example.raj.ivy.model.UserData;

public interface UserDao {

    long addUser(UserData userData);

    void updateUser(UserData userData);

    void deleteUser(String username);

    ArrayList<UserData> displayUser();

}
