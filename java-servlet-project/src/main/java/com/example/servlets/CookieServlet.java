package com.example.servlets;

import jakarta.servlet.*;
// import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

// @WebServlet("/cookie")
public class CookieServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  protected void doGet(
    HttpServletRequest request,
    HttpServletResponse response
  ) throws ServletException, IOException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    // Get the cookies from the request
    Cookie[] cookies = request.getCookies();

    // Check if cookies exist
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        out.println(" <p>Name: " + cookie.getName() + " </p>");
        out.println(" <p>Value: " + cookie.getValue() + " </p>");
        // out.println(" <p>Comment: " + cookie.getComment() + " </p>"); //Deprecated
        out.println(" <p>Domain: " + cookie.getDomain() + " </p>");
        out.println(" <p>Max Age: " + cookie.getMaxAge() + " </p>");
        out.println(" <p>Path: " + cookie.getPath() + " </p>");
        out.println(" <p>Secure: " + cookie.getSecure() + " </p>");
        // out.println(" <p>Version: " + cookie.getVersion() + " </p>"); //Deprecated
        out.println("<br>");
      }
    } else {
      out.println("No cookies found.");
    }
  }

  protected void doPost(
    HttpServletRequest request,
    HttpServletResponse response
  ) throws ServletException, IOException {
    doGet(request, response);
  }
}
