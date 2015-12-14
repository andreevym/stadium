package ru.joinlang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.joinlang.model.Group;
import ru.joinlang.model.User;
import ru.joinlang.service.GroupService;

import java.util.List;

@RestController
public class GroupController {

    @Autowired
    private GroupService groupService;

    @RequestMapping("/allGroups")
    public List<Group> getAllGroups() {
        return groupService.getAll();
    }
}
