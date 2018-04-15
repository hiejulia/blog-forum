package com.project.blogforum.service;


import java.util.ArrayList;
import java.util.List;

import com.project.blogforum.BlogForumApplication;
import com.project.blogforum.dto.PostDTO;
import com.project.blogforum.search.ESPostRepository;
import com.project.blogforum.service.essearch.ESPostService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;


import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.*;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = BlogForumApplication.class)
public class ESPostServiceTest {

    @Autowired
    private ESPostService esPostService;


    @Autowired
    private ESPostRepository esPostRepository;

    @Autowired
    private ElasticsearchTemplate esTemplate;

    @Before
    public void before() {
        esTemplate.deleteIndex(PostDTO.class);
        esTemplate.createIndex(PostDTO.class);
        esTemplate.putMapping(PostDTO.class);
        esTemplate.refresh(PostDTO.class);
    }

    @Test
    public void testSave() {
        PostDTO postDTO = new PostDTO();
        postDTO.setId(1000L);
        postDTO.setTitle("Test title");
        esPostService.saveNewPost(postDTO);
        assertNotNull(postDTO.getId());
//        assertEquals(testBook.getTitle(), book.getTitle());
//        assertEquals(testBook.getAuthor(), book.getAuthor());
//        assertEquals(testBook.getReleaseDate(), book.getReleaseDate());

    }

    @Test
    public void testFindOne() {
        PostDTO postDTO = new PostDTO();
        postDTO.setId(1001L);
        postDTO.setTitle("Test title");
        esPostService.saveNewPost(postDTO);
        PostDTO testPost = esPostRepository.findOne(1001L);
        assertNotNull(testPost.getId());
        assertEquals(testPost.getTitle(), postDTO.getTitle());
        assertEquals(testPost.getAuthor(), postDTO.getAuthor());
    }

    @Test
    public void testFindByTitle() {
        PostDTO postDTO = new PostDTO();
        postDTO.setId(1001L);
        postDTO.setTitle("Test title");
        esPostService.saveNewPost(postDTO);
        List<PostDTO> byTitle = esPostRepository.findByTitle(postDTO.getTitle());
        assertThat(byTitle.size(), is(1));
    }

//    @Test
//    public void testFindByAuthor() {
//
//        List<Book> bookList = new ArrayList<>();
//
//        bookList.add(new Book("1001", "Elasticsearch Basics", "Rambabu Posa", "23-FEB-2017"));
//        bookList.add(new Book("1002", "Apache Lucene Basics", "Rambabu Posa", "13-MAR-2017"));
//        bookList.add(new Book("1003", "Apache Solr Basics", "Rambabu Posa", "21-MAR-2017"));
//        bookList.add(new Book("1007", "Spring Data + ElasticSearch", "Rambabu Posa", "01-APR-2017"));
//        bookList.add(new Book("1008", "Spring Boot + MongoDB", "Mkyong", "25-FEB-2017"));
//
//        for (Book book : bookList) {
//            bookService.save(book);
//        }
//
//        Page<Book> byAuthor = bookService.findByAuthor("Rambabu Posa", new PageRequest(0, 10));
//        assertThat(byAuthor.getTotalElements(), is(4L));
//
//        Page<Book> byAuthor2 = bookService.findByAuthor("Mkyong", new PageRequest(0, 10));
//        assertThat(byAuthor2.getTotalElements(), is(1L));
//
//    }

    @Test
    public void testDelete() {

        PostDTO postDTO = new PostDTO();
        postDTO.setId(1004L);
        postDTO.setTitle("Test title");
        esPostService.saveNewPost(postDTO);

        esPostRepository.delete(1004L);
        PostDTO testBook = esPostRepository.findOne(postDTO.getId());
        assertNull(testBook);
    }

}
