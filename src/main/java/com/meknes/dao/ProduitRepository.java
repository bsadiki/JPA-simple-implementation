package com.meknes.dao;

import com.meknes.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by X-MART on 22/03/2017.
 */
public interface ProduitRepository extends JpaRepository<Produit, Integer>{
    @Query("select p from Produit p where p.designation like :x")
    public List<Produit> produitsParMC(@Param("x") String mc);
}
