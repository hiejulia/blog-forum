package com.project.blogforum.controller;

import com.project.blogforum.domain.Tag;
import com.project.blogforum.dto.TagDTO;
import com.project.blogforum.service.impl.TagService;
import com.project.blogforum.solr.SolrTagRepository;
import com.wordnik.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.log4j.Logger;

@RestController
@RequestMapping("/v1/api/tags")
@Api(value = "tags", description = "Tag API")
public class TagController {
    private Logger log = Logger.getLogger(TagController.class);

    @Autowired
    private TagService tagService;

//    @Autowired
//    private SolrTagRepository solrTagRepository;

    /**
     * GET ALL TAGS``
     */
//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity<?> getAllTags(){
//        return new ResponseEntity<>(tagService.findAllTags(), HttpStatus.OK);
//    }
//
//    @RequestMapping(method = RequestMethod.GET,value = "/search/{name}")
//    public ResponseEntity<?> getAllTagsSolr(@PathVariable("name") String name){
//        return new ResponseEntity<>(solrTagRepository.findByName(name), HttpStatus.OK);
//    }


    /**
     * GET ONE TAG BY ID
     */

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getOneTagById(
            @PathVariable Long id
    ){
        // check if tag id is exists
        Tag existedId = tagService.findOneTagById(id);
        if(existedId == null){
//            throw new org.springframework.boot.context.config.ResourceNotFoundException("Tag with id " + id + " not found");
            return new ResponseEntity<String>("Tag "+id +" does not exist.",HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(tagService.findOneTagById(id),HttpStatus.OK);
        }

    }


    /**
     * UPDATE TAG NAME BY ID
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateTagNameById(
            @RequestBody TagDTO tagDTO
    ) {
        tagService.updateTagNameById(tagDTO);
        return new ResponseEntity<>(tagDTO.getId(), HttpStatus.OK);

    }

        /**
         * DELETE ONE TAG NAME
         */

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteTagById(@PathVariable Long id){
        tagService.deleteTagById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);

    }

//    // Create tag with Solr index
//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity<?> saveTag(
//            @RequestBody Tag tagDTO
//    ) {
//        solrTagRepository.save(tagDTO);
//        return new ResponseEntity<>(tagDTO.getId(), HttpStatus.OK);
//
//    }
}


