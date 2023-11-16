package springstudy.sbburinkle.domain.comment.dto;

import lombok.Builder;
import lombok.NoArgsConstructor;
import springstudy.sbburinkle.domain.comment.entity.Comment;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
public class CommentInfo {
    private String content;
    private Long user_id;
    private LocalDateTime CreateAt;
    @Builder
    public CommentInfo(String content,
                       Long user_id,
                       LocalDateTime CreateAt){
        this.content=content;
        this.user_id=user_id;
        this.CreateAt=CreateAt;
    }
}
