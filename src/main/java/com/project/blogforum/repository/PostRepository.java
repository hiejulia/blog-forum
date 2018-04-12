package com.project.blogforum.repository;

import com.project.blogforum.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostRepository extends JpaRepository<Post, Long>{
//    /**
//
//     * FIND ONE POST BY ID
//     */
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


    @Query("select count(p) from Post p")
    int countBlogposts();

    @Query("select count(e) FROM Blogpost e where e.category=:category")
    int countBlogpostsByCategory(@Param("category")String category);


    @Query("select e FROM Blogpost e where e.category=:category")
    List<Post> getBlogpostsByCategory(@Param("category")String category);

}
