<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>	
<%@ page import="pack.coursetaught" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="assets/css/bootstrap.min.css" rel="stylesheet">
<link href="assets/css/CustomStyle.css" rel="stylesheet">
<title>Insert title here</title>
<style>
body{
background-color: #f3efed;
}
</style>
</head>
<body>
<% ArrayList<coursetaught> selectedcourse = (ArrayList<coursetaught>)request.getAttribute("selectedcourse"); 
%>
<br>
 <div class="col-md-4"></div>
            <div class="col-md-4">
            <h4 align="center">Teaching Courses</h4>
            <p style="color:red;text-align:center">${zc}</p>
                          <table class="table table-striped" >
                            <thead>
                                <tr>
									<th>CSI</th>
                                    <th>Course Name</th>
                                </tr>
                            </thead>
                        <tbody>
                        <% for (int i=0;i<selectedcourse.size();i++) {
                        	%>
                        <tr>
                            <td><%=selectedcourse.get(i).getCourseid() %></td>
                            <td><%=selectedcourse.get(i).getCoursename()%></td>
                            
                             <td><a href='post.jsp?x=<%= selectedcourse.get(i).getCoursename() %>'>Post</a></td>
                        </tr>
                        <%} %>
      
                        </tbody>
                </table>
      
         
</div>
<%@page import="pack.Alist"%>
<%

String netid=session.getAttribute("id").toString();
Alist a=new Alist();
String role;
role=a.role(netid);
System.out.println("Role:"+role);
if(role.equals("Staff")){%>

	<div class="col-md-4"><%@include file="header1.jsp" %></div>
<%@include file="footer.jsp" %>
<% }else{%>
	<div class="col-md-4"><%@include file="header.jsp" %></div>
<%@include file="footer.jsp" %>
<%}
%>
