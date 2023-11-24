package springstudy.sbburinkle.domain.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
@Setter
public class UserLoginResponseInfo {
    private Long userid;
    private String Key;

    @Builder
    public UserLoginResponseInfo(
            Long userid,
            String key
    ){
        this.userid=userid;
        this.Key=key;
    }
}
