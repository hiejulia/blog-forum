package com.project.blogforum.solr;

import com.project.blogforum.domain.Tag;
import com.project.blogforum.dto.TagDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.List;

public interface SolrTagRepository extends SolrCrudRepository<Tag, Long> {

    List<Tag> findByName(String name);

}