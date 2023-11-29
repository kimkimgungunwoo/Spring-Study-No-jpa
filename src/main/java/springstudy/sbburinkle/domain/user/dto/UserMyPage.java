package springstudy.sbburinkle.domain.user.dto;

import lombok.*;
import springstudy.sbburinkle.domain.comment.dto.CommentInfo;
import springstudy.sbburinkle.domain.post.dto.PostInfo;

import java.util.List;

@Getter
@Setter
@Builder
public class UserMyPage {
    private String email;
    private String nickname;
    private List<PostInfo> UserPostList;
    private List<CommentInfo> UserCommentList;


}
