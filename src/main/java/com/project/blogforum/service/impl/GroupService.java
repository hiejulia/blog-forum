package com.project.blogforum.service.impl;

import com.project.blogforum.domain.Group;
import com.project.blogforum.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupService {

    private final GroupRepository groupRepository;


    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public void createEmptyGroup(Group inbound) {
        groupRepository.save(inbound);
    }

//    @Transactional
//    public void createGroupUser(Long groupId, List<User> inboundStudents) {
//        Group group = groupRepository.findOne(groupId);
//        if (group != null) {
//            List<Student> students = inboundStudents.stream()
//                    .map(StudentMapper::fromInbound)
//                    .collect(Collectors.toList());
//            studentRepository.save(students);
//            group.getStudents().addAll(students);
//        } else {
//            //
//        }
//    }
    // Add user to group
//    @Transactional
//    public void
}