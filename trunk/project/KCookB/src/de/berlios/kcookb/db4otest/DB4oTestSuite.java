/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.berlios.kcookb.db4otest;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import java.util.List;

/**
 *
 * @author Knitter
 */
public class DB4oTestSuite {

    
    public void start() {
        ObjectContainer db = Db4o.openFile("databasefile");
        try {
            
            //db.set(new PersonObject(0, "Antonio", "Joaquim", 32));
            //System.err.println("Gravado objecto ");
            //db.set(new PersonObject(1, "Luis", "Serra", 15));
            //System.err.println("Gravado objecto ");
            
            List<PersonObject> r = db.get(PersonObject.class);
            for(PersonObject p : r) {
                System.err.println(p.getName());
                //p.setName(p.getName() + " modified");
                //db.set(p);
            }
            
        } finally {
            db.close();
        }
    }
}
