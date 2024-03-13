/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.86
 * Generated at: 2024-03-11 02:17:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.호텔예약;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;

public final class updateForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("java.sql");
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

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>예약 정보 변경</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");

    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:testdb";
    String user = "scott";
    String password = "tiger";
    
    Connection con = null;
    PreparedStatement pstSelect = null;
    PreparedStatement pstUpdate = null;
    ResultSet rs = null;
    
    try {
        Class.forName(driver);
        con = DriverManager.getConnection(url, user, password);
        
        // 사용자가 입력한 예약번호와 손님번호로 예약 정보 조회
        String reservation_id = request.getParameter("reservation_id");
        String customer_id = request.getParameter("customer_id");
        
        pstSelect = con.prepareStatement("SELECT * FROM reservation WHERE reservation_id = ? AND customer_id = ?");
        pstSelect.setString(1, reservation_id);
        pstSelect.setString(2, customer_id);
        rs = pstSelect.executeQuery();
        
        System.out.println(reservation_id + customer_id);
        
        // 조회된 예약 정보를 폼에 출력
        if (rs.next()) {

      out.write("\r\n");
      out.write("<h2>예약 정보 변경</h2>\r\n");
      out.write("<form action=\"updateAction.jsp\" method=\"post\">\r\n");
      out.write("    예약번호: ");
      out.print( rs.getString("reservation_id") );
      out.write("<br>\r\n");
      out.write("    손님번호: ");
      out.print( rs.getString("customer_id") );
      out.write("<br>\r\n");
      out.write("    호실: <input type=\"text\" name=\"room_id\" value=\"");
      out.print( rs.getString("room_id") );
      out.write("\"><br>\r\n");
      out.write("    입실인원 수: <input type=\"text\" name=\"num_of_guest\" value=\"");
      out.print( rs.getInt("num_of_guest") );
      out.write("\"><br>\r\n");
      out.write("    조식여부: <input type=\"text\" name=\"breakfast\" value=\"");
      out.print( rs.getInt("breakfast") );
      out.write("\"><br>\r\n");
      out.write("    체크인 날짜: <input type=\"text\" name=\"check_in_date\" value=\"");
      out.print( rs.getString("check_in_date") );
      out.write("\"><br>\r\n");
      out.write("    체크아웃 날짜: <input type=\"text\" name=\"check_out_date\" value=\"");
      out.print( rs.getString("check_out_date") );
      out.write("\"><br>\r\n");
      out.write("    <input type=hidden name=reservation_id value=\"");
      out.print( rs.getString("reservation_id"));
      out.write("\">\r\n");
      out.write("    <input type=hidden name=customer_id value=\"");
      out.print( rs.getString("customer_id"));
      out.write("\">\r\n");
      out.write("    <input type=\"submit\" value=\"변경\">\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("<form action=\"deleteAction.jsp\" method=\"post\">\r\n");
      out.write("<input type=hidden name=reservation_id value=\"");
      out.print( rs.getString("reservation_id"));
      out.write("\">\r\n");
      out.write("<input type=\"submit\" value=\"예약취소\">\r\n");
      out.write("</form>\r\n");

        } else {
            out.println("해당하는 예약 정보가 없습니다.");
        }
    } catch (Exception e) {
        out.println("오류 발생: " + e.getMessage());
    } finally {
        if (rs != null) rs.close();
        if (pstSelect != null) pstSelect.close();
        if (pstUpdate != null) pstUpdate.close();
        if (con != null) con.close();
    }

      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
