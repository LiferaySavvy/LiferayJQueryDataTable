<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@include file="init.jsp" %>
<script src="<%=renderRequest.getContextPath()%>/js/jquery-1.11.1.min.js"></script>
<script src="<%=renderRequest.getContextPath()%>/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="<%=renderRequest.getContextPath()%>/css/jquery.dataTables.css">
<portlet:resourceURL var="usersArrayURL">
	<portlet:param name="cmd" value="jsonUsersArray"/>
</portlet:resourceURL> 
<style>
.message-container{
 padding:10px;
 margin:2px;
 display:none;
 background: rgba(128, 128, 128, 0.33);
 border: 1px solid #0A0A0C;
 }
</style>
<h2>Jquery Data Table with Array Data from Server Through Ajax</h2>
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
    </table>
 <script>
 $(document).ready(function() {
	    $(document).ready(function() {
	        $('#userTable').dataTable( {
	            "ajax": "<%=usersArrayURL%>"
	        } );
	    } );
	} );
 </script>

 