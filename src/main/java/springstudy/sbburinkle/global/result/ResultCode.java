package springstudy.sbburinkle.global.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter

@AllArgsConstructor
public enum ResultCode {

    // 댓글 관련한 애들
    GET_ALL_COMMENT_SUCCESS("C001", "코멘트 전체 조회 성공"),
    CREAT_COMMENT_SUCCESS("C0002","코멘트 등록 성공"),
    GET_COMMENT_SUCCESS("C0003","코멘트 읽기 성공"),
    DELETE_COMMENT_SUCCESS("C004","코멘트 삭제 상공")

    ;



    private final String code;
    private final String message;







}
