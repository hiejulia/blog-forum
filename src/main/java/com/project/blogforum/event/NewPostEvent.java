package com.project.blogforum.event;


import com.project.blogforum.domain.Post;
import com.project.blogforum.dto.PostDTO;
import org.springframework.context.ApplicationEvent;



public class NewPostEvent extends ApplicationEvent {

    private static final long serialVersionUID = 889202626288526113L;

    private Post post;

    private PostDTO postDTO;

    public NewPostEvent(Object source,PostDTO post) {
        super(source);
        this.postDTO = postDTO;
    }

    public PostDTO getPost() {
        return postDTO;
    }
}