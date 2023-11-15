package springstudy.sbburinkle.domain.comment.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import springstudy.sbburinkle.domain.post.entity.Post;
import springstudy.sbburinkle.domain.user.entity.User;
import springstudy.sbburinkle.global.common.BaseEntity;

@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Comment extends BaseEntity {
    private Long id;
    private String content;
    private Long postid;
    private Long userid;

    @Builder
    public Comment(String content,
                   Long postid,
                   Long userid){
        this.content=content;
        this.postid=postid;
        this.userid=userid;
    }
}
