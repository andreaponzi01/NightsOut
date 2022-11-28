package nightsout.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Email {

    private Email(){
        //ignored
    }

    public static void sendEmail(String recipient, String subject, String text) {

        String from = "ispwproject@virgilio.it"; //mail dalla quale inviamo
        String host = "smtp.virgilio.it";

        // Proprietà di sistema
        Properties properties = System.getProperties();
        // Proprietà relative alla configurazione del protocollo smtp
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");


        /*
            Occorre utilizzare una SESSIONE AUTENTICATA, dove le proprietà sono quelle che abbiamo creato, cioè:
            1) Proprietà di sistema --> System.getProperties()
            2) Proprietà relative alla configurazione del protocollo smtp --> (Configurazione smtp).

            Andiamo a creare un nuovo Authenticator (con "new javax.mail.Authenticator()")
            e dopodiché andiamo a fare @Override di getPasswordAuthentication() perché l'implementazione di Authenticator (classe astratta)
            di base prevede un return null. La getPasswordAuthentication() deve  ritornare un PasswordAuthentication.

            Perciò la nostra "nuova" getPasswordAuthentication() costruisce e ritorna un oggetto PasswordAuthentication con le NOSTRE credenziali.
         */

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {return new PasswordAuthentication(from, "Project.2022");}
        });

        // Per il Debug (su terminale)
        session.setDebug(true);


        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject(subject);
            message.setText(text);

            //Invio effettivo del messaggio
            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
