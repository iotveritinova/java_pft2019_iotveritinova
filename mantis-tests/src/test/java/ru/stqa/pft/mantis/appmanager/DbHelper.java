package ru.stqa.pft.mantis.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.stqa.pft.mantis.model.UserData;
import ru.stqa.pft.mantis.model.Users;

import java.util.List;

public class DbHelper {
  private final SessionFactory sessionFactory;

  public DbHelper(ApplicationManager app) {
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build(); // configure()s settings from hibernate.cfg.xml
    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
  }

  public Users userData() {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<UserData> result = session.createQuery("from UserData").list();
    for (UserData group : result) {
      System.out.println(group);
    }
    session.getTransaction().commit();
    session.close();
    return new Users(result);
  }
}