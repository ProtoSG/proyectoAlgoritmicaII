/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Texto;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author dgocr
 */
public class TextoJpaController implements Serializable {

    public TextoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public TextoJpaController() {
        emf=Persistence.createEntityManagerFactory("JuezCachimbo_PU");
    }
    
    public void create(Texto texto) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(texto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Texto texto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            texto = em.merge(texto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = texto.getIdTexto();
                if (findTexto(id) == null) {
                    throw new NonexistentEntityException("The texto with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Texto texto;
            try {
                texto = em.getReference(Texto.class, id);
                texto.getIdTexto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The texto with id " + id + " no longer exists.", enfe);
            }
            em.remove(texto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Texto> findTextoEntities() {
        return findTextoEntities(true, -1, -1);
    }

    public List<Texto> findTextoEntities(int maxResults, int firstResult) {
        return findTextoEntities(false, maxResults, firstResult);
    }

    private List<Texto> findTextoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Texto.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Texto findTexto(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Texto.class, id);
        } finally {
            em.close();
        }
    }

    public int getTextoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Texto> rt = cq.from(Texto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
