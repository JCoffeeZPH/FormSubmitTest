package com.Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ${PACKAGE_NAME}
 * Administrator
 * 2018/11/21
 * 15:44
 */
@WebServlet(name = "FormServlet")
/**
 * 用于生成token，和跳转到form.jsp
 * */
public class FormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String token = TokenProccessor.getInstance().makeToken();
        System.out.println("生成的Token为：" + token);
        request.getSession().setAttribute("token",token);
        request.getRequestDispatcher("/form.jsp").forward(request,response);
    }
}
