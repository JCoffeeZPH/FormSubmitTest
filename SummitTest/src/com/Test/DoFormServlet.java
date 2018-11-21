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
 * 16:14
 */
@WebServlet(name = "DoFormServlet")
public class DoFormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        boolean b = isRepeatSubmit(request);
        if(b==true){
            System.out.println("请不要重复提交");
            return;
        }
        request.getSession().removeAttribute("token");
        System.out.println("处理用户提交请求");
    }
    protected boolean isRepeatSubmit(HttpServletRequest request){
        String client_token = request.getParameter("token");
        if(client_token == null)
            return true;
        String server_token = (String)request.getSession().getAttribute("token");
        if(server_token == null)
            return true;
        if(!client_token.equals(server_token))
            return true;
        return false;
    }
}
