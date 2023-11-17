package springstudy.sbburinkle.domain.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder

public class UserInfo {
    private String nickname;
    private Long id;
    private String email;
    private String Location;
    private LocalDateTime createdAt;
    @Builder
    public UserInfo(String nickname,
                    Long id,
                    String email,
                    String Location,
                    LocalDateTime createdAt
                    ) {
        this.nickname = nickname;
        this.id=id;
        this.email=email;
        this.Location=Location;
        this.createdAt=createdAt;
    }
}
