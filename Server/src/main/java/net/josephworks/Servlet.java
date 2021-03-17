package net.josephworks;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(
        name = "MyServlet",
        urlPatterns = {"/hello"}
)
class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        ServletOutputStream out = resp.getOutputStream();
        out.write("Hello from servlet!".getBytes());
        out.flush();
        out.close();
    }

}