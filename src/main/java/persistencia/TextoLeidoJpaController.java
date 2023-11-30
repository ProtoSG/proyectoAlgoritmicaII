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
import logica.TextoLeido;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author dgocr
 */
public class TextoLeidoJpaController implements Serializable {

    public TextoLeidoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public TextoLeidoJpaController() {
        emf=Persistence.createEntityManagerFactory("JuezCachimbo_PU");
    }
    
    public void create(TextoLeido textoLeido) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(textoLeido);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TextoLeido textoLeido) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            textoLeido = em.merge(textoLeido);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = textoLeido.getId();
                if (findtextoLeido(id) == null) {
                    throw new NonexistentEntityException("The textoLeido with id " + id + " no longer exists.");
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
            TextoLeido textoLeido;
            try {
                textoLeido = em.getReference(TextoLeido.class, id);
                textoLeido.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The textoLeido with id " + id + " no longer exists.", enfe);
            }
            em.remove(textoLeido);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TextoLeido> findtextoLeidoEntities() {
        return findtextoLeidoEntities(true, -1, -1);
    }

    public List<TextoLeido> findtextoLeidoEntities(int maxResults, int firstResult) {
        return findtextoLeidoEntities(false, maxResults, firstResult);
    }

    private List<TextoLeido> findtextoLeidoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TextoLeido.class));
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

    public TextoLeido findtextoLeido(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TextoLeido.class, id);
        } finally {
            em.close();
        }
    }

    public int gettextoLeidoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TextoLeido> rt = cq.from(TextoLeido.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
