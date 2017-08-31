<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Menu</title>
<link href="${pageContext.request.contextPath}/css/left.css" rel="stylesheet" type="text/css"/>
<link rel="StyleSheet" href="${pageContext.request.contextPath}/css/dtree.css" type="text/css" />
</head>
<body>
<table width="100" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="12"></td>
  </tr>
</table>
<table width="100%" border="0">
  <tr>
    <td>
<div class="dtree">

	<a href="javascript: d.openAll();">Expand</a> | <a href="javascript: d.closeAll();">Close</a>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/dtree.js"></script>
	<script type="text/javascript">
		
		d = new dTree('d');
		d.add('01',-1,'System');
		d.add('0101','01','User Manage','','','mainFrame');
		d.add('010101','0101','User','','','mainFrame');
		d.add('0102','01','First Category','','','mainFrame');
		d.add('010201','0102','First','${pageContext.request.contextPath}/adminCategory_findAll.action','','mainFrame');
		d.add('0103','01','Second Category','','','mainFrame');
		d.add('010301','0103','Second','${pageContext.request.contextPath}/adminCategorySecond_findAllByPage.action?page=1','','mainFrame');
		d.add('0104','01','Product Manage','','','mainFrame');
		d.add('010401','0104','Product','${pageContext.request.contextPath}/adminProduct_findAllByPage.action?page=1','','mainFrame');
		d.add('0105','01','Order','','','mainFrame');
		d.add('010501','0105','All Order','${pageContext.request.contextPath}/adminOrder_findAllByPage.action?page=1','','mainFrame');
		d.add('010502','0105','Unpaid Order','${pageContext.request.contextPath}/adminOrder_findByState.action?page=1&state=1','','mainFrame');
		d.add('010503','0105','Paid Order','${pageContext.request.contextPath}/adminOrder_findByState.action?page=1&state=2','','mainFrame');
		d.add('010504','0105','Delivery','${pageContext.request.contextPath}/adminOrder_findByState.action?page=1&state=3','','mainFrame');
		d.add('010505','0105','Finished','${pageContext.request.contextPath}/adminOrder_findByState.action?page=1&state=4','','mainFrame');
		document.write(d);
		
	</script>
</div>	</td>
  </tr>
</table>
</body>
</html>
