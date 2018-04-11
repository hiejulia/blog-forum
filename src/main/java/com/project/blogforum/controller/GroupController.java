package com.project.blogforum.controller;




import com.project.blogforum.domain.Group;
import com.project.blogforum.service.impl.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/groups")
public class GroupController {
    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    // Create empty group
    @PostMapping
    public void createEmptyGroup(@RequestBody Group g) {
        groupService.createEmptyGroup(g);
    }

}