package com.lidong.blog.controller;

import com.lidong.blog.domain.es.EsBlog;
import com.lidong.blog.repository.es.EsBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private EsBlogRepository esBlogRepository;
    @GetMapping(value = "/hello")
    public String hello1(){
        return "hello";
    }
    @GetMapping(value = "in")
    public long ins(){
        EsBlog esBlog = new EsBlog("111","222111","dab222111");
        EsBlog esBlog1 = new EsBlog("11","222111","dab222111");

        esBlogRepository.save(esBlog);
        esBlogRepository.save(esBlog1);

        long s = esBlogRepository.count();
        return s;
    }
    @GetMapping(value = "find")
    public String find(){
        Pageable pageable = new PageRequest(0,20);

        Page page = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining("111","22","22",pageable);
        System.out.println("------------------------------ ");
        for(Object esBlog : page.getContent()){
            System.out.println(esBlog.toString());
        }
        System.out.println("------------------------------ ");
        return "success";
    }
    @PostMapping(value="/lo")
    public void fa(){
        System.out.println("helloworld");
    }
}
