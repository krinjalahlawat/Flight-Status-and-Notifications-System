package emailNotificationsService;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import database.FlightDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Flight;

@WebServlet("/sendFlightStatus")
public class SendFlightStatusServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private FlightDAO flightDAO;

    @Override
    public void init() {
        flightDAO = new FlightDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String recipientEmail = request.getParameter("email");

        List<Flight> flights = flightDAO.getAllFlights();
        String flightStatusContent = generateFlightStatusContent(flights);

        boolean emailSent = sendEmail(recipientEmail, "Flight Status Notification", flightStatusContent);
        String message;
        if (emailSent) {
            message="Flight status has been successfully sent to " + recipientEmail;
        } else {
        	 message = "Failed to send flight status. Please try again.";
        }
        
        request.setAttribute("emailSentMessage", message);
        request.setAttribute("emailSent", emailSent);
        request.getRequestDispatcher("/emailNotificationResponse.jsp").forward(request, response);
    }

    private String generateFlightStatusContent(List<Flight> flights) {
        StringBuilder content = new StringBuilder();
        content.append("<h1>Flight Status Report</h1>");
        content.append("<table border='1' cellpadding='5' cellspacing='0'>");
        content.append("<tr><th>Flight Number</th><th>Status</th><th>Gate</th></tr>");

        if (flights != null && !flights.isEmpty()) {
            for (Flight flight : flights) {
                content.append("<tr>");
                content.append("<td>").append(flight.getFlightNumber()).append("</td>");
                content.append("<td>").append(flight.getStatus()).append("</td>");
                content.append("<td>").append(flight.getGate()).append("</td>");
                content.append("</tr>");
            }
        } else {
            content.append("<tr><td colspan='3'>No flights available</td></tr>");
        }
        content.append("</table>");

        return content.toString();
    }

    private boolean sendEmail(String to, String subject, String content) {
        final String username = "ahlawatkrinjal@gmail.com"; 
        final String password = "qqkxwxznoqtcfeuw"; 

        // Set up properties for SMTP
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Create a session with authentication
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a default MimeMessage object
            Message message = new MimeMessage(session);

            // Set From: header field
            message.setFrom(new InternetAddress(username));

            // Set To: header field
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

            // Set Subject: header field
            message.setSubject(subject);

            // Set the actual message
            message.setContent(content, "text/html");

            // Send the message
            Transport.send(message);
            return true;

        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }
}
