package springstudy.sbburinkle.domain.post.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PostInfo {
    private Long userid;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long id;
    @Builder
    public PostInfo(Long userid,
                    String title,
                    String content,
                    Long id
                    )
    {
        this.userid=userid;
        this.title=title;
        this.content=content;
        this.id=id;
    }
}
