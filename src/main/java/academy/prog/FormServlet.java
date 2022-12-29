package academy.prog;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/form")
public class FormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Questions questions = new Questions();
        for (Integer i = 0; i < questions.getList().size(); i++) {
            questions.getList().get(i).setAnswer(request.getParameter(i.toString()));
        }
        request.setAttribute("answerList", questions.getList());

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/table.jsp");
        System.out.println(questions.getList());
        dispatcher.forward(request, response);

    }
}
