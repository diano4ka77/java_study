package ru.sqta.pft.mantis.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sqta.pft.mantis.model.Issue;
import ru.sqta.pft.mantis.model.User;
import java.util.ArrayList;
import java.util.List;

public class DbHelper {

  public static SessionFactory sessionFactory;

  public DbHelper() {
    sessionFactory = new Configuration().configure().buildSessionFactory();
  }

  public List<User> users() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<User> result = session.createQuery("from User").list();
    for (User user : result) {
      System.out.println(user);
    }
    session.getTransaction().commit();
    session.close();
    return result;
  }

  public boolean validateUser(int id) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<Issue> result = session.createQuery("from Issue").list();
    List<Integer> list = new ArrayList<Integer>();
    for (Issue issue : result) {
      list.add((issue.getId()));
    }
    return list.contains(id);
  }
}