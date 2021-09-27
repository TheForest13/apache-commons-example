package com.theforest.apachecommonsexample.digester;



import com.theforest.apachecommonsexample.digester.stuff.Address;
import com.theforest.apachecommonsexample.digester.stuff.Employee;
import com.theforest.apachecommonsexample.digester.stuff.EmployeeModule;
import org.apache.commons.digester3.Digester;
import org.apache.commons.digester3.binder.DigesterLoader;
import org.xml.sax.SAXException;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * XML-to-Java-object mapping utility.
 */
public class DigesterExample {
    private static DigesterLoader dl = DigesterLoader.newLoader(new EmployeeModule())
            .setNamespaceAware(false);
    public static void main(String[] args) {
        try {

            Digester digester = dl.newDigester();
            Employee employee = digester.parse(new FileInputStream("src\\main\\resources\\employee.xml"));

            System.out.print(employee.getFirstName() + " ");
            System.out.print(employee.getLastName() + ", ");
            for (Address a : employee.getAddressList()) {
                System.out.print(a.getType() + ", ");
                System.out.print(a.getCity() + ", ");
                System.out.println(a.getState());
            }

        } catch (IOException e) {

            e.printStackTrace();
        } catch (SAXException e) {

            e.printStackTrace();
        }
    }
}
