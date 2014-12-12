<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/bl/common/include.jsp"%>
<script type="text/javascript">
$(document).ready(function() {
	$("#pagediv a").each(function() {
		$(this).click(function() {
			var page = new Number($(this).attr('page_to_go'));

			var first = new Number($("#first").attr('page_to_go'));

			var last = new Number($("#last").attr('page_to_go'));
			if (page >= first&& page <= last) {
				location.href = "../b/index.action?page="+ page+ "&pagesize=8&nav=${nav}";
			}
		});
	});
	
});
</script>
</head>
<body style="width: 970px; margin: 0 auto; " >
	 <%@ include file="/bl/common/header.jsp"%>
	<form class="pure-form pure-form-stacked">
		<fieldset>

			<div class="pure-g"  id="query">
				<div class="pure-u-1 pure-u-md-1-4">
					<label for="first-name">名称</label> <input id="first-name"
						type="text">
				</div>

				<div class="pure-u-1 pure-u-md-1-4">
					<label for="last-name">产地</label> <input id="last-name"
						type="text">
				</div>

				<div class="pure-u-1 pure-u-md-1-4">
					<label for="email">仓库</label> <input id="email" type="text">
				</div>
				<div class="pure-u-1 pure-u-md-1-4">
					<label for="email">&nbsp;</label><button type="submit" 
					class="pure-button pure-button-primary">查询</button>
				</div>
			</div>
			
		</fieldset>
		
		<fieldset>
			<div id="main">
			
			<table class="pure-table pure-table-horizontal" width="100%">
			<thead>
				<tr>
					<th>编号</th>
					<th>名称</th>
					<th>仓库名称</th>
					<th>区域</th>
					<th>库存</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${storeList.list}" var="store">
					<tr>
						<td>${store.bl_id}</td>
						<td>${store.bl_name}</td>
						<td>${store.sh_name}</td>
						<td>${store.ss_name}</td>
						<td>${store.bl_store_num}</td>
					</tr>
				</c:forEach>
				<c:if test="${empty storeList}">
					<tr>
						<td colspan="5">暂无数据</td>
					</tr>
				</c:if>
			</tbody>

		</table>
		<div style="margin: 10px; text-align: center;">
			<div id="pagediv" style="width: 100%; background-color: white;">
				<a href="javascript:void(0);" page_to_go='1' id="first">首页</a> 
				<a href="javascript:void(0);" page_to_go="${ list.currs-1}">上一页</a> 
				<a href="javascript:void(0);" page_to_go="${ list.currs+1}">下一页</a> 
				<a href="javascript:void(0);" page_to_go='${ list.pageTotal}' id="last">末页</a> 
				<span>第${ list.currs}页&nbsp; 共${ list.pageTotal}页${list.total }条记录</span>
			</div>

		</div>
		</div>
		</fieldset>
		</form>
		<%@ include file="/bl/common/footer.jsp"%>
</body>
</html>