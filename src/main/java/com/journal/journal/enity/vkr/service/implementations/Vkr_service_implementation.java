package com.journal.journal.enity.vkr.service.implementations;

import com.journal.journal.enity.vkr.DAO.interfaces.Vkr_DAO_interface;
import com.journal.journal.enity.vkr.service.interfaces.Vkr_service_interface;
import org.springframework.stereotype.Service;

@Service
public class Vkr_service_implementation implements Vkr_service_interface {
    private final
    Vkr_DAO_interface vkr_dao_interface;


    public Vkr_service_implementation(Vkr_DAO_interface vkr_dao_interface) {
        this.vkr_dao_interface = vkr_dao_interface;
    }

    @Override
    public void updateVkrByUserId(int user_id, int teacher) {
        vkr_dao_interface.updateVkrByUserId(user_id,teacher);
    }
}
