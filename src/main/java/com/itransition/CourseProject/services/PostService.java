package com.itransition.CourseProject.services;

import com.itransition.CourseProject.models.Post;
import com.itransition.CourseProject.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Iterable<Post> findAllPosts() {
        return postRepository.findAll();
    }

    public List<Post> findAllPostsO() {
        return postRepository.findAll();
    }

    public void addPostTODB(Post post) {
        postRepository.save(post);
    }

    public boolean existById(long id) {
        return postRepository.existsById(id);
    }

    public Post findById(long id) {
        return postRepository.findById(id).orElseThrow();
    }

    public void removeFromDB(Post post) {
        postRepository.delete(post);
    }
}
