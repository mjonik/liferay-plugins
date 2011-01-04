/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.knowledgebase.admin.action;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;

/**
 * @author Peter Shin
 * @author Brian Wing Shun Chan
 */
public class ConfigurationActionImpl extends DefaultConfigurationAction {

	public void processAction(
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {

		String tabs2 = ParamUtil.getString(actionRequest, "tabs2");

		if (tabs2.equals("article-added-email")) {
			validateEmailArticleAdded(actionRequest);
		}
		else if (tabs2.equals("article-updated-email")) {
			validateEmailArticleUpdated(actionRequest);
		}
		else if (tabs2.equals("email-from")) {
			validateEmailFrom(actionRequest);
		}

		super.processAction(portletConfig, actionRequest, actionResponse);
	}

	protected void validateEmailArticleAdded(ActionRequest actionRequest) {
		String emailArticleAddedSubject = getParameter(
			actionRequest, "emailArticleAddedSubject");
		String emailArticleAddedBody = getParameter(
			actionRequest, "emailArticleAddedBody");

		if (Validator.isNull(emailArticleAddedSubject)) {
			SessionErrors.add(actionRequest, "emailArticleAddedSubject");
		}
		else if (Validator.isNull(emailArticleAddedBody)) {
			SessionErrors.add(actionRequest, "emailArticleAddedBody");
		}
	}

	protected void validateEmailArticleUpdated(ActionRequest actionRequest) {
		String emailArticleUpdatedSubject = getParameter(
			actionRequest, "emailArticleUpdatedSubject");
		String emailArticleUpdatedBody = getParameter(
			actionRequest, "emailArticleUpdatedBody");

		if (Validator.isNull(emailArticleUpdatedSubject)) {
			SessionErrors.add(actionRequest, "emailArticleUpdatedSubject");
		}
		else if (Validator.isNull(emailArticleUpdatedBody)) {
			SessionErrors.add(actionRequest, "emailArticleUpdatedBody");
		}
	}

	protected void validateEmailFrom(ActionRequest actionRequest) {
		String emailFromName = getParameter(actionRequest, "emailFromName");
		String emailFromAddress = getParameter(
			actionRequest, "emailFromAddress");

		if (Validator.isNull(emailFromName)) {
			SessionErrors.add(actionRequest, "emailFromName");
		}
		else if (!Validator.isEmailAddress(emailFromAddress) &&
				 !_isVariableTerm(emailFromAddress)) {

			SessionErrors.add(actionRequest, "emailFromAddress");
		}
	}

	private boolean _isVariableTerm(String s) {
		return (s.contains("[$") && s.contains("$]"));
	}

}