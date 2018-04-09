package com.project.blogforum.service.serviceItf;

import com.project.blogforum.domain.Tag;
import com.project.blogforum.dto.TagDTO;

import java.util.List;

public interface TagServiceItf {
    Tag findOneTagById(Long id);
    List<Tag> findAllTags();
    List<Tag> findTagsByPostId(Long id);
    void save(Tag tag);
    void deleteTagById(Long id);
    void addNewTagToPost( Long id,Tag tag);
    void updateTagNameById(TagDTO tagDTO);


}
