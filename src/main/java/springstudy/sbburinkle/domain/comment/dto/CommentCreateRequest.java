package springstudy.sbburinkle.domain.comment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import springstudy.sbburinkle.domain.post.entity.Post;
import springstudy.sbburinkle.domain.user.entity.User;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CommentCreateRequest {

    private String content;
    private Long userid;
    @Builder
    public CommentCreateRequest(String content,Long userid){
        this.content=content;
        this.userid=userid;
    }
}
