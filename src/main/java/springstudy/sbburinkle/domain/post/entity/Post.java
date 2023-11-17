package springstudy.sbburinkle.domain.post.entity;

import lombok.*;
import springstudy.sbburinkle.domain.comment.entity.Comment;
import springstudy.sbburinkle.domain.user.entity.User;
import springstudy.sbburinkle.global.common.BaseEntity;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post extends BaseEntity {
    private Long id;
    private Long userid;
    private String title;
    private String content;
    @Builder
    public Post(String title,String content,Long userid){
        this.title=title;
        this.content=content;
        this.userid=userid;
    }

}
