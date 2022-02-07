package com.demo.service;


import com.demo.model.Post;
import com.demo.repo.PostRepo;
import com.demo.response.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {
    private final PostRepo postRepo ;

    public PostService(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    public List<PostResponse> findAll (){
        List<Post> posts= postRepo.findAll();
        List<PostResponse> postResponseList=new ArrayList<>();
        for(Post post:posts){
            PostResponse response=new PostResponse();
            response.setContent(post.getContent());
            response.setTitle(post.getTitle());
            response.setUserId(post.getUser().getId());
            postResponseList.add(response);
        }
        return postResponseList;
    }
}
