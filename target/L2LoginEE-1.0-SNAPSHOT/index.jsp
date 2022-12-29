<%@ page import="academy.prog.Questions" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Prog Academy</title>
  </head>
  <body>


<form action="/form" method="POST">
  <h3>Please answer the following questions:</h3>

  <%
   Questions questions = new Questions();

  %>
    <section class="block">
       <span> <%=questions.getQuestion()%> </span>
    <br>
        <input type="radio" value="Yes" id="1" name="0">
        <label for="1">Yes</label>
        <input type="radio" value="No" id="2" name="0">
        <label for="2">No</label>
    </section>
    <br>
    <section class="block">
        <span> <%=questions.getQuestion()%> </span>
        <br>
        <input type="radio" value="Yes" id="3" name="1">
        <label for="3">Yes</label>
        <input type="radio" value="No" id="4" name="1">
        <label for="4">No</label>
    </section>
    <br>
    <section class="block">
        <span> <%=questions.getQuestion()%> </span>
        <br>
        <input type="radio" value="Yes" id="5" name="2">
        <label for="5">Yes</label>
        <input type="radio" value="No" id="6" name="2">
        <label for="6">No</label>
    </section>
    <br>
    <section class="block">
        <span> <%=questions.getQuestion()%> </span>
        <br>
        <input type="radio" value="Yes" id="7" name="3">
        <label for="7">Yes</label>
        <input type="radio" value="No" id="8" name="3">
        <label for="8">No</label>
    </section>
    <br>
    <input type="submit" />

</form>
<%--    <% String login = (String)session.getAttribute("user_login"); %>--%>

<%--    <% if (login == null || "".equals(login)) { %>--%>
<%--        <form action="/login" method="POST">--%>
<%--            Login: <input type="text" name="login"><br>--%>
<%--            Password: <input type="password" name="password"><br>--%>
<%--            <input type="submit" />--%>
<%--        </form>--%>
<%--    <% } else { %>--%>
<%--        <h1>You are logged in as: <%= login %></h1>--%>
<%--        <br>Click this link to <a href="/login?a=exit">logout</a>--%>
<%--    <% } %>--%>
  </body>
</html>
