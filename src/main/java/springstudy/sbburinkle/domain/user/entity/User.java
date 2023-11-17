package springstudy.sbburinkle.domain.user.entity;

import lombok.*;
import springstudy.sbburinkle.domain.comment.entity.Comment;
import springstudy.sbburinkle.domain.post.entity.Post;
import springstudy.sbburinkle.global.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Setter
@Builder
@Getter
@NoArgsConstructor
public class User extends BaseEntity {
    private Long id;
    private String nickname;
    private String email;
    private String password;
    private String location;

    @Builder
    public User(Long id,
                String nickname,
                String email,
                String password,
                String location) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.location = location;
    }




    }



