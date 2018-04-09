package com.project.blogforum.service.impl;

import com.project.blogforum.domain.Comment;
import com.project.blogforum.domain.Tag;
import com.project.blogforum.dto.CommentDTO;
import com.project.blogforum.dto.TagDTO;
import com.project.blogforum.repository.CommentRepository;
import com.project.blogforum.repository.TagRepository;
import com.project.blogforum.service.serviceItf.TagServiceItf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TagService implements TagServiceItf {
    @Autowired
    private TagRepository tagRepository;
    /**
     * FIND ONE TAG BY ID
     */
    @Override
    public Tag findOneTagById(Long id) {
        return tagRepository.findOneTagById(id);
    }

    /**
     * FIND ALL TAGS
     */
    @Override
    public List<Tag> findAllTags() {
        return tagRepository.findAll();
    }
    /**
     * GET ALL TAG BY POST ID
     */
    @Override
    public List<Tag> findTagsByPostId(Long id){
        return tagRepository.findAllTagsByPostId(id);

    }

//    /**
//     * FIND ALL TAGS BY POST ID
//     */
//    public List<Tag> findAllTagsFromPostById(Long id) {
//        return tagRepository.findAllTagsByPostId(id);
//    }
    /**
     * ADD NEW TAG
     */
    @Override
    public void save(Tag tag) {
        tagRepository.save(tag);
    }

    /**
     * delete one tag by id
     */
    @Override
    public void deleteTagById(Long id) {
        tagRepository.delete(id);
    }
    /**
     * add new tag to post
     */
    @Override
    public void addNewTagToPost(Long id, Tag tag) {
        tag.setPostId(id);
        tagRepository.save(tag);
    }
    /**
     * update tag name by id
     */
    @Override
    public void updateTagNameById(TagDTO tagDTO) {
        String name = tagDTO.getName();
        Long id = tagDTO.getId();
        tagRepository.updateTagNameById(name,id);
    }
}


