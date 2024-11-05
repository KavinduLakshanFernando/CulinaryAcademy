package lk.ijse.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
public class User {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long u_id;
    private String password;
    private String role;
    private String u_name;

//    public User(String u_name, String password, String role) {
//
//        this.u_name = u_name;
//        this.password = password;
//        this.role = role;
//    }
}
