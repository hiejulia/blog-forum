package com.project.blogforum.repository;

import com.project.blogforum.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    /**
     * FIND ONE POST BY ID
     */
    @Query(value = "select p from Post p where p.id=?1")
    Post findOnePostById(Long id);
    // find all with pagination
    Page<Post> findAll(Pageable pageable);
//    Iterable<Post> findAll(Sort sort);

    /**
     * UPDATE CONTENT BY POST ID
     */
    @Modifying(clearAutomatically = true)
    @Query(value = "update Post p set p.content =?1 where p.id=?2")
    void updateContentById(String content, Long id);

    /**
     * DELETE ONE POST BY ID
     */
    @Modifying
    @Query(value = "delete from Post p where p.id=?1")
    void delete(Long id);

}
