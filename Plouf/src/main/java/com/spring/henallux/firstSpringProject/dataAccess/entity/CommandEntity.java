package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "commande")
public class CommandEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column (name="datecommande")
    private Date datecommande;

    @ManyToOne
    @JoinColumn (name="clientid")
    private UserEntity clientid;

    @OneToMany(mappedBy = "commandEntity", cascade = CascadeType.ALL)
    private List<CommandLineEntity> lineEntities;


    public CommandEntity(Date datecommande, UserEntity clientid) {
        this.datecommande = datecommande;
        this.clientid = clientid;
        this.lineEntities = new ArrayList<>();
    }
    public CommandEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatecommande() {
        return datecommande;
    }

    public void setDatecommande(Date datecommande) {
        this.datecommande = datecommande;
    }

    public UserEntity getClientid() {
        return clientid;
    }

    public void setClientid(UserEntity clientid) {
        this.clientid = clientid;
    }

    public List<CommandLineEntity> getLineEntities() {
        return lineEntities;
    }

    public void setLineEntities(List<CommandLineEntity> lineEntities) {
        this.lineEntities = lineEntities;
    }

    public void addLine(CommandLineEntity commandLineEntity){
        lineEntities.add(commandLineEntity);
    }
}
