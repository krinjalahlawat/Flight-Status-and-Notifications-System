package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import database.FlightDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Flight;

@WebServlet("/flightStatus")
public class FlightStatusServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private FlightDAO flightDAO;

	@Override
	public void init() {
		flightDAO = new FlightDAO();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		List<Flight> flights = flightDAO.getAllFlights();
		request.setAttribute("flights", flights);
		RequestDispatcher res = request.getRequestDispatcher("/flightStatus.jsp");
		res.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
