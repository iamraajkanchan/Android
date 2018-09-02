package databasedemo.com.example.raj.ivy.dao;

import databasedemo.com.example.raj.ivy.model.UserData;

public interface UserDao {

    public void addUser(UserData userData);

    public void updateUser(UserData userData);

    public void deleteUser(UserData userData);

    public void displayUser(UserData userData);

}
