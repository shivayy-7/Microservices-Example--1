<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update</title>
</head>
<body>
      <h2>Update | Lead</h2>
      
      <form action="updateLead" method="post">
         <pre>
            Id<Input type="text" name="id" value="${lead.id}" readonly/>
            First Name<Input type="text" name="firstName" value="${lead.firstName}"/>
            Last Name<Input type="text" name="lastName" value="${lead.lastName}"/>
            Email<Input type="email" name="email" value="${lead.email}"/>
            Mobile<Input type="text" name="mobile" value="${lead.mobile}"/>
               <Input type="submit"  value="update"/>
         </pre>
      </form>
</body>
</html>