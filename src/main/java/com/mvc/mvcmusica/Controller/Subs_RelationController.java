package com.mvc.mvcmusica.Controller;

import com.mvc.mvcmusica.Service.Subs_RelationService;
import com.mvc.mvcmusica.models.Subs_Relation;
import com.mvc.mvcmusica.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Music/Subs_Relation")
public class Subs_RelationController {
    @Autowired
    private Subs_RelationService subs_relationService;

    @PostMapping
    public Subs_Relation create(@RequestBody Subs_Relation subs_relation) {
       return subs_relationService.postRelations(subs_relation);
    }

    @GetMapping
    public List<Subs_Relation> getSubs_Relation() {
        return subs_relationService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Subs_Relation> findById(@PathVariable("id") Long id) {
        return subs_relationService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        subs_relationService.deleteById(id);
    }
}
