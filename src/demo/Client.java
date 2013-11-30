/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.util.Iterator;
import java.util.List;
import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author TATARAO
 */
public class Client {
    
    public static void main(String[] args) {
        
        Session session= new Configuration().configure().buildSessionFactory().openSession();
        
        Criteria crit=session.createCriteria(Employee.class);
        
      Criterion ob=Restrictions.gt("salary",new String("16000")); 
  /*    Criterion ob=Restrictions.like("ename","%a%");
         Criterion ob=Restrictions.eq("salary",new String("16000"));
    */    
        crit.add(ob);
        
        List l=crit.list();
        Iterator itr=l.iterator();
        
        while(itr.hasNext())
        {
            Employee emp=(Employee)itr.next();
            System.out.println(emp.getEname()+" "+emp.getSalary());
        }
        session.close();
    }
    
}
