<%@ page isELIgnored="false" import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <h1 style="color: red;text-align: center;">Welcome To Employee Details Page</h1>
    <br>
    <br>
    <h2 style="color: green;text-align: center;">ID :: ${eid}</h2>
    <h2 style="color: green;text-align: center;">Name :: ${ename}</h2>
    <h2 style="color: green;text-align: center;">Job :: ${job}</h2>
    <h2 style="color: green;text-align: center;">Salary :: ${salary}</h2>
    <hr>
    <hr><!-- Horizontal row -->
    
    <h2 style="color: blue">Fruits :: ${fruits}</h2>
    <h2 style="color: blue">Mobile Numbers :: ${numbers}</h2>
    <h2 style="color: blue">Marks :: ${marks}</h2>
    <h2 style="color: blue">Colors :: ${colors[0]}..${colors[1]}..${colors[2]}</h2>
    
    <h2 style="color: blue">Colors :: <%=Arrays.toString((String[])request.getAttribute("colors")) %></h2>
    
    <h2 style="color: blue">Colors :: 
    <c:forEach var="color" items="${colors}">
    	${color}..
    </c:forEach>
    </h2>
    
    <hr>
    <hr>
    
    <h2 style="color: olive;">EmployeeDetails(DTO Object) :: ${empDTO}</h2>
    <h2 style="color: olive;">${empDTO.ename},${empDTO.salary}</h2>
    
    <hr>
    <hr>
    
    <h2 style="color: purple;">List Of EmployeeDetails :: ${empList}</h2>
    
    <h2 style="color: purple">List Of EmployeeDetails :: 
    <c:forEach var="list" items="${empList}">
    	${list}..
    </c:forEach>
    </h2>
    
    
    
    
    
    
    
    