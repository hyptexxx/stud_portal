package com.journal.journal.enity.users.service.implementations;

import com.journal.journal.enity.users.DAO.interfaces.Users_DAO_interface;
import com.journal.journal.enity.users.model.Users;
import com.journal.journal.enity.users.service.interfaces.Users_service_interface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Users_service_implementation implements Users_service_interface {

    private final
    Users_DAO_interface users_dao_interface;

    public Users_service_implementation(Users_DAO_interface users_dao_interface) {
        this.users_dao_interface = users_dao_interface;
    }

    @Override
    public List<Users> findAll() {
        return users_dao_interface.findAll();
    }

    @Override
    public List<Users> findAllByTeacherId(int id_teacher) {
        return users_dao_interface.findAllByTeacherId(id_teacher);
    }
}
