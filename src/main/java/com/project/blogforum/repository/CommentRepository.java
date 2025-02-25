package com.project.blogforum.repository;
import com.project.blogforum.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    /**
     * FIND ONE COMMENT BY ID
     */
    @Query(value = "select c from Comment c where c.id=?1")
    Comment findOneCommentById(Long id);
    /**
     * FIND ALL COMMENTS BY POST ID
     */
    @Query(value = "select c from Comment c where c.postId=?1")
    List<Comment> findAllCommentsFromPostById(Long id);

    /**
     * UPDATE REVIEW BY ID
     */
    @Modifying
    @Query(value = "UPDATE Comment c SET c.review = ?1 WHERE c.id = ?2")
    void updateReviewById(String review, Long id);


    /**
     * DELETE ONE COMMENT
     */
    @Modifying
    @Query(value = "DELETE FROM Comment c WHERE c.id = ?1")
    void delete(Long id);

}
