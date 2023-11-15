package springstudy.sbburinkle.global.common;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public abstract class BaseEntity {
    private LocalDateTime CreatedAt;
    private LocalDateTime ModifedAt;

    public BaseEntity(){
        this.CreatedAt=LocalDateTime.now();
        this.ModifedAt=LocalDateTime.now();
    }

    public void update(){
        this.ModifedAt=LocalDateTime.now();
    }
}
