package com.project.blogforum.service.essearch;


import com.project.blogforum.dto.PostDTO;
import com.project.blogforum.search.ESPostRepository;
import com.project.blogforum.util.PageableUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ESPostService {

    @Autowired
    private ESPostRepository esPostRepository;


    public Page<PostDTO> getByNameLike(String name,int page, int size, String... sortAttributes) {
        Pageable pageable = PageableUtils.createPageable(page, size, sortAttributes);
        Page<PostDTO> pageResult = (Page<PostDTO>) esPostRepository.findByTitleContaining(name, pageable);
        return pageResult;
    }
}
