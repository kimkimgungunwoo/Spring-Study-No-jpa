package springstudy.sbburinkle.domain.comment.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import springstudy.sbburinkle.domain.user.entity.User;

import java.time.LocalDateTime;

@Builder
@Getter
@RequiredArgsConstructor
public class CommentResponse {
    private String content;
    private Long id;
    private User user;
    private LocalDateTime CreatedAt;
}
