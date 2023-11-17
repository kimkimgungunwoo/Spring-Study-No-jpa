package springstudy.sbburinkle.domain.user.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreateRequest {
    private String nickname;
    private String password;
    private String email;
    private String Location;
}
