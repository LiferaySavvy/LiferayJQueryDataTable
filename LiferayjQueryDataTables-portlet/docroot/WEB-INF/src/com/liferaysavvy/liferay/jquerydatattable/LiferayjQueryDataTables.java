package com.liferaysavvy.liferay.jquerydatattable;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.PortletConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class LiferayjQueryDataTables
 */
public class LiferayjQueryDataTables extends MVCPortlet {
		private com.liferay.portal.kernel.log.Log logger = LogFactoryUtil
				.getLog(LiferayjQueryDataTables.class);
		@Override
		public void serveResource(ResourceRequest resourceRequest,
				ResourceResponse resourceResponse) throws IOException,
				PortletException {
			String cmdString=ParamUtil.getString(resourceRequest,"cmd",null);
			try {
				if(cmdString!=null&&cmdString.equalsIgnoreCase("jsonUserObjectArray")){
					arrayOfJSONUserObjects( resourceRequest, resourceResponse);
				}
				if(cmdString!=null&&cmdString.equalsIgnoreCase("jsonUsersArray")){
					arrayOfJSONUserData( resourceRequest, resourceResponse);
				}
				if(cmdString!=null&&cmdString.equalsIgnoreCase("flatDataSource")){
					flatDataSource( resourceRequest, resourceResponse);
				}
				if(cmdString!=null&&cmdString.equalsIgnoreCase("customDataProperty")){
					customDataObjects( resourceRequest, resourceResponse);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public void arrayOfJSONUserObjects(ResourceRequest resourceRequest,
				ResourceResponse resourceResponse) throws IOException,
				PortletException {
			JSONArray usersJsonArray = JSONFactoryUtil.createJSONArray();
			try {
				logger.info("====serveResource========");
				JSONObject jsonUser = null;
				
				List<User> userList = UserLocalServiceUtil.getUsers(1,UserLocalServiceUtil.getUsersCount());
				for (User userObj : userList) {
					jsonUser = JSONFactoryUtil.createJSONObject();
					jsonUser.put("userId", userObj.getUserId());
					jsonUser.put("screeName", userObj.getScreenName());
					jsonUser.put("firstName", userObj.getFirstName());
					jsonUser.put("lastName", userObj.getLastName());
					jsonUser.put("email", userObj.getEmailAddress());
					jsonUser.put("jobTitle", userObj.getJobTitle());
					usersJsonArray.put(jsonUser);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			JSONObject tableData = JSONFactoryUtil.createJSONObject();
			tableData.put("data", usersJsonArray);
			logger.info("tableData:"+tableData.toString());
			ServletResponseUtil.write(PortalUtil.getHttpServletResponse(resourceResponse),tableData.toString());
		}
		public void arrayOfJSONUserData(ResourceRequest resourceRequest,
				ResourceResponse resourceResponse) throws IOException,
				PortletException {
			JSONArray allUsersJsonArray = JSONFactoryUtil.createJSONArray();
			try {
				logger.info("====serveResource========");
				JSONArray jsonUserArray = null;
				
				List<User> userList = UserLocalServiceUtil.getUsers(1,UserLocalServiceUtil.getUsersCount());
				for (User userObj : userList) {
					jsonUserArray = JSONFactoryUtil.createJSONArray();
					jsonUserArray.put(userObj.getUserId());
					jsonUserArray.put( userObj.getScreenName());
					jsonUserArray.put(userObj.getFirstName());
					jsonUserArray.put(userObj.getLastName());
					jsonUserArray.put(userObj.getEmailAddress());
					jsonUserArray.put(userObj.getJobTitle());
					allUsersJsonArray.put(jsonUserArray);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			JSONObject tableData = JSONFactoryUtil.createJSONObject();
			tableData.put("data", allUsersJsonArray);
			logger.info("tableData:"+tableData.toString());
			ServletResponseUtil.write(PortalUtil.getHttpServletResponse(resourceResponse),tableData.toString());
		}
		public void flatDataSource(ResourceRequest resourceRequest,
				ResourceResponse resourceResponse) throws IOException,
				PortletException {
			JSONArray usersJsonArray = JSONFactoryUtil.createJSONArray();
			try {
				logger.info("====serveResource========");
				JSONObject jsonUser = null;
				
				List<User> userList = UserLocalServiceUtil.getUsers(1,UserLocalServiceUtil.getUsersCount());
				for (User userObj : userList) {
					jsonUser = JSONFactoryUtil.createJSONObject();
					jsonUser.put("userId", userObj.getUserId());
					jsonUser.put("screeName", userObj.getScreenName());
					jsonUser.put("firstName", userObj.getFirstName());
					jsonUser.put("lastName", userObj.getLastName());
					jsonUser.put("email", userObj.getEmailAddress());
					jsonUser.put("jobTitle", userObj.getJobTitle());
					usersJsonArray.put(jsonUser);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			logger.info("tableData:"+usersJsonArray.toString());
			ServletResponseUtil.write(PortalUtil.getHttpServletResponse(resourceResponse),usersJsonArray.toString());
		}
		public void customDataObjects(ResourceRequest resourceRequest,
				ResourceResponse resourceResponse) throws IOException,
				PortletException {
			JSONArray usersJsonArray = JSONFactoryUtil.createJSONArray();
			try {
				logger.info("====serveResource========");
				JSONObject jsonUser = null;
				
				List<User> userList = UserLocalServiceUtil.getUsers(1,UserLocalServiceUtil.getUsersCount());
				for (User userObj : userList) {
					jsonUser = JSONFactoryUtil.createJSONObject();
					jsonUser.put("userId", userObj.getUserId());
					jsonUser.put("screeName", userObj.getScreenName());
					jsonUser.put("firstName", userObj.getFirstName());
					jsonUser.put("lastName", userObj.getLastName());
					jsonUser.put("email", userObj.getEmailAddress());
					jsonUser.put("jobTitle", userObj.getJobTitle());
					usersJsonArray.put(jsonUser);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			JSONObject tableData = JSONFactoryUtil.createJSONObject();
			tableData.put("mytabledata", usersJsonArray);
			logger.info("tableData:"+tableData.toString());
			ServletResponseUtil.write(PortalUtil.getHttpServletResponse(resourceResponse),tableData.toString());
		}
	}
