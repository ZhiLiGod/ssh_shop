package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class top_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody.release();
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
      out.write("<html>\r\n");
      out.write("\t<head>\r\n");
      out.write("\t\t<meta http-equiv=\"Content-Language\" content=\"zh-cn\">\r\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\t\t<style type=\"text/css\">\r\n");
      out.write("BODY {\r\n");
      out.write("\tMARGIN: 0px;\r\n");
      out.write("\tBACKGROUND-COLOR: #ffffff\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("BODY {\r\n");
      out.write("\tFONT-SIZE: 12px;\r\n");
      out.write("\tCOLOR: #000000\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("TD {\r\n");
      out.write("\tFONT-SIZE: 12px;\r\n");
      out.write("\tCOLOR: #000000\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("TH {\r\n");
      out.write("\tFONT-SIZE: 12px;\r\n");
      out.write("\tCOLOR: #000000\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\t\t<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/css/Style.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t</HEAD>\r\n");
      out.write("\t<body>\r\n");
      out.write("\t\t<table width=\"100%\" height=\"70%\"  border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<!-- <td>\r\n");
      out.write("\t\t\t\t\t<img width=\"100%\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/images/top_01.jpg\">\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t -->\r\n");
      out.write("\t\t\t\t<td width=\"100%\" background=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/images/os.jpg\">\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td height=\"30\" valign=\"bottom\" background=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/images/mis_01.jpg\">\r\n");
      out.write("\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td width=\"85%\" align=\"left\">\r\n");
      out.write("\t\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t\t\t\t<font color=\"#000000\"> <script language=\"JavaScript\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\ttmpDate = new Date();\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tdate = tmpDate.getDate();\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmonth= tmpDate.getMonth() + 1 ;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tyear= tmpDate.getFullYear();\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t//alert(year);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tdocument.write(year);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tdocument.write(\"/\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tdocument.write(month);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tdocument.write(\"/\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tdocument.write(date);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tdocument.write(\"/ \");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmyArray=new Array(6);\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmyArray[0]=\"Sunday\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmyArray[1]=\"Monday\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmyArray[2]=\"Tuesday\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmyArray[3]=\"Wednesday\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmyArray[4]=\"Thursday\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmyArray[5]=\"Friday\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tmyArray[6]=\"Saturday\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tweekday=tmpDate.getDay();\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tif (weekday==0 | weekday==6)\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tdocument.write(myArray[weekday])\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\telse\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t{document.write(myArray[weekday])\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t};\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</script> </font>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td width=\"15%\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td width=\"16\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tbackground=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/images/mis_05b.jpg\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<img\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\tsrc=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/images/mis_05a.jpg\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\twidth=\"6\" height=\"18\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td width=\"155\" valign=\"bottom\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tbackground=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/images/mis_05b.jpg\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tUser：\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<font color=\"blue\">");
      if (_jspx_meth_s_005fproperty_005f0(_jspx_page_context))
        return;
      out.write("</font>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<td width=\"18\" valign=\"bottom\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tbackground=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/images/mis_05b.jpg\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/adminUser_logout.action\" target=\"_parent\">Logout</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<!--  <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/images/mis_05c.jpg\" width=\"6\" height=\"18\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t-->\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td align=\"right\" width=\"5%\">\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</body>\r\n");
      out.write("</HTML>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_s_005fproperty_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:property
    org.apache.struts2.views.jsp.PropertyTag _jspx_th_s_005fproperty_005f0 = (org.apache.struts2.views.jsp.PropertyTag) _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.PropertyTag.class);
    _jspx_th_s_005fproperty_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fproperty_005f0.setParent(null);
    // /admin/top.jsp(93,30) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fproperty_005f0.setValue("#session.eu.username");
    int _jspx_eval_s_005fproperty_005f0 = _jspx_th_s_005fproperty_005f0.doStartTag();
    if (_jspx_th_s_005fproperty_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f0);
    return false;
  }
}
