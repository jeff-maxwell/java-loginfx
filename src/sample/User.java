package sample;

public class User {
    private String name;
    private String username;
    private String email;
    private String password;
    private String salt;

    public String getName() {
        return this.name;
    }

    public void setName(String _value) {
        this.name = _value;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String _value) {
        this.username = _value;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String _value) {
        this.email = _value;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String _value) {
        this.password = _value;
    }

    public String getSalt() {
        return this.salt;
    }

    public void setSalt(String _value) {
        this.salt = _value;
    }
}
