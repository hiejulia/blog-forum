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

import java.time.Instant;
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

    // Count number of post
    @Query("select count(p) from Post p")
    int countBlogposts();


    @Query("select count(p) FROM Post p where p.category=:category")
    int countBlogpostsByCategory(@Param("category")String category);


    @Query("select p FROM Post p where p.category=:category")
    List<Post> getBlogpostsByCategory(@Param("category")String category);


    // find created at post between date
    @Query(value = ""
            + "SELECT p.author,p.content,p.subtitle,p.title "
            + "FROM Post AS p "
            + "WHERE p.createdAt BETWEEN :startDate AND :endDate "
            + "ORDER BY p.createdAt "
            + "")
    List<Post> findByInsertDateBetween(@Param("startDate") Instant startDate, @Param("endDate") Instant endDate);

}
