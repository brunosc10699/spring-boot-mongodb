package com.bruno.workshopspringmongo.services;

import com.bruno.workshopspringmongo.domain.Post;
import com.bruno.workshopspringmongo.dto.PostDTO;
import com.bruno.workshopspringmongo.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public PostDTO findById(String id){
        PostDTO postDTO = new PostDTO(postRepository.findById(id).orElse(null));
        return postDTO;
    }

    public List<PostDTO> findByTitleStringIgnoreCase(String text){
        List<PostDTO> list = postRepository.findByTitleContainingIgnoreCase(text)
                .stream()
                .map(PostDTO::new)
                .collect(Collectors.toList());
        return list;
    }

    public List<PostDTO> findPostsContainingSomeText(String text){
        List<PostDTO> list = postRepository.findPostsContainingSomeText(text)
                .stream()
                .map(PostDTO::new)
                .collect(Collectors.toList());
        return list;
    }

    public List<PostDTO> fullSearch(String text, Date minDate, Date maxDate){
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        List<PostDTO> list = postRepository.fullseartch(text, minDate, maxDate)
                .stream()
                .map(PostDTO::new)
                .collect(Collectors.toList());
        return list;
    }
}
