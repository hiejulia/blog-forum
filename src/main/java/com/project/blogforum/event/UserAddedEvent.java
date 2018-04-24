package com.project.blogforum.event;


import com.project.blogforum.domain.User;
import lombok.Data;

// User create event
@Data
public class UserAddedEvent {

    private User user;

}
