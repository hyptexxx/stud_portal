package com.journal.journal.enity.users.DAO.interfaces;

import com.journal.journal.enity.users.model.Users;

import java.util.List;

public interface Users_DAO_interface {
    List<Users> findAll();
    List<Users> findAllByTeacherId(int id_teacher);
}
