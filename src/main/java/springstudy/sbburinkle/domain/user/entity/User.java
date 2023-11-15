package springstudy.sbburinkle.domain.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import springstudy.sbburinkle.domain.comment.entity.Comment;
import springstudy.sbburinkle.domain.post.entity.Post;
import springstudy.sbburinkle.global.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class User extends BaseEntity {
    private Long id;
    private String nickname;
    private String email;
    private String password;
    private String location;
    private List<Post> posts=new ArrayList<>();
    private List<Comment> commets=new ArrayList<>();


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



