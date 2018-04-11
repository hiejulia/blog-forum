package com.project.blogforum.domain.projection;



//import org.springframework.data.rest.core.config.Projection;

//@Projection(name = "min", types = {Song.class})
public interface PostProjection {
    String getTitle();

    String getAuthor();

    String getAlbum();
}