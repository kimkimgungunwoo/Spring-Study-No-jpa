package springstudy.sbburinkle.domain.comment.entity;

import lombok.*;
import springstudy.sbburinkle.domain.post.entity.Post;
import springstudy.sbburinkle.domain.user.entity.User;
import springstudy.sbburinkle.global.common.BaseEntity;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Comment extends BaseEntity {
    private Long id;
    private String content;
    private Long postid;
    private Long userid;
    private LocalDateTime createdAt;
    @Builder
    public Comment(String content,
                   Long postid,
                   Long userid
                   ){
        this.content=content;
        this.postid=postid;
        this.userid=userid;
    }
}
