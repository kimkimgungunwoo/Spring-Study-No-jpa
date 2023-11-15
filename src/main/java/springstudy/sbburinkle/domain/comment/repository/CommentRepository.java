package springstudy.sbburinkle.domain.comment.repository;

import org.springframework.stereotype.Repository;
import springstudy.sbburinkle.domain.comment.dto.CommentCreateRequest;
import springstudy.sbburinkle.domain.comment.entity.Comment;
import springstudy.sbburinkle.domain.post.entity.Post;
import springstudy.sbburinkle.domain.user.entity.User;

import java.util.List;

@Repository

public interface CommentRepository {
    Comment CreateComment(CommentCreateRequest commentcreaterequest);
    List<Comment> GetPostCommentList(Post post);
    List<Comment> GetUserCommentList(User user);
}
