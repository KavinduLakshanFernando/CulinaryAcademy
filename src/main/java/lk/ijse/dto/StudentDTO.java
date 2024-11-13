package lk.ijse.dto;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

public class StudentDTO {

    private String id;

    private String name;

    private String address;

    private String tel;

    private String regDate;

}
