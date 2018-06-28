package bookstore.dao.genre;

import bookstore.dao.AbstractDao;
import bookstore.entity.Genre;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenreDaoImp extends AbstractDao<Integer, Genre> implements  GenreDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Genre findById(int id) {
        return getByKey(id);
    }

    @Override
    public List<Genre> getGenres() {
        Session session = sessionFactory.getCurrentSession();
        Query<Genre> query = session.createQuery("select g from Genre g order by g.genre", Genre.class);
        return findAllGenres();
    }
    @Override
    public List<Genre> findAllGenres() {
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("genre"));
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return (List<Genre>)crit.list();
    }

    @Override
    public void delteGenre(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Genre where id=:genreId");
        query.setParameter("genreId", id);
        query.executeUpdate();
    }

    @Override
    public void saveGenre(Genre genre) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(genre);
    }
}
