package com.project.blogforum.domain;


import com.google.common.base.Objects;
import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.time.Duration;

import static org.apache.commons.lang3.Validate.notNull;

@Table(name = "video")
@Entity
@Data
public class Video {

    private static final String YOUTUBE_LINK_PREFIX = "https://www.youtube.com/watch?v=";

    @Id
    private String videoId;

    private String title;

    private String description;

    @NotNull
    private Date publishDate;

    private String thumbnailLink;

//    @ManyToOne
//    private Source source;
//
//    @OneToOne(cascade = {CascadeType.ALL})
//    private VideoStatistic statistic;



}