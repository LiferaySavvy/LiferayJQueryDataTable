<%@include file="init.jsp" %>
<portlet:renderURL var="simpleJqueryDataTableURL">
	<portlet:param name="mvcPath" value="/html/jsps/simple_jquery_datat_table.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="ajaxbleDataTableURL">
	<portlet:param name="mvcPath" value="/html/jsps/ajax_jquery_datat_table.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="ajaxbleDataTableUsersArrayURL">
	<portlet:param name="mvcPath" value="/html/jsps/ajax_jquery_array_datat_table.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="ajaxbleDataTableUsersFlatDataURL">
	<portlet:param name="mvcPath" value="/html/jsps/ajax_jquery_flat_data_source_datat_table.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="ajaxbleDataTableUsersCustomDataURL">
	<portlet:param name="mvcPath" value="/html/jsps/ajax_jquery_custom_data_object_datat_table.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="hiddenDataTableColumnsURL">
	<portlet:param name="mvcPath" value="/html/jsps/hidden_columns_ajax_jquery_datat_table.jsp"/>
</portlet:renderURL>
            <a href="<%=simpleJqueryDataTableURL%>">Simple Jquery DataTable</a><br/>
            <a href="<%=ajaxbleDataTableURL%>">Ajax Based Data Table with Array of Objects data</a><br/>
            <a href="<%=ajaxbleDataTableUsersArrayURL%>">Ajax Based Data Table with Array data</a><br/>
            <a href="<%=ajaxbleDataTableUsersFlatDataURL%>">Ajax Based Data Table with Flat data</a><br/>
            <a href="<%=ajaxbleDataTableUsersCustomDataURL%>">Ajax Based Data Table with Custom data source property</a><br/>
            <a href="<%=hiddenDataTableColumnsURL%>">Hidden Data Table Columns</a><br/>
           <%--  <a href="<%=listUsersSearchContainerURL%>">Users Search Container</a><br/>
             <a href="<%=viewUserRigistrationURL%>">User Registration</a><br/> --%>
        	