/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.0.M9
 * Generated at: 2024-03-17 19:53:03 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Order books</title>\r\n");
      out.write("<script type=\"text/javascript\" src=\"js/jQuery.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/style.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"bg-cont\">\r\n");
      out.write("<video id=\"bg\" src=\"./media/bgvideo.mp4\" autoplay loop muted></video></div>\r\n");
      out.write("<div class=\"form-container\"> <!-- Add a container for the form -->\r\n");
      out.write("    <form method=\"post\" action=\"createorder\" onsubmit=\"return chk()\">\r\n");
      out.write("        <label for=\"prodname\">Product Name: </label>\r\n");
      out.write("        <input type=\"text\" id=\"prodname\" name=\"prodname\">\r\n");
      out.write("        <span id=\"nsms\"></span>\r\n");
      out.write("        <button type=\"button\" id=\"check\">Check</button>\r\n");
      out.write("        <div id=\"checked\" style=\"display: none;\">\r\n");
      out.write("            <label for=\"prodrate\">Product Rate: </label>\r\n");
      out.write("            <input type=\"text\" readonly id=\"prodrate\" name=\"prodrate\">\r\n");
      out.write("            <label for=\"prodqty\">Product Quantity: </label>\r\n");
      out.write("            <input type=\"number\" id=\"prodqty\" name=\"prodqty\">\r\n");
      out.write("            <span id=\"qsms\"></span>\r\n");
      out.write("            <input type=\"hidden\" readonly id=\"oprodqty\" name=\"oprodqty\">\r\n");
      out.write("            <input type=\"hidden\" readonly id=\"prodid\" name=\"prodid\">\r\n");
      out.write("            <input type=\"submit\" value=\"Order\">\r\n");
      out.write("        </div>\r\n");
      out.write("    </form>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t$(document).ready(function() {\r\n");
      out.write("\t\t\t$(\"#check\").click(function() {\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tlet prodname1 = $(\"#prodname\").val();\r\n");
      out.write("\t\t\t\tif (prodname1 === \"\") {\r\n");
      out.write("\t\t\t\t\t $(\"#nsms\").html(\"Name cannot be null\");\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\t\turl : \"getproduct\",\r\n");
      out.write("\t\t\t\t\t\ttype : \"POST\",\r\n");
      out.write("\t\t\t\t\t\tdataType : \"JSON\",\r\n");
      out.write("\t\t\t\t\t\tdata : {\r\n");
      out.write("\t\t\t\t\t\t\tprodname : prodname1\r\n");
      out.write("\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\tsuccess : function(res) {\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\tif (res.length > 0) {\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#prodrate\").val(res[0].prodrate);\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#oprodqty\").val(res[0].prodqty);\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#prodid\").val(res[0].prodid);\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#checked\").show(); // Show the hidden fields\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#nsms\").html(\"\");\r\n");
      out.write("\t\t\t\t\t\t\t\tconsole.log(res);\r\n");
      out.write("\t\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#nsms\").html(\"Product not found in database\");\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t});\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\tfunction chk() {\r\n");
      out.write("\t\t\tlet errorQty = validQty();\r\n");
      out.write("\t\t\tif (errorQty) {\r\n");
      out.write("\t\t\t\treturn true;\r\n");
      out.write("\t\t\t} else {\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tfunction validQty() {\r\n");
      out.write("\t\t    let prodqty = parseInt($(\"#prodqty\").val());\r\n");
      out.write("\t\t    let oprodqty = parseInt($(\"#oprodqty\").val());\r\n");
      out.write("\t\t    if (prodqty > 0) {\r\n");
      out.write("\t\t        if (oprodqty >= prodqty) {\r\n");
      out.write("\t\t            $(\"#qsms\").html(\"\");\r\n");
      out.write("\t\t            return true;\r\n");
      out.write("\t\t        } else {\r\n");
      out.write("\t\t            $(\"#qsms\").html(\"Not available\");\r\n");
      out.write("\t\t            return false;\r\n");
      out.write("\t\t        }\r\n");
      out.write("\t\t    } else {\r\n");
      out.write("\t\t        $(\"#qsms\").html(\"Quantity cannot be less than 1\");\r\n");
      out.write("\t\t        return false;\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
