package lk.ijse.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
public class Student {

    @Id
    private String id;

    private String name;

    private String address;

    private String tel;

    private String regDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Student(String id, String name, String address, String tel, String regDate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.regDate = regDate;
    }
}
