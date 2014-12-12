<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
	String nav = request.getAttribute("nav").toString();
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	var path = "<%=path %>";
</script>
<link href="<%=path %>/resources/css/pure-min.css" type="text/css"
	rel="stylesheet" />
<link href="<%=path %>/resources/css/grid-min.css" type="text/css"
	rel="stylesheet" />
<link href="<%=path %>/resources/css/common.css" type="text/css"
	rel="stylesheet" />
<script type="text/javascript" src="<%=path %>/resources/js/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="<%=path %>/resources/js/jquery.jqprint-0.3.js"></script>
<script type="text/javascript" src="<%=path %>/resources/js/common.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#main").height($(window).height()-184);
});
</script>