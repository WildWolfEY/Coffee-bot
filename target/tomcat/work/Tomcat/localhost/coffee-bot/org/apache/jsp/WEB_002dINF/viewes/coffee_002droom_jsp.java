/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-11-10 22:16:29 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.viewes;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class coffee_002droom_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <link rel=\"stylesheet\" type=\"text/css\" href=");
      if (_jspx_meth_c_005furl_005f0(_jspx_page_context))
        return;
      out.write("/>\r\n");
      out.write("\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-1.12.4.js\"></script>\r\n");
      out.write("    <script src=\"https://code.jquery.com/ui/1.12.1/jquery-ui.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=");
      if (_jspx_meth_c_005furl_005f1(_jspx_page_context))
        return;
      out.write("></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"wrapper\">\r\n");
      out.write("    <div class=\"content\">\r\n");
      out.write("        <img src=\"resources/images/exit.png\" class='exit' title=\"Выйти из игры. Вас не смогут больше пригласить на кофе\"\r\n");
      out.write("             id=\"btn_exit\"/>\r\n");
      out.write("        <img src=\"resources/images/entrance.jpg\" class='exit' title=\"Войти в игру. Вас снова будут приглашать на кофе\"\r\n");
      out.write("             style=\"display: none\" title=\"Войти в игру\" id=\"btn_entrance\"/>\r\n");
      out.write("\r\n");
      out.write("        <img src=\"resources/images/stick.png\" class='stick'/>\r\n");
      out.write("\r\n");
      out.write("        <div class='stick stick-text'>\r\n");
      out.write("            Не забыть выпить кофе\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class='tab-all'>\r\n");
      out.write("            <div class='tab'>\r\n");
      out.write("                <svg xmlns=\"http://www.w3.org/2000/svg\"\r\n");
      out.write("                     width=\"100%\" height=\"50px\" version='1.1'>\r\n");
      out.write("                    <polygon points=\"50 0,450 0,495 50,15 50\"\r\n");
      out.write("                             style=\"fill:gray;stroke:black;stroke-width:5\"/>\r\n");
      out.write("                </svg>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class='base tab'>\r\n");
      out.write("                <div class='top-panel'>\r\n");
      out.write("                    <div class='button-group'>\r\n");
      out.write("                        <div class='button-settings' value='Люблю говорить' id=\"setting_talk\">\r\n");
      out.write("                            <img class=\"ico\" src=\"https://img.icons8.com/windows/32/000000/voice-presentation.png\"/>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class='button-settings' value='Люблю слушать' id=\"setting_listen\">\r\n");
      out.write("                            <img class=\"ico\"\r\n");
      out.write("                                 src=\"https://img.icons8.com/ios-filled/32/000000/assistive-listening-systems.png\"/>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class='button-settings' value='Общаюсь на деловые темы' id=\"setting_work\">\r\n");
      out.write("                            <img class=\"ico\" src=\"https://img.icons8.com/ios/32/000000/permanent-job.png\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class='button-settings' value='Готов говорить обо всём' id=\"setting_other\">\r\n");
      out.write("                            <img class=\"ico\" src=\"https://img.icons8.com/ios-filled/32/000000/chat.png\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class='display'>\r\n");
      out.write("                        Select some settings, and START\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div>\r\n");
      out.write("                        <div class='drive-group button-stop'>\r\n");
      out.write("                            <div class=\"stop-ico\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class='drive-group button-start'>\r\n");
      out.write("                            <div class=\"start-ico\"></div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class='cooler'>\r\n");
      out.write("                    <!--\t\t<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\" :xlink=\"http://www.w3.org/1999/xlink\">\r\n");
      out.write("                        <defs>\r\n");
      out.write("                         <path id=\"path1\" d=\"M20,20 a1,1 0 0,0 400,0\"/>\r\n");
      out.write("                         <path id=\"path2\" d=\"M20,30 a1,1 0 0,0 100,0\"/>\r\n");
      out.write("                        </defs>\r\n");
      out.write("                        <text style=\"fill:red;\">\r\n");
      out.write("                          <textPath xlink:href=\"#path1\">Open</textPath>\r\n");
      out.write("                         </text>\r\n");
      out.write("                         <text style=\"fill:red;\">\r\n");
      out.write("                          <textPath xlink:href=\"#path2\">Coffee</textPath>\r\n");
      out.write("                         </text>\r\n");
      out.write("                      </svg>\r\n");
      out.write("                      -->\r\n");
      out.write("                </div>\r\n");
      out.write("                <div>\r\n");
      out.write("                    <div class='pip'></div>\r\n");
      out.write("                    <div class='pip'></div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"load\">\r\n");
      out.write("                    <div class=\"coffee\"></div>\r\n");
      out.write("                    <div class=\"coffee\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class='layer-cup'>\r\n");
      out.write("                    <svg xmlns=\"http://www.w3.org/2000/svg\" width=\"100%\" height=\"115px\" version='1.1'>\r\n");
      out.write("                        <defs>\r\n");
      out.write("                            <linearGradient id=\"Gradient1\">\r\n");
      out.write("                                <stop class=\"stop1\" offset=\"0%\"/>\r\n");
      out.write("                                <stop class=\"stop2\" offset=\"50%\"/>\r\n");
      out.write("                                <stop class=\"stop3\" offset=\"100%\"/>\r\n");
      out.write("                            </linearGradient>\r\n");
      out.write("                        </defs>\r\n");
      out.write("                        <path d=\"M160 20 C 100 10, 100 100, 210 100 \" stroke=\"black\" stroke-width=\"1\"\r\n");
      out.write("                              fill=\"transparent\"/>\r\n");
      out.write("                        <path d=\"M160 30 C 110 10, 110 100, 210 93 \" stroke=\"white\" stroke-width=\"10\"\r\n");
      out.write("                              fill=\"transparent\"/>\r\n");
      out.write("                        <path d=\"M163 35 C 115 10, 123 100, 210 83 \" stroke=\"black\" stroke-width=\"1\"\r\n");
      out.write("                              fill=\"transparent\"/>\r\n");
      out.write("\r\n");
      out.write("                        <path d=\"M160 0 C 160 150, 360 150, 360 0 Z\" stroke=\"black\" stroke-width=\"2\" class=\"cup\"/>\r\n");
      out.write("\r\n");
      out.write("                    </svg>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div>\r\n");
      out.write("                <svg xmlns=\"http://www.w3.org/2000/svg\"\r\n");
      out.write("                     width=\"650px\" height=\"100px\" version='1.1'>\r\n");
      out.write("                    <polygon points=\"63 0,545 0,600 50,0 50\"\r\n");
      out.write("                             style=\"fill:gray;stroke:black;stroke-width:5\"/>\r\n");
      out.write("                    <rect x=\"3\" y=\"50\" rx=\"5\" ry=\"5\"\r\n");
      out.write("                          width=\"600\" height=\"20\"\r\n");
      out.write("                          stroke=\"black\" stroke-width=\"5\"\r\n");
      out.write("                          style=\"fill:silver\"/>\r\n");
      out.write("                </svg>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"footer\">\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005furl_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f0.setParent(null);
    // /WEB-INF/viewes/coffee-room.jsp(6,48) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f0.setValue("'resources/css/room.css'");
    int _jspx_eval_c_005furl_005f0 = _jspx_th_c_005furl_005f0.doStartTag();
    if (_jspx_th_c_005furl_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005furl_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_005furl_005f1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_005furl_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005furl_005f1.setParent(null);
    // /WEB-INF/viewes/coffee-room.jsp(10,39) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005furl_005f1.setValue("'resources/js/room.js'");
    int _jspx_eval_c_005furl_005f1 = _jspx_th_c_005furl_005f1.doStartTag();
    if (_jspx_th_c_005furl_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005furl_0026_005fvalue_005fnobody.reuse(_jspx_th_c_005furl_005f1);
    return false;
  }
}
