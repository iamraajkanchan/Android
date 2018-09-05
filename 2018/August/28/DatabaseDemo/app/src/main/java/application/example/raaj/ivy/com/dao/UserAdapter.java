package application.example.raaj.ivy.com.dao;

import application.example.raaj.ivy.com.model.Userdata;

public interface UserAdapter {

    public void addUser(Userdata ud);
    public void updateUser(Userdata ud);
    public void deleteUser(Userdata ud);
    public void displayUser(Userdata ud);

}
