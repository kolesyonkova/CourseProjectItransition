package com.itransition.CourseProject.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "post")
public class Post {
    public Post(String title, String anons, String fullText) {
        this.title = title;
        this.anons = anons;
        this.fullText = fullText;
    }

    public Post() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title,anons,fullText;
    private int views;

}
 