package com.example.esercizio1902.controller;

import it.epicode.w7d1t.exception.BadRequestException;
import it.epicode.w7d1t.model.BlogPost;
import it.epicode.w7d1t.model.BlogPostRequest;
import it.epicode.w7d1t.service.BlogPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogPostController {

    @Autowired
    private BlogPostService blogPostService;

    @GetMapping("/post")
    public Page<BlogPost> getAll(Pageable pageable){

        return blogPostService.cercaTuttiIBlogPosts(pageable);
    }
    @GetMapping("/post/{id}")
    public BlogPost getBlogPostById(@PathVariable int id){
        return blogPostService.cercaPostPerId(id);

    }
    @PostMapping("/post")
    public BlogPost saveBlogPost(@RequestBody @Validated BlogPostRequest blogPostRequest, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().toString());
        }

        return blogPostService.salvaBlogPost(blogPostRequest);
    }
    @PutMapping("/post/{id}")
    public BlogPost updateBlogPost(@PathVariable int id, @RequestBody @Validated BlogPostRequest blogPostRequest, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new BadRequestException(bindingResult.getAllErrors().toString());
        }

        return blogPostService.aggiornaBlogPost(id, blogPostRequest);
    }

    @DeleteMapping("/post/{id}")
    public void deleteBlogPost(@PathVariable int id){
        blogPostService.cancellaBlogPost(id);
    }
}
