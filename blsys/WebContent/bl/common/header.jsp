<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<div id="demo-horizontal-menu"
		class="pure-menu pure-menu-open pure-menu-horizontal"
		style="background-color: black;" id="header">
		<ul id="std-menu-items">
			<li><img src="<%=path %>/resources/images/mx.jpg"></li>
			<li <c:if test="${nav eq 'store'}">class="pure-menu-selected"</c:if>>
				<a href="###" onclick="toPage('store')">库存</a>
			</li>
			<li <c:if test="${nav eq 'outStore'}">class="pure-menu-selected"</c:if>>
				<a href="###" onclick="toPage('outStore')">出库</a>
			</li>
			<li <c:if test="${nav eq 'inStore'}">class="pure-menu-selected"</c:if>>
				<a href="###" onclick="toPage('inStore')">入库</a>
			</li>
			<li <c:if test="${nav eq 'statistics'}">class="pure-menu-selected"</c:if>>
				<a href="###">统计</a>
			</li>

			<li <c:if test="${nav eq 'property'}">class="pure-menu-selected"</c:if>>
				<a href="###">设置</a>
				<ul>
					<li class="pure-menu-separator"></li>
					<li>用户</li>
					<li>客户</li>
					<li><a href="#">玻璃</a></li>
				</ul>
			</li>
			<li><a href="###">退出</a></li>
			<li>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</li>
			<li>
				<form class="pure-form">
					<input type="text" placeholder="查询库存" />
					<button type="submit" class="pure-button">查询</button>
				</form>
			</li>
		</ul>
	</div>
</html>