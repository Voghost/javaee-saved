<%@ page import="com.example.demo.Model.Entity.Project" %>
<%@ page import="com.example.demo.Model.Database.DatabaseStaffProject" %>
<%@ page import="com.example.demo.Model.Entity.Staff" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.demo.Model.function.SessionProcess" %><%--
  Created by IntelliJ IDEA.
  User: voghost
  Date: 2020/6/26
  Time: 下午8:42
  To change this template use File | Settings | File Templates.
--%>
<%
    SessionProcess sessionProcess=new SessionProcess(request,response);
    if(!sessionProcess.hasSession()){
        response.sendRedirect("../login.jsp");
        return ;
    }
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title></title>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta name="generator" content=""/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;">
    <link href="css/haiersoft.css" rel="stylesheet" type="text/css" media="screen,print"/>
    <link href="css/print.css" rel="stylesheet" type="text/css" media="print"/>
    <script src="js/jquery-1.10.1.min.js"></script>
    <script src="js/side.js" type="text/javascript"></script>

    <!--[if lt IE 9]>
    <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
    <script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script>
    <![endif]-->
</head>


<body>
<!-- Popup -->
<div id="Popup">


    <form action="../deleteConnectionToStaffServlet" method="post">
        <input type="hidden" name="entityType" value="project">
        <!-- SubPopup -->
        <div id="SubPopup">
            <div class="form_boxD">
                <table cellpadding="0" cellspacing="0">
                    <tr class="ttl">
                        <th width="10">&nbsp;</th>
                        <th><strong>员工ID</strong></th>
                        <th><strong>员工名字</strong></th>
                        <th><strong>员工手机</strong></th>
                    </tr>

                    <%

                        Project project = new Project();
                        project.setProjectId(request.getParameter("sectionProject"));
                        DatabaseStaffProject databaseStaffProject = new DatabaseStaffProject();
                        ArrayList<Staff> staffs = databaseStaffProject.searchStaffInProject(project);
                        for (int i = 0; i < staffs.size(); i++) {
                    %>
                    <tr>
                        <th>
                            <input name="staff" type="checkbox" value="<%out.print(staffs.get(i).getStaffId());%>">
                            <input type="hidden" name="sectionProject" value="<% out.print(project.getProjectId());%>">
                        </th>
                        <th><%out.print(staffs.get(i).getStaffId());%></th>
                        <td><%out.print(staffs.get(i).getStaffName());%></td>
                        <td><%out.print(staffs.get(i).getStaffPhone());%></td>
                    </tr>
                    <%
                        }
                    %>
                </table>
            </div>
        </div>
        <!-- SubPopup -->

        <div id="BtmBtn">
            <div class="btn_box floatR mag_l20"><input name="" type="submit" value="确定"></div>
            <div class="btn_boxB floatR"><input name="" type="button" value="取消" onclick="location.href='javascript:history.go(-1);'"></div>
        </div>

    </form>
</div>
<!-- /Popup -->
</body>
</html>
