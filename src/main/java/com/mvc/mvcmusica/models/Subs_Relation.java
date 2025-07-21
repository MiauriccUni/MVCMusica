package com.mvc.mvcmusica.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "1177_MVC_Subs_Relation")
public class Subs_Relation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Users user;



}
