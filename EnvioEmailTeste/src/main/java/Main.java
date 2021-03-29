import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        System.out.println("** Enviar Email com Gmail JAVA **");
        enviarEmail();
    }

    public static void enviarEmail(){

        Properties props = new Properties();
        /** Parâmetros de conexão com servidor Gmail */
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication()
                    {
                        return new PasswordAuthentication("luiz.1990sc@gmail.com", "Lu1z/202.");
                    }
                });

        session.setDebug(true);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("luiz.1990sc@gmail.co"));

            Address[] toUser = InternetAddress.parse("a.luizrech@gmail.com");

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject("COFFOPS - Enviando email com JavaMail");
            message.setText("Email envido através do JavaMail autenticado com GMAIL. Coffops.");


            Transport.send(message);

            System.out.println("Email enviado!!!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
