<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
<title>Shop Management System</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="${pageContext.request.contextPath }/css/general.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/css/main.css" rel="stylesheet" type="text/css" />

<style type="text/css">
body {
  color: white;
}
</style>
</head>
<body style="background: #278296">
<center><s:actionerror /></center>
<form method="post" action="${pageContext.request.contextPath }/adminUser_login.action" target="_parent" name='theForm' onsubmit="return validate()">
  <table cellspacing="0" cellpadding="0" style="margin-top: 100px" align="center">
  <tr>
    <td><img src="${pageContext.request.contextPath }/images/admin.png" width="178" height="256" border="0" alt="SHOP" /></td>
    <td style="padding-left: 50px">
      <table>
      <tr>
        <td>Admin name：</td>
        <td><input type="text" name="username" /></td>
      </tr>
      <tr>
        <td>Admin password：</td>
        <td><input type="password" name="password" /></td>
      </tr>
      <tr>
      	<td>
      		&nbsp;
      	</td>
      	<td>
      		<input type="submit" value="Enter" class="button"/>
      	</td>
      </tr>
      </table>
    </td>
  </tr>
  </table>
  <input type="hidden" name="act" value="signin" />
</form>

</body>

</html>