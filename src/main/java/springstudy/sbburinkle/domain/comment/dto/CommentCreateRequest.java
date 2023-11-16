package springstudy.sbburinkle.domain.comment.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import springstudy.sbburinkle.domain.post.entity.Post;
import springstudy.sbburinkle.domain.user.entity.User;

import java.time.LocalDateTime;

@Builder
@Getter
@RequiredArgsConstructor
public class CommentCreateRequest {
    private final String content;
    private final Long userid;

}
