package com.natus.mail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Mailer {
    private String       senderMail;
    private String       pwd;
    private Session      session;
    private Properties   props;

    public Mailer( String senderMail, String pwd ) throws IOException {
        this.senderMail = senderMail;
        this.pwd = pwd;
        initMailer();
    }

    public void initMailer() throws IOException {

        props = new Properties();
        props.put( "mail.smtp.auth", "true" );
        props.put( "mail.smtp.starttls.enable", "true" );
        props.put( "mail.smtp.host", "smtp.gmail.com" );
        props.put( "mail.smtp.port", "587" );
        session = Session.getInstance( props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication( senderMail, pwd );
                    }
                } );
    }

    public void sendMail( String destMail, String subject, String content ) {

        try {

            Message message = new MimeMessage( session );
            message.setFrom( new InternetAddress( this.senderMail ) );
            message.setRecipients( Message.RecipientType.TO,
                    InternetAddress.parse( destMail ) );
            message.setSubject( subject );
            message.setText( content );

            Transport.send( message );

            System.out.println( "Done" );

        } catch ( MessagingException e ) {
            throw new RuntimeException( e );
        }
    }

}
