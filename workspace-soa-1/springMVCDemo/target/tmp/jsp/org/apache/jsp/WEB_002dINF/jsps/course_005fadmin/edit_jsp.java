package org.apache.jsp.WEB_002dINF.jsps.course_005fadmin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class edit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>我不是真正的慕课网</title>\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"");
      out.print(request.getContextPath());
      out.write("/resources/css/main.css\"\r\n");
      out.write("\ttype=\"text/css\" />\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"main\">\r\n");
      out.write("\t\t<div class=\"newcontainer\" id=\"course_intro\">\r\n");
      out.write("\t\t  <form name=\"mainForm\" action=\"");
      out.print( request.getContextPath());
      out.write("/courses/save\" method=\"post\">\r\n");
      out.write("\t\t    <div>\r\n");
      out.write("\t\t       <span>课程名称:</span><input type=\"text\" id=\"title\" name=\"title\">\r\n");
      out.write("\t\t    </div>\r\n");
      out.write("\t\t    <div>\r\n");
      out.write("\t\t       <span>课程时长:</span><input type=\"text\" id=\"duration\" name=\"duration\"> 秒\r\n");
      out.write("\t\t    </div> \r\n");
      out.write("\t\t    <div>\r\n");
      out.write("\t\t       <span>课程难度:</span>\r\n");
      out.write("\t\t       <select id=\"level\" name=\"level\">\r\n");
      out.write("                  <option value=\"0\">初级</option>\r\n");
      out.write("                  <option value=\"1\" selected=\"selected\">中级</option>\r\n");
      out.write("                  <option value=\"2\">高级</option>\r\n");
      out.write("                </select>\r\n");
      out.write("\t\t    </div> \r\n");
      out.write("\t\t    <div>\r\n");
      out.write("\t\t       <span>课程介绍:</span>\r\n");
      out.write("\t\t       <textarea id=\"descr\" name=\"descr\" rows=\"5\" style=\"width:480px\"></textarea>\r\n");
      out.write("\t\t    </div> \r\n");
      out.write("\t\t    <div>\r\n");
      out.write("\t\t       <input type=\"submit\" id=\"btnPass\" value=\"提交\" />\r\n");
      out.write("\t\t    </div> \r\n");
      out.write("\t\t  </form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
