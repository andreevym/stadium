package ru.joinlang.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.joinlang.dao.GroupDao;
import ru.joinlang.model.Group;
import ru.joinlang.model.User;

import java.util.List;

@Service
public class GroupService {

    @Autowired
    private GroupDao groupDao;

    public List<Group> getAll() {
        return groupDao.getAll();
    }
}
