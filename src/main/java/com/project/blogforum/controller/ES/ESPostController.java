package com.project.blogforum.controller.ES;

import com.project.blogforum.domain.Comment;
import com.project.blogforum.domain.Post;
import com.project.blogforum.domain.Tag;
import com.project.blogforum.dto.CommentDTO;
import com.project.blogforum.dto.PostDTO;
import com.project.blogforum.dto.TagDTO;
import com.project.blogforum.search.ESPostRepository;
import com.project.blogforum.search.ESPostService;
import com.project.blogforum.service.impl.CommentService;
import com.project.blogforum.service.impl.PostService;
import com.project.blogforum.service.impl.TagService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
//import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@Api(value = "Posts ES", description = "Post API ES")
@RestController
@RequestMapping("/v1/api/es/posts")
public class ESPostController {
//    @Autowired
//    private ElasticsearchOperations es;


    @Autowired
    ElasticsearchOperations operations;


    @Autowired
    private ESPostRepository esPostService;
//
//
//
//
//    @RequestMapping(method = RequestMethod.GET,value = "/test")
//    public ResponseEntity<Page<Post>> getAllPosts(Pageable pageable){
//        esPostService.save(new Post( "Elasticsearch Basics", "Rambabu Posa", "23.01.2017","A","B"));
//        esPostService.save(new Post( "Apache Lucene Basics", "Rambabu Posa", "13-MAR-2017","A","B"));
//        esPostService.save(new Post( "Apache Solr Basics", "Rambabu Posa", "21-MAR-2017","A","B"));
//
//        //fuzzey search
//        Page<Post> books = esPostService.findByAuthor("Rambabu", new PageRequest(0, 10));
//        return new ResponseEntity<Page<Post>>(books, HttpStatus.OK);
//    }
//


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
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addNewPost(
            @ApiParam(value = "Created post object", required = true) @Valid @RequestBody Post postDTO) {

        esPostService.save(postDTO);
        return new ResponseEntity<>(postDTO.getTitle(),HttpStatus.CREATED);
    }
//    @ApiOperation(value = "Delete post by id", notes = "By authenticated users only.", position = 4)
//    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
//    public ResponseEntity<?> deletePostById(
//            @ApiParam(value = "Post id", required = true) @PathVariable Long id
//    ){
////        if(postService.exists(id)){
//        postService.deletePostById(id);
//        return new ResponseEntity<>(id, HttpStatus.OK);
////        }else {
////            return new ResponseEntity<String>("Post "+id +" does not exist.",HttpStatus.NOT_FOUND);
////
////        }
//
//
//    }

    /**
     * UPDATE ONE POST BY POST ID
     */

//    @ApiOperation(value = "Update post by id", notes = "By authenticated users only.", position = 5)
//    @RequestMapping(method = RequestMethod.PUT)
//    public ResponseEntity<?> updateContentById(
//            @ApiParam(value = "Updated post object", required = true) @Valid @RequestBody PostDTO postDTO) {
//        postService.updateContentById(postDTO);
//        return new ResponseEntity<>(postDTO.getId(), HttpStatus.OK);
//    }
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





}
