package com.project.blogforum.repository;


import com.project.blogforum.domain.Comment;
import com.project.blogforum.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository  extends JpaRepository<Tag, Integer> {
    /**
     * FIND ONE TAG BY ID
     */
    @Query(value = "select t from Tag t where t.id=?1")
    Tag findOneTagById(Long id);

    /**
     * UPDATE ONE TAG BY ID
     */
    @Modifying
    @Query(value = "UPDATE Tag t SET t.name = ?1 WHERE t.id = ?2")
    void updateTagNameById(String name, Long id);

    /**
     * GET ALL TAG WITH POST ID
     */

    @Query(value = "select t from Tag t where t.postId=?1")
    List<Tag> getTagsByPostId(Long id);


    /**
     * DELETE ONE TAG
     */
    @Modifying
    @Query(value = "DELETE FROM Tag t WHERE t.id = ?1")
    void delete(Long id);


    /**
     * FIND ALL TAGS BY POST ID
     */

    @Query(value = "select t from Tag t where t.postId=?1")
    List<Tag> findAllTagsByPostId(Long id);
}
