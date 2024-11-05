package lk.ijse.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private long userId;
    private String password;
    private String role;
    private String username;

}
