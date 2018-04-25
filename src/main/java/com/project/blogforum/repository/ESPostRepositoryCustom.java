package com.project.blogforum.repository;




import com.project.blogforum.dto.PostDTO;

import java.util.List;

public interface ESPostRepositoryCustom {
    // title
    List<PostDTO> findByTitleContaining(String title);

}