package springstudy.sbburinkle.domain.user.service;

import org.springframework.stereotype.Service;
import springstudy.sbburinkle.domain.user.dto.UserCreateRequest;
import springstudy.sbburinkle.domain.user.dto.UserInfo;
import springstudy.sbburinkle.domain.user.entity.User;

import java.security.PublicKey;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
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
}
