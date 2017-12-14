package com.meknes.dao;

import com.meknes.entities.Produit;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by X-MART on 22/03/2017.
 */
@Repository("dao")
@Transactional
public class ProduitDaoImpl implements EntityRepository<Produit> {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Produit save(Produit p) {
        entityManager.persist(p);
        return p;
    }

    @Override
    public List<Produit> findAll() {
        Query req= entityManager.createQuery("select p from Produit p");
        return req.getResultList();
    }

    @Override
    public List<Produit> findByDesignation(String mc) {
        Query req= entityManager.createQuery
                ("select p from Produit p where p.designation like :x");
        req.setParameter("x", mc);
        return req.getResultList();    }

    @Override
    public Produit findIne(Integer id) {
        Produit p=entityManager.find(Produit.class,id);
        return p;
    }

    @Override
    public Produit update(Produit p) {
        entityManager.merge(p);
        return p;
    }

    @Override
    public void remove(Integer id) {
        Produit p= entityManager.find(Produit.class, id);
        entityManager.remove(p);

       }
}
