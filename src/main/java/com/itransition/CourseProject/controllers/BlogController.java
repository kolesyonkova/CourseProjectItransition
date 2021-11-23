package com.itransition.CourseProject.controllers;

import com.itransition.CourseProject.models.Post;
import com.itransition.CourseProject.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/blog")
    public String blogMain(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "blog-main";
    }

    @GetMapping("/blog/add")
    public String blogAdd(Model model) {
        System.out.println("ya tyt!");
        return "blog-add";
    }

    @PostMapping("/blog/add")
    public String blogAddToDB(@RequestParam String title, @RequestParam String anons, @RequestParam String fullText, Model model) {
        System.out.println("ya zdesya!");
        Post post = new Post(title, anons, fullText);
        System.out.println(post.toString());
        System.out.println(postRepository);
        postRepository.save(post);
        return "redirect:/blog";
    }
}
