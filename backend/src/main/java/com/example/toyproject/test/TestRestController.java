package com.example.toyproject.test;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.util.*;

@RestController
public class TestRestController {

    @PostMapping("/image1")
    public String test(@RequestParam("name") String name,
                     @RequestParam("content") String content,
                       @RequestParam("image")List<MultipartFile> files){

        String str = name+content;
        System.out.println(str);

        for(int i=0; i<files.size(); i++){
            System.out.println(files.get(i).getOriginalFilename());
        }
        return str;
    }
}
