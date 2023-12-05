package seminar2.task2;

import java.util.UUID;

@Table(name = "users")
public class Employee {
    @Column(name = "id", primaryKey = true)
    private UUID id;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;

    public Employee(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
