package com.meknes.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by X-MART on 22/03/2017.
 */
@Entity
public class Categorie implements Serializable{
    @Id @GeneratedValue
    private Integer id;
    private String nomCategorie;
    @OneToMany(mappedBy = "categorie", fetch = FetchType.LAZY)
    private Collection<Produit> produits;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public Collection<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Collection<Produit> produits) {
        this.produits = produits;
    }

    public Categorie() {
    }

    public Categorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }
}
