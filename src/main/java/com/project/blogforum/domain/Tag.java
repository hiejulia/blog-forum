package com.project.blogforum.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
//import org.apache.solr.client.solrj.beans.Field;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
//import org.springframework.data.solr.core.mapping.SolrDocument;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tag")
@Document(indexName = "tags", type = "tags", shards = 1, replicas = 0, refreshInterval = "-1")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Tag implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 50, unique = true)
    private String name;

    @Column(name = "post_id")
    private Long postId;

}
