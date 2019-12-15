package com.journal.journal.enity.users.service.interfaces;

import com.journal.journal.enity.users.model.Users;

import java.util.List;

public interface Users_service_interface {
    List<Users> findAll();

    List<Users> findAllByTeacherId(int id_teacher);

    void updateUserByUserId(String fio, int napr, int category, int user_id);
}
