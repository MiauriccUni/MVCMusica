package com.mvc.mvcmusica.Service;

import com.mvc.mvcmusica.Repository.Subs_RelationRepo;
import com.mvc.mvcmusica.models.Subs_Relation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class Subs_RelationService {

    @Autowired
    Subs_RelationRepo subs_relationRepo;

    public Subs_Relation postRelations(Subs_Relation subs_relation) {
        return subs_relationRepo.save(subs_relation);
    }

    public List<Subs_Relation> findAll() {
        return subs_relationRepo.findAll();
    }

    public Optional<Subs_Relation> findById(Long id) {
        return subs_relationRepo.findById(id);
    }

    public void deleteById(Long id) {
        subs_relationRepo.deleteById(id);
    }
}
