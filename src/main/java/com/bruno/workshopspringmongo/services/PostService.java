package com.bruno.workshopspringmongo.services;

import com.bruno.workshopspringmongo.dto.PostDTO;
import com.bruno.workshopspringmongo.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public PostDTO findById(String id){
        PostDTO postDTO = new PostDTO(postRepository.findById(id).orElse(null));
        return postDTO;
    }
}
