package springstudy.sbburinkle.domain.post.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import springstudy.sbburinkle.domain.post.entity.Post;

@NoArgsConstructor
@Getter
public class PostCreateRequest {
    private String title;
    private String content;
    private Long userid;

    @Builder
    public PostCreateRequest(String title,String content,Long userid){
        this.title=title;
        this.content=content;
        this.userid=userid;
    }

}
