package com.theforest.apachecommonsexample.email;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.mail.*;

/**
 * Library for sending e-mail from Java.
 */
public class EmailExample {
    // хост и порт нужен)))))
    public static void main(String[] args) throws EmailException {
        Email email = new SimpleEmail();
        email.setHostName("yandex.ru");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("xyzxyzxyzxyzxyzxyzxyzxyz.xyz", "KJAFijw4@4ma*234nOAFm"));
        email.setSSLOnConnect(true);
        email.setFrom("xyzxyzxyzxyzxyzxyzxyzxyz.xyz@yandex.ru");
        email.setSubject("TestMail");
        email.setMsg("This is a test mail ... :-)");
        email.addTo("xyzxyzxyzxyzxyzxyzxyzxyz.xyz@yandex.ru");
        email.send();
    }



}
