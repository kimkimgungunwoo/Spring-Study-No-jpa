package springstudy.sbburinkle.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerRequest;
import springstudy.sbburinkle.domain.user.dto.UserCreateRequest;
import springstudy.sbburinkle.domain.user.dto.UserInfo;
import springstudy.sbburinkle.domain.user.dto.UserLoginRequestInfo;
import springstudy.sbburinkle.domain.user.entity.User;
import springstudy.sbburinkle.domain.user.service.UserService;
import springstudy.sbburinkle.global.result.ResultCode;
import springstudy.sbburinkle.global.result.ResultResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

import static springstudy.sbburinkle.global.result.ResultCode.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
@SessionAttributes("userid")

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

    @PostMapping("/login")
    public ResponseEntity<ResultResponse> Login(
            @RequestBody  UserLoginRequestInfo info, HttpServletRequest httprequest){
        User LoginUser=userService.Login(info);
        httprequest.getSession().invalidate();
        HttpSession session = httprequest.getSession(true);
        session.setAttribute("userid",LoginUser.getId());
        session.setMaxInactiveInterval(1800);
        return ResponseEntity.ok(ResultResponse.of(LOGIN_SUCCESS,info));

    }

}
