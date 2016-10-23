package endpoint;

import dao.ActeurDAO;
import util.HibernateUtil;
import model.ActeurEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/test")
public class TestEndpoint {

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String getTest() {
        return "Hello world !";
    }

    @GET
    @Path("/util")
    @Produces(MediaType.TEXT_PLAIN)
    public String getHibernate() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.close();
        return "Hibernate works !";
    }

    @GET
    @Path("/acteurs")
    @Produces(MediaType.TEXT_PLAIN)
    public String getActeurs() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        String res = "Liste des acteurs";
        Transaction tx = session.beginTransaction();
        List<ActeurEntity> listActeurEntity = (List<ActeurEntity>) session.createQuery("from ActeurEntity").list();
        for (ActeurEntity acteurEntity : listActeurEntity) {
            res += "\n" + acteurEntity.getNomAct();
        }
        tx.commit();
        session.close();
        return res;
    }

    @GET
    @Path("/xml")
    @Produces(MediaType.APPLICATION_XML)
    public List<ActeurEntity> getXml() {
        ActeurDAO acteurDAO = new ActeurDAO();
        return acteurDAO.getActeurEntityList();
    }

    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ActeurEntity> getJson() {
        ActeurDAO acteurDAO = new ActeurDAO();
        return acteurDAO.getActeurEntityList();
    }

}
