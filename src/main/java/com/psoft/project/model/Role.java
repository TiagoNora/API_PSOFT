package com.psoft.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;


@Entity
@Table(name = "roles")
@Data
public class Role implements GrantedAuthority{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public static final String COSTUMER = "COSTUMER";
    public static final String MODERATOR = "MODERATOR";


    private String authority;

    public Role(Integer id, String authority) {
        this.id = id;
        this.authority = authority;
    }

    public Role() {

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}

