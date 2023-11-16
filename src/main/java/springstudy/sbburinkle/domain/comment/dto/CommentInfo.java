package springstudy.sbburinkle.domain.comment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.NoArgsConstructor;
import springstudy.sbburinkle.domain.comment.entity.Comment;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
public class CommentInfo {

    @JsonProperty("content")
    private String content;

    @JsonProperty("userid")
    private Long userid;

    @JsonProperty("CreateAt")
    private LocalDateTime CreateAt;
    @Builder
    public CommentInfo(String content,
                       Long userid,
                       LocalDateTime CreateAt){
        this.content=content;
        this.userid=userid;
        this.CreateAt=CreateAt;
    }
}
