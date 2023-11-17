package springstudy.sbburinkle.global.common;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class BaseEntity {
    private LocalDateTime CreatedAt;
    private LocalDateTime updatedAt;

    public BaseEntity(){
        this.CreatedAt=LocalDateTime.now();
        this.updatedAt=LocalDateTime.now();
    }

    public void update(){
        this.updatedAt=LocalDateTime.now();
    }
}
