package com.itransition.CourseProject.controllers;

import com.itransition.CourseProject.models.Post;
import com.itransition.CourseProject.models.User;
import com.itransition.CourseProject.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private PostService postService;

    @GetMapping()
    public String blogMain(Model model) {
        Iterable<Post> posts = postService.findAllPosts();
        model.addAttribute("posts", posts);
        return "blog-main";
    }

    @GetMapping("/add")
    public String blogAdd(Model model) {
        return "blog-add";
    }

    @PostMapping("/add")
    public String blogAddToDB(@AuthenticationPrincipal User user,
                              @RequestParam String title,
                              @RequestParam String anons,
                              @RequestParam String fullText,
                              Model model) {
        Post post = new Post(title, anons, fullText, user);
        postService.addPostTODB(post);
        return "redirect:/blog";
    }

    @GetMapping("/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model) {
        if (!postService.existById(id)) {
            return "redirect:/blog";
        }
        List<Post> res = postService.findAllPostsO();
        model.addAttribute("post", res);
        return "blog-details";
    }

    @GetMapping("/{id}/edit")
    public String blogEdit(@PathVariable(value = "id") long id, Model model) {
        if (!postService.existById(id)) {
            return "redirect:/blog";
        }
        List<Post> res = postService.findAllPostsO();
        model.addAttribute("post", res);
        return "blog-edit";
    }

    @PostMapping("/{id}/edit")
    public String blogPostUpdate(@PathVariable(value = "id") long id,
                                 @RequestParam String title,
                                 @RequestParam String anons,
                                 @RequestParam String fullText,
                                 Model model) {
        Post post = postService.findById(id);
        post.setTitle(title);
        post.setAnons(anons);
        post.setFullText(fullText);
        postService.addPostTODB(post);
        return "redirect:/blog";
    }

    @PostMapping("/{id}/remove")
    public String blogPostDelete(@PathVariable(value = "id") long id, Model model) {
        Post post = postService.findById(id);
        postService.removeFromDB(post);
        return "redirect:/blog";
    }
}
