package com.project.blogforum.domain;


import com.google.common.base.Objects;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "videostatistic")
@Data
public class VideoStatistic {

    @Id
    @GeneratedValue
    private Long id;

    private long views;

    private long liked;

    private long disliked;

    private double likesRatio;


}