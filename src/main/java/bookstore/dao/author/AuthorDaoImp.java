package bookstore.dao.author;

import bookstore.dao.AbstractDao;
import bookstore.dao.author.AuthorDao;
import bookstore.entity.Author;
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
public class AuthorDaoImp extends AbstractDao<Integer, Author> implements AuthorDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Author> getAuthors() {
        Session session = sessionFactory.getCurrentSession();
        Query<Author> query = session.createQuery("select a from Author a order by a.author",Author.class);
        return query.getResultList();
    }

    @Override
    public void saveAuthor(Author author) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(author);
    }

    @Override
    public Author findById(int id) {
        return getByKey(id);
    }

    @Override
    public List<Author> findAllAuthors() {
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("author"));
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return (List<Author>)crit.list();
    }

    @Override
    public void deleteAuthor(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Author where id=:authorId");
        query.setParameter("authorId", id);
        query.executeUpdate();
    }
}
