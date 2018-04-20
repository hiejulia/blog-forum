package com.project.blogforum.domain.event;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewPostEvent implements Serializable {

    private static final long serialVersionUID = -4981161628784858616L;

    private Long postId;

    private String title;

    private Date date;
}