package com.project.blogforum.event;


import com.project.blogforum.domain.Post;
import org.springframework.context.ApplicationEvent;



public class NewPostEvent extends ApplicationEvent {

    private static final long serialVersionUID = 889202626288526113L;

    private Post post;

    public NewPostEvent(Object source,Post post) {
        super(source);
        this.post = post;
    }

    public Post getPost() {
        return post;
    }
}