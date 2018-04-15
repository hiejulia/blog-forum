package com.project.blogforum.controller.ES;

import com.google.common.base.Preconditions;
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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Api(value = "Posts ES", description = "Post API ES")
@RestController
@RequestMapping("/v1/api/es/posts")
@CrossOrigin
public class ESPostController {
//    @Autowired
//    private ElasticsearchOperations es;


    @Autowired
    ElasticsearchOperations operations;


    @Autowired
    private ESPostRepository esPostService;

    @Autowired
    private PostService postService;


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
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create post with index in ElasticSearch", notes = "Create a new post with Elasticsearch index")
    public ResponseEntity<?> addNewPost(
            @ApiParam(value = "Created post object", required = true) @Valid @RequestBody final Post postDTO)  throws URISyntaxException {
        Preconditions.checkNotNull(postDTO, "Resource provided is null!!!");

        if(postDTO.getTitle() == null){
            return ResponseEntity.badRequest().header("Failure", "A post cannot have empty title ").build();

        }
        PostDTO post1 = new PostDTO();
        // Save post in the MySQL database first
        Post p = postService.save(postDTO);

        post1.setAuthor(postDTO.getAuthor());
        post1.setContent(postDTO.getContent());
        post1.setSubtitle(postDTO.getSubtitle());
        post1.setTitle(postDTO.getTitle());
        post1.setDate(postDTO.getDate());
        // Set id (the same id generate )
        post1.setId(p.getId());

        esPostService.save(post1);
        // take the id
        return new ResponseEntity<>(post1,HttpStatus.CREATED);
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


//    /**
//     * DELETE ALL POSTS
//     */
//    @ApiOperation(value = "Delete all posts", notes = "By authenticated users only.", position = 6)
//    @RequestMapping(value = "/clear",method = RequestMethod.DELETE)
//    public ResponseEntity<?> deleteAllPosts(){
//        postService.deleteAllPosts();
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//    @GetMapping(value = "/name/{text}")
//    public List<Post> searchName(@PathVariable final String text) {
//        return esPostS.findByName(text);
//    }
//
//
//    @GetMapping(value = "/salary/{salary}")
//    public List<Users> searchSalary(@PathVariable final Long salary) {
//        return usersRepository.findBySalary(salary);
//    }


    @GetMapping(value = "/all")
    public List<PostDTO> searchAll() {
        List<PostDTO> postList = new ArrayList<>();
        Iterable<PostDTO> userses = esPostService.findAll();
        userses.forEach(postList::add);
        return postList;
    }
    // Delete post
    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable Long id) {

        postService.deletePostById(id);
        esPostService.delete(id);
        return "OK";
    }
    // Get one post by ES database

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Post> get(@PathVariable Long id) {
        return Optional.ofNullable(postService.findOnePostById(id))
                .map(p -> new ResponseEntity<>(
                        p,
                        HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

//    /**
//     * GET  /all with Pageable
//     */
//    @RequestMapping(value = "/getall/page",
//            method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<Post>> getAll(@RequestParam(value = "page" , required = false) Integer offset,
//                                               @RequestParam(value = "per_page", required = false) Integer limit)
//            throws URISyntaxException {
//        Page<Post> page = esPostService.findAll(PaginationUtil.generatePageRequest(offset, limit));
//        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/surveys", offset, limit);
//        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
//    }


//    @RequestMapping(value = "/_search//{query}",
//            method = RequestMethod.GET,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<Post> search(@PathVariable String query) {
//        return StreamSupport
//                .stream(surveySearchRepository.search(queryString(query)).spliterator(), false)
//                .collect(Collectors.toList());
//    }



    @RequestMapping( method = RequestMethod.GET)
    public List<PostDTO> findByTitleAndAuthor(@RequestParam(value = "title") String t,
                                                @RequestParam(value = "author") String a) {
        return esPostService.findByTitleAndAuthor(t, a);
    }

//
//    @RequestMapping( method = RequestMethod.GET)
//    public List<PostDTO> findByAuthorNot(@RequestParam(value = "author") String a) {
//        return esPostService.findByAuthorNot(a);
//    }


//    @RequestMapping( method = RequestMethod.GET)
//    public List<PostDTO> findByDescriptionLike(@RequestParam(value = "category") String c) {
//        return esPostService.findByCategoryLike(c);
//    }

//    @RequestMapping(value = "/searchByTitleContaining/{name}", method = RequestMethod.GET)
//    public PostDTO getByNameLike(@PathVariable String name,
//                                @RequestParam(name = "page", defaultValue = "0", required = false) int page,
//                                @RequestParam(name = "size", defaultValue = "0", required = false) int size,
//                                @RequestParam(name = "sort", defaultValue = "", required = false) String[] sort,
//                                HttpServletResponse response) {
//
////        page = page >= 0 ? page : page * -1;
////        size = size <= 0 ? minResults : (size > maxResults ? maxResults : size);
//        sort = sort.length == 2 ? (sort[1].equalsIgnoreCase("asc") || sort[1].equalsIgnoreCase("desc")
//                ? new String[] { String.join(",", sort) } : sort) : sort;
//
//        Page<PostDTO> moviePage = esPostService.(name, page, size, sort);
//
//        return PostDTO.builder().movies(moviePage.getContent()).build();
//    }



    // ========== Update to new Post ES route
//    @RequestMapping(params = {"page", "size", "sortBy", "sortOrder"}, method = RequestMethod.GET)
//    @ApiOperation(value = "Find All Paginated And Sorted", nickname = "findAllPaginatedAndSorted", notes = "This endpoint supports generic filtering. Examples: " + "<br><ul>"
//            + "<li> match one field: `?field=value`" + "<li> match multiple fields: `?field1=value1&field2=value2`" + "<li> multiple values for field: `?field=value1&field=value2`"
//            + "<li> date time range filters: `?dateTimeFilter=field,fromDate,toDate`" + "</ul>")
//    public Page<Entity> findAllPaginatedAndSorted(@RequestParam("page") final int page,
//                                                  @RequestParam("size") final int size,
//                                                  @RequestParam("sortBy") final String sortBy,
//                                                  @RequestParam("sortOrder") final String sortOrder) {
//        return service.findAllPaginatedAndSorted(page, size, sortBy, sortOrder);
//    }
//
//    @RequestMapping(value = "/_search", params = {"page", "size", "sortBy", "sortOrder"}, method = RequestMethod.GET)
//    @ApiOperation(value = "search", nickname = "search", notes = "This endpoint supports generic filtering. Examples: " + "<br><ul>" + "<li> match one field: `?field=value`"
//            + "<li> match multiple fields: `?field1=value1&field2=value2`" + "<li> multiple values for field: `?field=value1&field=value2`" + "</ul>")
//    public Page<Entity> search(@RequestParam("page") final int page,
//                               @RequestParam("size") final int size,
//                               @RequestParam("sortBy") final String sortBy,
//                               @RequestParam("sortOrder") final String sortOrder) {
//        Map<String, String[]> filters = new HashMap<>(request.getParameterMap());
//        return service.search(page, size, sortBy, sortOrder, filters);
//    }
//
//    // Update Post
//
//    @ApiOperation(value = "Update Resource", notes = "Update the existing Post")
//    @RequestMapping(method = RequestMethod.PUT)
//    @ResponseStatus(HttpStatus.OK)
//    public ResponseEntity<?> updateContentById(
//            @ApiParam(value = "Updated post object", required = true) @Valid @RequestBody final PostDTO postDTO) {
//        Preconditions.checkNotNull(postDTO, "PostDTO provided is null");
//        postService.updateContentById(postDTO);
//        // Update from ES database
//        Optional<String> resourceId = Optional.ofNullable(resource.getId());
//        service.update(id, resource);
//        return new ResponseEntity<>(postDTO.getId(), HttpStatus.OK);
//    }



    // Route get post by Id
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    public PostDTO findOne(@PathVariable("id") @ApiParam(value = "The Id of the Existing Resource to be Retrieved") final String id) {
        Long postId = Long.parseLong("0", 10);
        PostDTO crusher = esPostService.findOne(postId);
        Preconditions.checkNotNull(crusher, "Post not found by id = " + id);
        return crusher;
    }


}
