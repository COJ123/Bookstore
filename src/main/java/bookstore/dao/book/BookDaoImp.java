package bookstore.dao.book;

import bookstore.dao.AbstractDao;
import bookstore.entity.Author;
import bookstore.entity.Book;
import bookstore.entity.Genre;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
public class BookDaoImp extends AbstractDao<Integer, Book> implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public List<Book> getBooks() {
        Session session = sessionFactory.getCurrentSession();
        Query<Book> query = session.createQuery("select b from Book b order by b.title", Book.class);
        return query.getResultList();
    }

    @Override
    public void saveBook(Book book) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(book);

    }

    @Override
    public Book getBook(int theId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Book.class, theId);
    }

    @Override
    public void deleteBook(int theId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Book where id=:bookId");
        query.setParameter("bookId", theId);
        query.executeUpdate();
    }

    @Override
    public Book getById(int theId) {
        return getByKey(theId);
    }

    @Override
    public Book getByTitleTest(String title) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("title", title));
        Book book = (Book) crit.uniqueResult();
        return book;
    }

    @Override
    public List<Book> findAllBook() {
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("title"));
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return (List<Book>)crit.list();
    }



}
