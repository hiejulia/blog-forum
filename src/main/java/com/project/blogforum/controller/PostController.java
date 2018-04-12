package com.project.blogforum.controller;
import com.project.blogforum.domain.Comment;
import com.project.blogforum.domain.Post;
import com.project.blogforum.domain.Tag;
import com.project.blogforum.dto.CommentDTO;
import com.project.blogforum.dto.PostDTO;
import com.project.blogforum.dto.TagDTO;
import com.project.blogforum.service.impl.CommentService;
import com.project.blogforum.service.impl.PostService;
import com.project.blogforum.service.impl.TagService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@Api(value = "Posts", description = "Post API")
@RestController
@RequestMapping("/v1/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private TagService tagService;
//    /**
//     * GET ALL POSTS
//     */
//    @ApiOperation(value = "Get all posts",notes = "This can be done by the users",position = 1,responseContainer="List")
//    @ApiResponse(code = 200, message = "Ok")
//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity<Page<Post>> getAllPosts(Pageable pageable){
//        return new ResponseEntity<>(postService.findAll(pageable),HttpStatus.OK);
//    }
//
//    /**
//     * GET ONE POST BY ID
//     */
//    @ApiOperation(value = "Get post by id", notes = "This can be done by all users.", position = 2, response = Post.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Ok"),
//            @ApiResponse(code = 400, message = "Post not found")
//    })
//    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
//    public ResponseEntity<?> getOnePostById(@ApiParam(value = "Post id",required = true) @PathVariable Long id){
//        // check if the post exists
//        if(postService.findOnePostById(id) == null) {
//            return new ResponseEntity<String>("Post "+id +" does not exist.",HttpStatus.NOT_FOUND);
//        }else {
//            return new ResponseEntity<>(postService.findOnePostById(id),HttpStatus.OK);
//        }
//
//    }
//
//    /**
//     * ADD NEW POST
//     */
    @ApiOperation(value = "Add new post", notes = "By authenticated users only.", position = 3)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created")
    })
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Post> addNewPost(
            @ApiParam(value = "Created post object", required = true) @Valid @RequestBody PostDTO postDTO) {
        Post post = new Post();
        post.setTitle(postDTO.getTitle());
        post.setSubtitle(postDTO.getSubtitle());
        post.setContent(postDTO.getContent());
        post.setDate(LocalDate.now().toString());
        post.setAuthor(postDTO.getAuthor());


        return new ResponseEntity<>(postService.save(post),HttpStatus.CREATED);
    }

//    /**
//     * DELETE ONE POST BY ID
//     */
//
//    @ApiOperation(value = "Delete post by id", notes = "By authenticated users only.", position = 4)
//    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
//    public ResponseEntity<?> deletePostById(
//            @ApiParam(value = "Post id", required = true) @PathVariable Long id
//    ){
////        if(postService.exists(id)){
//            postService.deletePostById(id);
//            return new ResponseEntity<>(id, HttpStatus.OK);
////        }else {
////            return new ResponseEntity<String>("Post "+id +" does not exist.",HttpStatus.NOT_FOUND);
////
////        }
//
//
//    }
//
//    /**
//     * UPDATE ONE POST BY POST ID
//     */
////
////    @ApiOperation(value = "Update post by id", notes = "By authenticated users only.", position = 5)
////    @RequestMapping(method = RequestMethod.PUT)
////    public ResponseEntity<?> updateContentById(
////            @ApiParam(value = "Updated post object", required = true) @Valid @RequestBody PostDTO postDTO) {
////        postService.updateContentById(postDTO);
////        return new ResponseEntity<>(postDTO.getId(), HttpStatus.OK);
////    }
//
//
//    /**
//     * DELETE ALL POSTS
//     */
//    @ApiOperation(value = "Delete all posts", notes = "By authenticated users only.", position = 6)
//    @RequestMapping(value = "/clear",method = RequestMethod.DELETE)
//    public ResponseEntity<?> deleteAllPosts(){
//        postService.deleteAllPosts();
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    /**
//     * ADD NEW COMMENT TO ONE POST ID
//     */
//
//    @RequestMapping(value = "/{id}/comments",method = RequestMethod.POST)
//    public ResponseEntity<?> addNewCommentToPost(
//            @ApiParam(value = "Post id", required = true) @PathVariable Long id,
//            @ApiParam(value = "Created comment object", required = true) @RequestBody CommentDTO commentDTO
//    ){
//        Comment comment = new Comment();
//        comment.setAuthor(commentDTO.getAuthor());
//        comment.setReview(commentDTO.getReview());
//        comment.setDate(LocalDate.now().toString());
//
//        commentService.save(comment);
//        commentService.addNewCommentToPost(id, comment);
//        return new ResponseEntity<>(id,HttpStatus.OK);
//
//    }
//    /**
//     * ADD NEW TAG TO ONE POST BY ID
//     */
//
//    @RequestMapping(value = "/{id}/tags",method = RequestMethod.POST)
//    public ResponseEntity<?> addNewTagToPost(
//            @ApiParam(value = "Post id", required = true) @PathVariable Long id,
//            @ApiParam(value = "Created tag object", required = true) @RequestBody TagDTO tagDTO
//    ){
//        Tag tag = new Tag();
//        tag.setName(tagDTO.getName());
//        tagService.save(tag);
//        tagService.addNewTagToPost(id,tag);
//        return new ResponseEntity<>(id,HttpStatus.OK);
//
//    }
//
//
//    /**
//     * GET ALL COMMENTS OF ONE POST
//     */
//
//    @ApiOperation(value = "Get all comments from post by id", notes = "By authenticated users only.", position = 8)
//    @RequestMapping(value = "/{id}/comments", method = RequestMethod.GET)
//    public ResponseEntity<?> getAllCommentsFromPost(
//            @ApiParam(value = "Post id", required = true) @PathVariable Long id) {
//        return new ResponseEntity<>(commentService.findAllCommentsFromPostById(id), HttpStatus.OK);
//    }
//    /**
//     * GET ALL TAGS WITH POST ID
//     */
//    @RequestMapping(value = "/{id}/tags",method = RequestMethod.GET)
//    public ResponseEntity<?> getTagsByPostId(
//            @PathVariable Long id
//    ){
//        return new ResponseEntity<>(tagService.findTagsByPostId(id),HttpStatus.OK);
//    }
}
