package springstudy.sbburinkle.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springstudy.sbburinkle.domain.user.dto.UserCreateRequest;
import springstudy.sbburinkle.domain.user.dto.UserInfo;
import springstudy.sbburinkle.domain.user.service.UserService;
import springstudy.sbburinkle.global.result.ResultCode;
import springstudy.sbburinkle.global.result.ResultCode.*;
import springstudy.sbburinkle.global.result.ResultResponse;

import java.util.List;

import static springstudy.sbburinkle.global.result.ResultCode.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserContoller {
    UserService userService=new UserService();

    @PostMapping()
    public ResponseEntity<ResultResponse> CreateUser(
            @RequestBody UserCreateRequest request
            ) {
        UserInfo userInfo = userService.CreateUser(request);
        return ResponseEntity.ok(ResultResponse.of(CREATE_USER_SUCCESS,userInfo));
    }

    @GetMapping("/{userid}")
    public  ResponseEntity<ResultResponse> GetUser(
            @PathVariable Long userid){
        UserInfo userInfo = userService.GetUser(userid);
        return ResponseEntity.ok(ResultResponse.of(GET_USER_SUCCESS,userInfo));
    }

    @GetMapping("/list")
    public ResponseEntity<ResultResponse> GetAllUser(){
        List<UserInfo> userInfoList=userService.GetUserList();
        return ResponseEntity.ok(ResultResponse.of(GET_ALL_POST_SUCCESS,userInfoList));

    }

}
