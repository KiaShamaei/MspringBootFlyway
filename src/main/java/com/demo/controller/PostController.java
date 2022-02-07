package com.demo.controller;


import com.demo.model.Post;
import com.demo.model.User;
import com.demo.repo.PostRepo;
import com.demo.request.PostRequest;
import com.demo.response.PostResponse;
import com.demo.service.PostService;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
public class PostController {
    private final PostRepo postRepo ;
    private final UserService userService;
    private final PostService postService;

    public PostController(PostRepo postRepo, UserService userService, PostService postService) {
        this.postRepo = postRepo;
        this.userService = userService;
        this.postService = postService;
    }

    @RequestMapping(value = "/addPost" , method = RequestMethod.POST)
    public Post addEditPost (@RequestBody PostRequest postResponse){
        Post post=new Post();
        post.setContent(postResponse.getContent());
        post.setTitle(postResponse.getTitle());
        Optional<User> user =userService.findById(postResponse.getUserId());
        post.setUser(user.get());
      return   postRepo.save(post);

    }
    @RequestMapping(value = "/getAllPost" , method = RequestMethod.GET)
    public List<PostResponse>  getAll (){
         return  postService.findAll();
    }

}
