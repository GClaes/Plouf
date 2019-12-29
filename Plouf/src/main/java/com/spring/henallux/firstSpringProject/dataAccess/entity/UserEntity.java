package com.spring.henallux.firstSpringProject.dataAccess.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="user")
public class UserEntity{
    @Id @Column (name="login")
    private String login;
    @Column (name="motdepasse")
    private String motDePasse;

    @Column(name ="authorities", nullable = false)
    private String roles;
    //SECURITY
    @Column(name = "non_expired", nullable = false)
    private boolean accountNonExpired;
    @Column(name = "non_locked", nullable = false)
    private boolean accountNonLocked;
    @Column(name = "credentials_non_expired", nullable = false)
    private boolean credentialsNonExpired;
    @Column (name = "enabled", nullable = false)
    private boolean enabled;
    //SECURITY

    @Column (name="nom")
    private String nom;
    @Column (name="prenom")
    private String prenom;
    @Column (name="numtel")
    private String numTel;
    @Column (name="email")
    private String email;
    @Column (name="rue")
    private String rue;
    @Column (name="localite")
    private String localite;
    @Column (name="codepostal")
    private int codePostal;
    @Column (name="numrue")
    private String numRue;

    public UserEntity(String login, String motDePasse, String authorities, boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled, String nom, String prenom, String numTel, String email, String rue, String localite, int codePostal, String numRue) {
        this.login = login;
        this.motDePasse = motDePasse;
        this.roles = authorities;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
        this.nom = nom;
        this.prenom = prenom;
        this.numTel = numTel;
        this.email = email;
        this.rue = rue;
        this.localite = localite;
        this.codePostal = codePostal;
        this.numRue = numRue;
    }

    public UserEntity() {
    }

    public String getLogin() {
        return login;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNumTel() {
        return numTel;
    }

    public String getEmail() {
        return email;
    }

    public String getRue() {
        return rue;
    }

    public String getLocalite() {
        return localite;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public String getNumRue() {
        return numRue;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public void setLocalite(String localite) {
        this.localite = localite;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public void setNumRue(String numRue) {
        this.numRue = numRue;
    }



    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }


}
