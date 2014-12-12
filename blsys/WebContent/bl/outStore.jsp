<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/bl/common/include.jsp"%>
</head>
<body style="width: 970px; margin: 0 auto; ">
	 <%@ include file="/bl/common/header.jsp"%>
	<form class="pure-form">
		<fieldset>
					<label for="bl_custom_name">客户名称</label> 
					<input type="text" id="bl_custom_name" >
					<input type="hidden" id="bl_custom_id" >
					<button type="button" onclick="$('#chooseCustom').show();$('#customfade').show();" 
						class="pure-button pure-button-primary">选择</button>
					<label for="last-name">&nbsp;</label> 
					<button type="button"  onclick="$('#chooseStore').show();$('#fade').show();" 
						class="pure-button pure-button-primary">添加出库项</button>
		</fieldset>
		<fieldset>
			<div id="main"> 
			<legend>出库明细</legend>
			<table class="pure-table pure-table-horizontal" width="100%"> 
			<thead>
				<tr>
					<th width="20%">名称</th>
					<th width="20%">仓库名称</th>
					<th width="20%">区域</th>
					<th width="10%">数量</th>
					<th width="30%">操作</th>
				</tr>
			</thead>
			<tbody>
						<tr>
							<td>
								<input type="hidden" name="bl_id"/>
								<input id="bl_name" readonly="readonly"/>
							</td>
							<td>
								<input type="hidden" name="sh_id"/>
								<input id="sh_name" readonly="readonly"/>
							</td>
							<td>
								<input type="hidden" name="ss_id"/>
								<input id="ss_name" readonly="readonly"/>
							</td>
							<td>
								<input id="bl_num"/>
								<input id="bl_store_num" type="hidden"/>
							</td>
							<td>
								<button type="button" class="pure-button">删除</button>
							</td>
						</tr>

					</tbody>

		</table>
		<div style="margin:5px;text-align:center;padding:5px;">
			<button type="button" onclick="$('#ddd').jqprint();"
					class="pure-button pure-button-primary">打印</button>
			<button type="button"   
					class="pure-button pure-button-primary">保存</button>	
			<button type="button" 
					class="pure-button pure-button-primary">返回</button>			
		</div>
		</div>
		
		</fieldset>
		
		</form>
		
		<div id="chooseStore" class="popLayer">
			<div style="margin: 5px; text-align: center;">
				<h2>选择出库玻璃</h2>
			</div>
			<table class="pure-table pure-table-horizontal" width="100%">
				<thead>
					<tr>
						<th><input type="checkbox"/></th>
						<th>编号</th>
						<th>名称</th>
						<th>仓库名称</th>
						<th>区域</th>
						<th>库存</th>
						<th>出库数量</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${storeList.list}" var="store" varStatus="s">
						<tr>
							<td>
								<input type="checkbox" name="chk${s.index }"/>
								<input type="hidden" name="sh_${s.index }" value="${store.sh_id }"/>
								<input type="hidden" name="ss_${s.index }" value="${store.ss_id }"/>
							</td>
							<td>${store.bl_id}</td>
							<td>${store.bl_name}</td>
							<td>${store.sh_name}</td>
							<td>${store.ss_name}</td>
							<td>${store.bl_store_num}</td>
							<td><input name="bl_num"/></td>
						</tr>
					</c:forEach>
				</tbody>
	
			</table>
			<div style="margin: 10px; text-align: center;">
				<div id="pagediv" style="width: 100%; background-color: white;">
					<a href="javascript:void(0);" page_to_go='1' id="first">首页</a> 
					<a href="javascript:void(0);" page_to_go="${ storeList.currs-1}">上一页</a> 
					<a href="javascript:void(0);" page_to_go="${ storeList.currs+1}">下一页</a> 
					<a href="javascript:void(0);" page_to_go='${ storeList.pageTotal}' id="last">末页</a> 
					<span>第${ storeList.currs}页&nbsp; 共${ storeList.pageTotal}页${storeList.total }条记录</span>
				</div>
			</div>
			<div style="margin:5px;text-align:center;padding:5px;">
				<button type="button" 
						class="pure-button pure-button-primary">保存</button>
				<button type="button"   onclick="$('#chooseStore').hide();$('#fade').hide();"
						class="pure-button pure-button-primary">取消</button>
			</div>
	</div>
	<div id="chooseCustom" class="popLayer">
		<div style="margin: 5px; text-align: center;">
			<h2>选择客户</h2>
		</div>
		<table class="pure-table pure-table-horizontal" width="100%">
			<thead>
				<tr>
					<th><input type="checkbox"/></th>
					<th>编号</th>
					<th>名称</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${companyList.list}" var="company">
					<tr>
						<td>
							<input type="checkbox" name="chk"/>
						</td>
						<td>${company.com_id}</td>
						<td>${company.com_name}</td>
					</tr>
				</c:forEach>
				<c:if test="${empty companyList.list }">
					<tr>
						<td colspan="3">暂无数据，请维护</td>
					</tr>
				</c:if>
			</tbody>

		</table>
		<div style="margin: 5px; text-align: center;">
			<div id="pagediv" style="width: 100%;">
				<a href="javascript:void(0);" page_to_go='1' id="first">首页</a> 
				<a href="javascript:void(0);" page_to_go="${ companyList.currs-1}">上一页</a> 
				<a href="javascript:void(0);" page_to_go="${ companyList.currs+1}">下一页</a> 
				<a href="javascript:void(0);" page_to_go='${ companyList.pageTotal}' id="last">末页</a> 
				<span>第${ companyList.currs}页&nbsp; 共${ companyList.pageTotal}页${companyList.total }条记录</span>
			</div>

		</div>
		<div style="margin: 5px; text-align: center;">
			<button type="button" class="pure-button pure-button-primary">保存</button>
			<button type="button" class="pure-button pure-button-primary"
				onclick="$('#chooseCustom').hide();$('#customfade').hide();">取消</button>
		</div>
	</div>
		<%@ include file="/bl/common/footer.jsp"%>
		<div id="fade" class="black_overlay"></div> 
		<div id="customfade" class="black_overlay"></div> 
</body>
</html>