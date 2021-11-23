package com.itransition.CourseProject.repo;

import com.itransition.CourseProject.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}
