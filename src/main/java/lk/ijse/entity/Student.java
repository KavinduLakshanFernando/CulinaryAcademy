package lk.ijse.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

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
}
