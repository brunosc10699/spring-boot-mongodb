package com.bruno.workshopspringmongo.resources;

import com.bruno.workshopspringmongo.dto.PostDTO;
import com.bruno.workshopspringmongo.resources.util.URL;
import com.bruno.workshopspringmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<PostDTO> findById(@PathVariable String id){
        return ResponseEntity.ok(postService.findById(id));
    }

    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<PostDTO>> findByTitleContainingIgnoreCase(@RequestParam(value = "text", defaultValue = "") String text){
        text = URL.decodeParam(text);
        List<PostDTO> list = postService.findByTitleStringIgnoreCase(text);
        return ResponseEntity.ok().body(list);
    }
}
