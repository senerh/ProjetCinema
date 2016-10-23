package endpoint;

import hibernate.HibernateUtil;
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
    @Path("/hibernate")
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

}
