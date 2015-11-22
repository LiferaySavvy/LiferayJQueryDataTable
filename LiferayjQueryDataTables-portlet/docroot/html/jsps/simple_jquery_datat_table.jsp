<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@include file="init.jsp" %>
<script src="<%=renderRequest.getContextPath()%>/js/jquery-1.11.1.min.js"></script>
<script src="<%=renderRequest.getContextPath()%>/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="<%=renderRequest.getContextPath()%>/css/jquery.dataTables.css">
<style>
.message-container{
 padding:10px;
 margin:2px;
 display:none;
 background: rgba(128, 128, 128, 0.33);
 border: 1px solid #0A0A0C;
 }
</style>
<h2>Simple Jquery Data Table with Zero Configuration</h2>
<%
List<User> userList=UserLocalServiceUtil.getUsers(-1,-1);
%>
<c:if test="<%=userList!=null&&!userList.isEmpty() %>">
<table id="userTable" class="display" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>User Id</th>
                <th>Screen Name</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email Address</th>
                <th>Job Title</th>
            </tr>
        </thead>
        <tfoot>
            <tr>
                <th>User Id</th>
                <th>Screen Name</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email Address</th>
                <th>Job Title</th>
            </tr>
        </tfoot>
        <tbody>
        <%for(User curUser:userList){ %>
            <tr>
                <td><%=curUser.getUserId()%></td>
                 <td><%=curUser.getScreenName()%></td>
                 <td><%=curUser.getFirstName()%></td>
                 <td><%=curUser.getLastName()%></td>
                 <td><%=curUser.getEmailAddress()%></td>
                 <td><%=curUser.getJobTitle()%></td>
            </tr>
          <%} %>
        </tbody>
    </table>
 <script>
 $(document).ready(function() {
	    $('#userTable').DataTable();
	} );
 </script>
 </c:if>
 <c:if test="<%=Validator.isNull(userList)||userList.isEmpty()%>">
 <div class="message-container">No data to Display</div>
 </c:if>
 