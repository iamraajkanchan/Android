package databasedemo.com.example.raj.ivy.model;

public class UserData {

    String username;
    String name;
    String email;
    String password;
    String imageURI;

    public UserData(){

    }

    public UserData(String username, String name, String email, String password, String imageURI){
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.imageURI = imageURI;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImageURI() { return imageURI;}

    public void setImageURI(String imageURI) { this.imageURI = imageURI; }

    @Override
    public String toString() {
        return "UserData{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", imageURI='" + imageURI + '\'' +
                '}';
    }
}
