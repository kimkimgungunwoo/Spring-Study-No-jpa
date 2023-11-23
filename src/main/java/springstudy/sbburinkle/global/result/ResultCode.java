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
    DELETE_COMMENT_SUCCESS("C004","코멘트 삭제 상공"),
    
    //게시글 관련한 애들
    GET_ALL_POST_SUCCESS("P001","글 전체 조회 성공"),
    CREATE_POST_SUCCESS("P002","글 등록 성공"),
    GET_POST_SUCCESS("P003","글 조회 성공"),
    GET_ALL_USER_POST_SUCCESS("P004","유저 글 리스트 조회 성공"),

    //유저 관련한 애들
    GET_USER_SUCCESS("U001","유저 읽기 성공"),
    CREATE_USER_SUCCESS("U002","유저생성성공"),
    GET_ALL_USER_SUCCESS("U003","유저 모두 읽기 성공"),
    LOGIN_SUCCESS("U004","로그인 성공"),
    LOGOUT_SUCCESS("U005","로그아웃 성공")
    ;



    private final String code;
    private final String message;







}
