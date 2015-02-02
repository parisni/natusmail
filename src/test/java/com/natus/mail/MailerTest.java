package com.natus.mail;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;




import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.natus.mail.Mailer;

public class MailerTest {
    private static Mailer mailer;

    @BeforeClass
    public static void initCalculator() {
        
        try {
            mailer = new Mailer("tonMail","tonPwd");
        } catch ( IOException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Before
    public void beforeEachTest() {
        System.out.println("This is executed before each Test");
    }

    @After
    public void afterEachTest() {
        System.out.println("This is exceuted after each Test");
    }

    @Test
    public void testSum() {
	    for(int i=0;i<10;i++){
        mailer.sendMail("sonMail","HELLO MAN"+i," je t'ai spammé ?");
	    }
        //assertEquals(8, result);
    }

}
