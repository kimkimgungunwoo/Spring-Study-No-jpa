package springstudy.sbburinkle.domain.comment.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springstudy.sbburinkle.domain.comment.dto.CommentCreateRequest;
import springstudy.sbburinkle.domain.comment.service.CommentService;
import springstudy.sbburinkle.global.result.ResultResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment")
public class CommentController {
    private final CommentService commentservice;

    @PostMapping()
    public ResponseEntity<ResultResponse> createComment(
            @RequestBody CommentCreateRequest request,
            @PathVariable Long postid)
            {

    }

    @GetMapping("{/postid}")
    public ResponseEntity<ResultResponse> GetPostComment(
            @PathVariable Long postid
    ){


    }
}
