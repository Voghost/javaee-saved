package com.example.demo.Controller;

import com.example.demo.Model.Database.DatabaseStaffDepartment;
import com.example.demo.Model.Database.DatabaseStaffProject;
import com.example.demo.Model.Database.DatabaseStaffTask;
import com.example.demo.Model.Entity.Department;
import com.example.demo.Model.Entity.Project;
import com.example.demo.Model.Entity.Staff;
import com.example.demo.Model.Entity.Task;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Edgar Liu
 */
@WebServlet(name = "DeleteConnectionToStaffServlet", urlPatterns = "/deleteConnectionToStaffServlet")
public class DeleteConnectionToStaffServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        String entityType = request.getParameter("entityType");
        PrintWriter out = response.getWriter();

        //如果是部门
        if (entityType.equals("department")) {
            String[] staffIds = request.getParameterValues("staff");
            System.out.println(request.getParameter("sectionDepartment"));
            DatabaseStaffDepartment databaseStaffDepartment = new DatabaseStaffDepartment();
            Staff staff = new Staff();
            Department department = new Department(request.getParameter("sectionDepartment"), null, null);
            System.out.println(department.toString()); //test=============================
            if (staffIds != null) {
                for (int i = 0; i < staffIds.length; i++) {
                    staff.setStaffId(staffIds[i]);
                    databaseStaffDepartment.deleteStaffToDepartment(staff, department);
                }
            }
            response.sendRedirect("backProcess/departments.jsp");
            //   request.getRequestDispatcher("backProcess/departments.jsp").forward(request,response);
        } else if (entityType.equals("task")) {
            String[] staffIds = request.getParameterValues("staff");
            DatabaseStaffTask databaseStaffTask = new DatabaseStaffTask();
            Staff staff = new Staff();
            Task task = new Task(request.getParameter("sectionTask"), null, null, null, null);
            if (staffIds != null) {
                for (int i = 0; i < staffIds.length; i++) {
                    staff.setStaffId(staffIds[i]);
                    databaseStaffTask.deleteStaffToTask(staff, task);
                }
            }
            response.sendRedirect("backProcess/tasks.jsp");
        } else if (entityType.equals("project")) {
            String[] staffIds = request.getParameterValues("staff");
            System.out.println(request.getParameter("sectionProject"));
            DatabaseStaffProject databaseStaffProject = new DatabaseStaffProject();
            Staff staff = new Staff();
            Project project = new Project(request.getParameter("sectionProject"), null, null, null);
            if (staffIds != null) {
                for (int i = 0; i < staffIds.length; i++) {
                    staff.setStaffId(staffIds[i]);
                    databaseStaffProject.deleteStaffToProject(staff, project);
                }
            }
            response.sendRedirect("backProcess/projects.jsp");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
