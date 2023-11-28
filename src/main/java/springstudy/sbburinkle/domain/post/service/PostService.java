package springstudy.sbburinkle.domain.post.service;

import org.springframework.stereotype.Service;
import springstudy.sbburinkle.domain.post.dto.PostCreateRequest;
import springstudy.sbburinkle.domain.post.dto.PostInfo;
import springstudy.sbburinkle.domain.post.entity.Post;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private List<Post> postList = new ArrayList<>();
    Long a=0L;

    public Post CreateRequestToPostEntity(PostCreateRequest request,Long userId){
        Post post=Post.builder().
                title(request.getTitle())
                .content(request.getContent())
                .userid(userId)
                .build();
        post.setId(a++);
        post.setCreatedAt(LocalDateTime.now());
        post.setUpdatedAt(LocalDateTime.now());
        return post;
    }

    public PostInfo MapPostEntitiytoPostInfo(Post post){
        PostInfo postInfo=PostInfo.builder()
                .content(post.getContent())
                .userid(post.getUserid())
                .title(post.getTitle())
                .id(post.getId())
                .build();
        postInfo.setUpdatedAt(LocalDateTime.now());
        postInfo.setCreatedAt(LocalDateTime.now());
        return postInfo;
    }

    public PostInfo CreatePost(PostCreateRequest request,Long userId){
        Post post=CreateRequestToPostEntity(request,userId);
        postList.add(post);
        PostInfo postInfo=MapPostEntitiytoPostInfo(post);
        return postInfo;
    }

    public List<PostInfo> GetAllUserPost(Long userid){
        List<PostInfo> postInfoList=new ArrayList<>();
        for(int i=0;i<postList.size();i++){
            if(postList.get(i).getUserid().equals(userid)){
                postInfoList.add(MapPostEntitiytoPostInfo(postList.get(i)));
            }
        }
        return postInfoList;
    }

    public List<PostInfo> GetAllPost(){
        List<PostInfo> postInfoList =new ArrayList<>();
        for(int i=0;i<postList.size();i++){
            postInfoList.add(MapPostEntitiytoPostInfo(postList.get(i)));
        }
        return postInfoList;
    }

    public PostInfo GetPost(Long postid){
        Optional<Post> optionalPost=postList.stream()
                .filter(post -> post.getId().equals(postid))
                .findFirst();
        Post post=optionalPost.get();
        return MapPostEntitiytoPostInfo(post);

    }




}
