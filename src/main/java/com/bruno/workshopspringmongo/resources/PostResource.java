package com.bruno.workshopspringmongo.resources;

import com.bruno.workshopspringmongo.dto.PostDTO;
import com.bruno.workshopspringmongo.resources.util.URL;
import com.bruno.workshopspringmongo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        return ResponseEntity.ok(list);
    }

    @RequestMapping(value = "/searchintitle", method = RequestMethod.GET)
    public ResponseEntity<List<PostDTO>> findPostsContainingSomeText(@RequestParam(value = "text", defaultValue = "") String text){
        text = URL.decodeParam(text);
        List<PostDTO> list = postService.findPostsContainingSomeText(text);
        return ResponseEntity.ok(list);
    }

    @RequestMapping(value = "/fullsearch", method = RequestMethod.GET)
    public ResponseEntity<List<PostDTO>> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "mindate", defaultValue = "") String minDate,
            @RequestParam(value = "maxdate", defaultValue = "") String maxDate
    ) {
        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());
        List<PostDTO> list = postService.fullSearch(text, min, max);
        return ResponseEntity.ok(list);
    }
}
