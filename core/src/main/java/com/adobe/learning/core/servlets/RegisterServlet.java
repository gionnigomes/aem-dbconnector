package com.adobe.learning.core.servlets;

import com.adobe.learning.core.service.DatabaseService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.apache.sling.api.servlets.ServletResolverConstants.*;

@Component(service = Servlet.class, property = {
        SLING_SERVLET_PATHS + "=" + "/bin/app/register",
        SLING_SERVLET_METHODS + "=" + HttpConstants.METHOD_GET,
        SLING_SERVLET_METHODS + "=" + HttpConstants.METHOD_POST,
        SLING_SERVLET_EXTENSIONS + "=" + "json"
})
public class RegisterServlet extends SlingAllMethodsServlet {

    private static final long serialVersionUID = 1L;

    @Reference
    private DatabaseService databaseService;

    @Override
    protected void doPost(final SlingHttpServletRequest req, final SlingHttpServletResponse resp) throws IOException {

        try (Connection connection = databaseService.getConnection()) {
            String name = req.getParameter("name");
            int age = Integer.parseInt(req.getParameter("age"));

            String sql = "INSERT INTO user_table (user_name, age) VALUES (?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setString(1, name);
                ps.setInt(2, age);
                ps.execute();
            }
            catch (Exception e) {
                resp.getWriter().write(e.getMessage());
            }
        }
        catch (Exception e) {
            resp.getWriter().write(e.getMessage());
        }
    }

    @Override
    protected void doGet(final SlingHttpServletRequest req, final SlingHttpServletResponse resp) throws IOException {

        try (Connection connection = databaseService.getConnection()) {
            String sql = "SELECT * FROM user_table";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.execute();
                try (ResultSet rs = ps.getResultSet()) {
                    while (rs.next()) {
                        resp.getWriter().write("name=" + rs.getString(1) + " age=" + rs.getInt(2) + "\n");
                    }
                }
                catch (Exception e) {
                    resp.getWriter().write(e.getMessage());
                }
            }
            catch (Exception e) {
                resp.getWriter().write(e.getMessage());
            }
        }
        catch (Exception e) {
            resp.getWriter().write(e.getMessage());
        }
    }
}
