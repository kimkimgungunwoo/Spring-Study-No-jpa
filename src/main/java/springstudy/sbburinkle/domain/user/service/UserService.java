package springstudy.sbburinkle.domain.user.service;

import org.springframework.stereotype.Service;
import springstudy.sbburinkle.domain.comment.dto.CommentInfo;
import springstudy.sbburinkle.domain.comment.service.CommentService;
import springstudy.sbburinkle.domain.post.dto.PostInfo;
import springstudy.sbburinkle.domain.post.service.PostService;
import springstudy.sbburinkle.domain.user.dto.*;
import springstudy.sbburinkle.domain.user.entity.User;

import javax.servlet.http.HttpSession;
import java.security.PublicKey;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class UserService {
    private PostService postService;
    private CommentService commentService;
    private HttpSession session;
    List<User> userList=new ArrayList<>();
    Long id=0L;

    public User CreateReqeustToUserEntity(UserCreateRequest request){
        User user=User.builder()
                .id(id++)
                .email(request.getEmail())
                .nickname(request.getNickname())
                .location(request.getLocation())
                .password(request.getPassword())
                .build();
        user.setCreatedAt(LocalDateTime.now());
        return user;
    }

    public UserInfo MapUserEntityToUserInfo(User user){
        UserInfo userInfo =UserInfo.builder()
                .id(user.getId())
                .nickname(user.getNickname())
                .email(user.getEmail())
                .Location(user.getLocation())
                .createdAt(user.getCreatedAt())
                .build();

        return userInfo;
    }



    public UserInfo CreateUser(UserCreateRequest request){
        User user=CreateReqeustToUserEntity(request);
        userList.add(user);
        return MapUserEntityToUserInfo(user);
    }

    public UserInfo GetUser(Long userid){
        Optional<User> optionalUser =userList.stream().
                filter(User->User.getId().equals(userid)).findFirst();
        User user=optionalUser.get();
        return MapUserEntityToUserInfo(user);
    }

    public List<UserInfo> GetUserList(){
        List<UserInfo> userInfoList=new ArrayList<>();
        for(int i=0;i< userList.size();i++){
            userInfoList.add(MapUserEntityToUserInfo(userList.get(i)));
        }
        return userInfoList;
    }

    public User Login(UserLoginRequestInfo request){
        Optional<User> optionalUser=userList.stream().
                filter(User->User.getEmail().equals(request.getEmail())).findFirst();
        if (optionalUser.isEmpty()){
            return null;
        }

        User finduser=optionalUser.get();
        if(!finduser.getPassword().equals(request.getPassword())){
            return null;
        }

        return finduser;
    }

    public UserMyPage GetUserPage(Long userId){
        List<PostInfo> postInfoList=postService.GetAllUserPost(userId);
        List<CommentInfo> CommentInfoList=commentService.GetUserCommentList(userId);
        UserInfo findUser=GetUser(userId);
        return UserMyPage.builder()
                .email(findUser.getEmail())
                .nickname(findUser.getNickname())
                .UserPostList(postInfoList)
                .UserCommentList(CommentInfoList)
                .build();
    }




}
