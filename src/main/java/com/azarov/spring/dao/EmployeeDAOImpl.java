package com.azarov.spring.dao;

import com.azarov.spring.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public EmployeeDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Employee> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("From Employee").getResultList();
    }

    @Override
    public void save(Employee employee) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(employee);

    }

    @Override
    public Employee getEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("delete From Employee " + "where id =: employeeId")
                .setParameter("employeeId", id)
                .executeUpdate();
    }
}
