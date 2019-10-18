package fr.dawan.cart.bean;


import java.io.Serializable;
import java.util.Date;

/*

CREATE TABLE Utilisateur(
        idActeur            int (11) Auto_increment  NOT NULL,
        foreName              Varchar (70) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
        mdpMD5              Varchar (255) NOT NULL,
        email               Varchar (70) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
		date              	Varchar (255) ,
		role                  int (11),
        PRIMARY KEY (idActeur )
)ENGINE=InnoDB;
 */

public class User implements Serializable {
    private int id;
    private String foreName;
    private String email;
    private String password;
    private String phoneNumber;
    private Date date;
    private int role;
    private Boolean validation;

    public Boolean getValidation() {
        return validation;
    }

    public void setValidation(Boolean validation) {
        this.validation = validation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getForeName() {
        return foreName;
    }

    public void setForeName(String foreName) {
        this.foreName = foreName;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", foreName='" + foreName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", date=" + date +
                ", role=" + role +
                ", validation=" + validation +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (role != user.role) return false;
        if (foreName != null ? !foreName.equals(user.foreName) : user.foreName != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(user.phoneNumber) : user.phoneNumber != null) return false;
        if (date != null ? !date.equals(user.date) : user.date != null) return false;
        return validation != null ? validation.equals(user.validation) : user.validation == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (foreName != null ? foreName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + role;
        result = 31 * result + (validation != null ? validation.hashCode() : 0);
        return result;
    }
}
