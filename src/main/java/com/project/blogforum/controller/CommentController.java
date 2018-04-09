package com.project.blogforum.controller;
import com.project.blogforum.config.exception.EntityNotFoundException;
import com.project.blogforum.dto.CommentDTO;
import com.project.blogforum.service.impl.CommentService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * COMMENT CONTROLLER
 *
 */
@Api(value = "Comments", description = "Comment API")
@RestController
@RequestMapping("/v1/api/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;


    /**
     * GET ALL COMMENTS
     */

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllComments(){
        return new ResponseEntity<>(commentService.findAll(),HttpStatus.OK);
    }
    /**
     * GET ONE COMMENT BY ID
     */

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getOneCommentById(
            @PathVariable Long commentId
    )throws EntityNotFoundException {
        return new ResponseEntity<>(commentService.findOneCommentById(commentId),HttpStatus.OK);
    }

    /**
     * UPDATE REVIEW BY ID
     */

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateReviewById(
            @RequestBody CommentDTO commentDTO
            ){
        commentService.updateReviewById(commentDTO);
        return new ResponseEntity<>(commentDTO.getId(),HttpStatus.OK);

    }


    /**
     * DELETE ONE COMMENT BY ID
     */

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCommentById(@PathVariable Long commentId){
        commentService.deleteCommentById(commentId);
        return new ResponseEntity<>(commentId, HttpStatus.OK);

    }


}
