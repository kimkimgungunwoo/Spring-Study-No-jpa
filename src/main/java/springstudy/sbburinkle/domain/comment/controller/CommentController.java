package springstudy.sbburinkle.domain.comment.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springstudy.sbburinkle.domain.comment.dto.CommentCreateRequest;
import springstudy.sbburinkle.domain.comment.dto.CommentInfo;
import springstudy.sbburinkle.domain.comment.entity.Comment;
import springstudy.sbburinkle.domain.comment.service.CommentService;
import springstudy.sbburinkle.global.result.ResultCode.*;
import springstudy.sbburinkle.global.result.ResultResponse;

import java.util.ArrayList;
import java.util.List;

import static springstudy.sbburinkle.global.result.ResultCode.CREAT_COMMENT_SUCCESS;
import static springstudy.sbburinkle.global.result.ResultCode.GET_ALL_COMMENT_SUCCESS;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment")
public class CommentController {
    private final CommentService commentservice;
    @PostMapping("/{postid}")
    public ResponseEntity<ResultResponse> createComment(
            @RequestBody CommentCreateRequest request,
            @PathVariable Long postid)
    {
        CommentInfo commentInfo=commentservice.CreateComment(request,postid);
        return ResponseEntity.ok(ResultResponse.of(CREAT_COMMENT_SUCCESS,commentInfo));
    }

    @GetMapping("/{postid}")
    public ResponseEntity<ResultResponse> GetPostComment(
            @PathVariable Long postid
    ){
        List<CommentInfo> postcommentInfoList=new ArrayList<>();
        postcommentInfoList=commentservice.GetPostCommentList(postid);
        return ResponseEntity.ok(ResultResponse.of(GET_ALL_COMMENT_SUCCESS,postcommentInfoList));

    }

    @GetMapping("/{userid}")
    public ResponseEntity<ResultResponse> GetUserComment(
            @PathVariable Long userid
    ){
        List<CommentInfo> usercommentInfoList=new ArrayList<>();
        usercommentInfoList=commentservice.GetUserCommentList(userid);
        return ResponseEntity.ok(ResultResponse.of(GET_ALL_COMMENT_SUCCESS,usercommentInfoList));
    }

}
