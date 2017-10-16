import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdateProfile extends HttpServlet {
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String meid =request.getParameter("meid");  
        String username =request.getParameter("username");
        String name =request.getParameter("name"); 
        String email =request.getParameter("email"); 
        String gender =request.getParameter("gender"); 
        String intro =request.getParameter("intro"); 
        
        try {
        	
            if(LoginDao.updProfile(meid, username, "", name, email, gender, intro)){
            	List<Map<String, Object>> userInfo= LoginDao.getUserInfo(meid);
                request.setAttribute("userInfo", userInfo);
                RequestDispatcher rd=request.getRequestDispatcher("profile.jsp");  
                rd.forward(request,response);  
            }else{  
                out.print("<html><script type=\"text/javascript\">alert('data errors!');window.location.href = \"index.jsp\";</script></html>");
            }  
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
