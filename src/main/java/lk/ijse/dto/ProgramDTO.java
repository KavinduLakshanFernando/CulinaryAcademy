package lk.ijse.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProgramDTO {

    private String p_id;
    private String p_name;
    private String duration;
    private double fee;
}
