package app.dto;

import lombok.*;

@Data
@ToString
@Setter @Getter
@NoArgsConstructor
@AllArgsConstructor
public class GamerDto {

    private String gamerId;

    private String country;

    private Integer money;

}
