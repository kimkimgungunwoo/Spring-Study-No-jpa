package springstudy.sbburinkle.domain.comment.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springstudy.sbburinkle.domain.comment.dto.CommentCreateRequest;
import springstudy.sbburinkle.domain.comment.dto.CommentInfo;
import springstudy.sbburinkle.domain.comment.entity.Comment;
import springstudy.sbburinkle.domain.comment.repository.CommentRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    private List<Comment> CommentList = new ArrayList<>();
    Long a=0L;
    public Comment CreateCommentToEnity(CommentCreateRequest createRequest,Long postid,Long userId){
        Comment comment= Comment.builder()

                .content(createRequest.getContent())
                .postid(postid)
                .userid(userId)
                .build();
        comment.setId(a++);
        comment.setCreatedAt(LocalDateTime.now());
        return comment;
    }

    public CommentInfo MapCommentEntityToCommetInfo(Comment comment){
        return CommentInfo.builder()
                .content(comment.getContent())
                .userid(comment.getUserid())
                .CreateAt(comment.getCreatedAt())
                .build();

    }
    public CommentInfo CreateComment(CommentCreateRequest createRequest,Long postid,Long userId){
        Comment comment = CreateCommentToEnity(createRequest,postid,userId);
        CommentList.add(comment);
        CommentInfo commentInfo=MapCommentEntityToCommetInfo(comment);
        return commentInfo;

    }

    public List<CommentInfo> GetPostCommentList(Long postid){
        List<CommentInfo> CommentInfoList=new ArrayList<>();
        for(int i=0;i<CommentList.size();i++){
            if(CommentList.get(i).getPostid().equals(postid)){
                CommentInfoList.add(CommentInfo.builder()
                        .content(CommentList.get(i).getContent())
                        .userid(CommentList.get(i).getUserid())
                        .CreateAt(CommentList.get(i).getCreatedAt())
                        .build());
            }
        }
        return CommentInfoList;
    }

    public List<CommentInfo> GetUserCommentList(Long userid){
        List<CommentInfo> userCommetList=new ArrayList<>();
        for(int i=0;i<CommentList.size();i++) {
            if (CommentList.get(i).getUserid().equals(userid)){
                userCommetList.add(CommentInfo.builder()
                            .content(CommentList.get(i).getContent())
                            .CreateAt(CommentList.get(i).getCreatedAt())
                            .userid(CommentList.get(i).getUserid())
                        .build()
                );
            }
        }
        return userCommetList;
    }
}
