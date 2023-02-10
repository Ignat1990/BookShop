package bean;


import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JoinColumn(name = "book_id")
    private int id;
    @Column(name = "login")
    private String login;
    @Column(name = "passwordHash")
    private String passwordHash;
    @Column(name = "balance")
    private float balance;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone")
    private int phone;
    @Column(name = "email")
    private String email;

    @Column(name = "user_role")
    private String userRole;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "name")
    private Roles role;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Review review;

    @Column(name = "user_ban")
    private boolean userBan;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public boolean isUserBan() {
        return userBan;
    }

    public void setUserBan(boolean userBan) {
        this.userBan = userBan;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", balance=" + balance +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", userRole='" + userRole + '\'' +
                ", userBan=" + userBan +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id && Float.compare(users.balance, balance) == 0 && phone == users.phone && userBan == users.userBan && Objects.equals(login, users.login) && Objects.equals(passwordHash, users.passwordHash) && Objects.equals(firstName, users.firstName) && Objects.equals(lastName, users.lastName) && Objects.equals(email, users.email) && Objects.equals(userRole, users.userRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, passwordHash, balance, firstName, lastName, phone, email, userRole, userBan);
    }
}
