package springstudy.sbburinkle.domain.post.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import springstudy.sbburinkle.domain.comment.entity.Comment;
import springstudy.sbburinkle.domain.user.entity.User;
import springstudy.sbburinkle.global.common.BaseEntity;


import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Post extends BaseEntity {
    private Long id;
    private User user;
    private String title;
    private String content;
    private List<Comment> comments=new ArrayList<>();

    @Builder
    public Post(String title,String content,User user){
        this.title=title;
        this.content=content;
        this.user=user;
    }

}
