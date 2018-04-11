package com.project.blogforum.domain;

import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tag")
@Data
@SolrDocument(solrCoreName = "collection1")
public class Tag implements Serializable {

    @Id
    @Field
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 50, unique = true)
    @Field
    private String name;

    @Column(name = "post_id")
    @Field
    private Long postId;

}
