<%@ page import="java.util.*" %>
<%@ page import="model.Flight" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Flight Status</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>

    <div class="container">
        <h1>Flight Status</h1>
        <table class="flight-table">
            <thead>
                <tr>
                    <th>Flight Number</th>
                    <th>Status</th>
                    <th>Gate</th>
                </tr>
            </thead>
            <tbody>
                <% 
                @SuppressWarnings("unchecked")
                ArrayList<Flight> flights = (ArrayList<Flight>) request.getAttribute("flights");
                if (flights != null && !flights.isEmpty()) {
                    for (Flight flight : flights) {
                        %>
                        <tr>
                            <td><%= flight.getFlightNumber() %></td>
                            <td><%= flight.getStatus() %></td>
                            <td><%= flight.getGate() %></td>
                        </tr>
                        <% 
                    }
                } else {
                    %>
                    <tr><td colspan="3">No flights available</td></tr>
                    <% 
                }
                %>
            </tbody>
        </table>
         <div class="button-container">
         <a href="notificationservice.jsp" class="button">Click here to send Email Notification</a>
         </div>
    </div>
</body>
</html>
