<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="./common/head.jsp"%>
        <div class="right">
            <div class="location">
                <strong>你现在所在的位置是:</strong>
                <span>用户管理页面</span>
            </div>
            <div class="search">
           		<form method="get" action="${pageContext.request.contextPath }/userList.html">				 
					 <span>用户名：</span>
					 <input name="queryname" class="input-text"	type="text" value="${queryUserName }">					 
					 <span>用户角色：</span>
					 <select name="queryUserRole">
						<c:if test="${roleList != null }">
						   <option value="0">--请选择--</option>
						   <c:forEach var="role" items="${roleList}">
						   		<option <c:if test="${role.id == queryUserRole }">selected="selected"</c:if>
						   		value="${role.id}">${role.roleName}</option>
						   </c:forEach>
						</c:if>
	        		</select>
					 <input	value="查 询" type="submit" id="searchbutton">
					 <a href="${pageContext.request.contextPath}/useradd.html" >添加用户</a>
				</form>
            </div>
            <!--用户-->
            <table class="providerTable" cellpadding="0" cellspacing="0">
                <tr class="firstTr">
                    <th width="10%">用户编码</th>
                    <th width="20%">用户名称</th>
                    <th width="10%">性别</th>
                    <th width="10%">年龄</th>
                    <th width="10%">电话</th>
                    <th width="10%">用户角色</th>
                    <th width="30%">操作</th>
                </tr>
                   <c:forEach var="user" items="${pageBean.pageList}" varStatus="status">
					<tr>
						<td>
						<span>${user.userCode }</span>
						</td>
						<td>
						<span>${user.userName }</span>
						</td>
						<td>
							<span>
								<c:if test="${user.gender==1}">男</c:if>
								<c:if test="${user.gender==2}">女</c:if>
							</span>
						</td>
						<td>
						<span>
						<fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd"/>
						</span>
						</td>
						<td>
						<span>${user.phone}</span>
						</td>
						<td>
							<span>${user.userRoleName}</span>
						</td>
						<td>      <%-- href="${pageContext.request.contextPath}/viewUser.html? --%> 
						<span><a class="viewUser" href="javascript:;"  userid=${user.id } ><img src="${pageContext.request.contextPath }/statics/images/read.png" alt="查看" title="查看"/></a></span>
						<span><a   href="${pageContext.request.contextPath}/modifyUser.html?userid=${user.id }"><img src="${pageContext.request.contextPath }/statics/images/xiugai.png" alt="修改" title="修改"/></a></span>
						<span><a class="deleteUser" href="javascript:;" userid=${user.id }><img src="${pageContext.request.contextPath }/statics/images/schu.png" alt="删除" title="删除"/></a></span>
						</td>
					</tr>
				</c:forEach>
			</table>
			<input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
		  	<c:import url="rollpage.jsp">
	          	<c:param name="totalCount" value="${totalCount}"/>
	          	<c:param name="currentPageNo" value="${currentPageNo}"/>
	          	<c:param name="totalPageCount" value="${totalPageCount}"/>
          	</c:import>
          	
          	<p >
					当前页数:[${pageBean.getPageNo()}/${pageBean.getTotalPages()}]&nbsp;
					<a href="${pageContext.request.contextPath}/userList.html?pageNo=1&queryUserRole=${queryUserRole}&queryname=${queryUserName}">首页</a> <a
						href="${pageContext.request.contextPath}/userList.html?pageNo=${pageBean.getPageNo() - 1}&queryUserRole=${queryUserRole}&queryname=${queryUserName} ">上一页</a> <a
						href="${pageContext.request.contextPath}/userList.html?pageNo=${pageBean.getPageNo() + 1}&queryUserRole=${queryUserRole}&queryname=${queryUserName} ">下一页</a> <a
						href="${pageContext.request.contextPath}/userList.html?pageNo=${pageBean.getTotalPages()}&queryUserRole=${queryUserRole}&queryname=${queryUserName} ">末页</a>
				</p>
				<div class="providerAdd">
  <div>
      <label>用户编码:</label>
      <input type="text" id="v_userCode" value="" readonly="readonly">
  </div>
  <div>
      <label>用户名称:</label>
      <input type="text" id="v_userName" value="" readonly="readonly">
  </div>
  <div>
      <label>用户性别:</label>
      <input type="text" id="v_userGender" value="" readonly="readonly">
  </div>
  <div>
      <label>出生日期:</label>
      <input type="text" id="v_userBirthday" class="Wdate" onclick="WdatePickker()" value=" " readonly="readonly">
  </div>
  <div>
      <label>用户电话:</label>
      <input type="text" id="v_userPhone" value="" readonly="readonly">
  </div>
  <div>
      <label>用户地址:</label>
      <input type="text" id="v_userAddress" value="" readonly="readonly">
  </div>
  <div>
      <label>用户角色:</label>
      <input type="text" id="v_userRoleName" value="" readonly="readonly">
  </div>
</div>
        </div>
     </section> 

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该用户吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

<%@include file="./common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/userlist.js"></script>
