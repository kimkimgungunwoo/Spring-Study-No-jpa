package springstudy.sbburinkle.domain.post.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springstudy.sbburinkle.domain.comment.dto.CommentCreateRequest;
import springstudy.sbburinkle.domain.comment.dto.CommentInfo;
import springstudy.sbburinkle.domain.post.dto.PostCreateRequest;
import springstudy.sbburinkle.domain.post.dto.PostInfo;
import springstudy.sbburinkle.domain.post.entity.Post;
import springstudy.sbburinkle.domain.post.service.PostService;
import springstudy.sbburinkle.global.result.ResultCode;
import springstudy.sbburinkle.global.result.ResultCode.*;
import springstudy.sbburinkle.global.result.ResultResponse;

import java.util.ArrayList;
import java.util.List;

import static springstudy.sbburinkle.global.result.ResultCode.*;

@RequiredArgsConstructor
@RequestMapping("/api/post")
@RestController
public class PostController {
    private final PostService postService;

    @GetMapping
    public ResponseEntity<ResultResponse> GetAllPost(){
        List<PostInfo> postInfoList=new ArrayList<>();
        postInfoList=postService.GetAllPost();
        return ResponseEntity.ok(ResultResponse.of(GET_ALL_POST_SUCCESS,postInfoList));
    }

    @PostMapping
    public ResponseEntity<ResultResponse> CreatePost(
            @RequestBody PostCreateRequest request,
            @SessionAttribute(name="LoginUser",required = true) Long userId
            )
    {
        PostInfo postInfo=postService.CreatePost(request,userId);
        return ResponseEntity.ok(ResultResponse.of(CREATE_POST_SUCCESS,postInfo));
    }

    @GetMapping("/{postid}")
    public ResponseEntity<ResultResponse> GetPost(
            @PathVariable Long postid){
        PostInfo postInfo=postService.GetPost(postid);
        return ResponseEntity.ok(ResultResponse.of(GET_POST_SUCCESS,postInfo));
    }

    @GetMapping("/user")
    public ResponseEntity<ResultResponse> GetUserPost(
            @PathVariable Long userid,
            @SessionAttribute(name="LoginUser",required = true) Long userId
            )
            {
        List<PostInfo> postInfoList=new ArrayList<>();
        postInfoList=postService.GetAllUserPost(userid);
        return ResponseEntity.ok(ResultResponse.of(GET_ALL_POST_SUCCESS,postInfoList));
    }






}
