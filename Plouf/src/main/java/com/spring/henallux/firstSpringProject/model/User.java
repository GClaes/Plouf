package com.spring.henallux.firstSpringProject.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

public class User implements UserDetails {
    @NotBlank
    private String login;
    @NotBlank
    private String motDePasse;
    @NotBlank
    private String mdpRep;

    //SECURITY
    private String roles;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    //SECURITY

    @NotBlank
    private String nom;
    @NotBlank
    private String prenom;
    @NotBlank @Pattern(regexp = "(0|\\\\+32|0032)[1-9][0-9]{8}")
    private String numTel;
    @Email
    private String email;
    @NotBlank
    private String rue;
    @NotBlank
    private String localite;
    @NotNull @Min(1000) @Max(9992)
    private Integer codePostal;
    @NotBlank
    private String numRue;

    public User() {
        super();
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

    public Integer getCodePostal() {
        return codePostal;
    }

    public String getNumRue() {
        return numRue;
    }

    public void setLogin(String login) {
        if(login == null){
            throw new IllegalArgumentException();
        }
        this.login = login;
    }

    public void setMotDePasse(String motDePasse) {
        if(motDePasse == null){
            throw new IllegalArgumentException();
        }
        this.motDePasse = motDePasse;
    }

    public void setNom(String nom) {
        if(nom == null){
            throw new IllegalArgumentException();
        }
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        if(prenom == null){
            throw new IllegalArgumentException();
        }
        this.prenom = prenom;
    }

    public void setNumTel(String numTel) {
        if(numTel == null){
            throw new IllegalArgumentException();
        }
        this.numTel = numTel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRue(String rue) {
        if(rue == null){
            throw new IllegalArgumentException();
        }
        this.rue = rue;
    }

    public void setLocalite(String localite) {
        if(localite == null){
            throw new IllegalArgumentException();
        }
        this.localite = localite;
    }

    public void setCodePostal(Integer codePostal) {
        if(codePostal == null){
            throw new IllegalArgumentException();
        }
        this.codePostal = codePostal;
    }

    public void setNumRue(String numRue) {
        if(numRue == null){
            throw new IllegalArgumentException();
        }
        this.numRue = numRue;
    }
    public String getMdpRep() {
        return mdpRep;
    }

    public void setMdpRep(String mdpRep) {
        this.mdpRep = mdpRep;
    }

    //SECURITY


    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        if (!isEmpty(roles)) {
            String[] authoritiesAsArray = roles.split(",");

            for (String authority : authoritiesAsArray) {
                if (!isEmpty(authority)) {
                    grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + authority.trim()));
                }
            }
        }

        return grantedAuthorities;
    }

    public String getStringAuthority(){
        return this.roles;
    }
    @Override
    public String getPassword() {
        return motDePasse;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


    //SECURITY
}

