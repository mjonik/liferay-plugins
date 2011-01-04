<%--
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
--%>

<%@ include file="/init.jsp" %>

<%
PortletPreferences preferences = renderRequest.getPreferences();

if (Validator.isNotNull(portletResource)) {
	preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}

String articlesTitle = preferences.getValue("articlesTitle", StringPool.BLANK);
int articlesDelta = GetterUtil.getInteger(preferences.getValue("articlesDelta", StringPool.BLANK), SearchContainer.DEFAULT_DELTA);
String articlesDisplayStyle = preferences.getValue("articlesDisplayStyle", "title");
String articleWindowState = preferences.getValue("articleWindowState", WindowState.MAXIMIZED.toString());
String childArticlesDisplayStyle = preferences.getValue("childArticlesDisplayStyle", "abstract");
boolean enableArticleAssetCategories = GetterUtil.getBoolean(preferences.getValue("enableArticleAssetCategories", null), true);
boolean enableArticleAssetTags = GetterUtil.getBoolean(preferences.getValue("enableArticleAssetTags", null), true);
boolean enableArticleRatings = GetterUtil.getBoolean(preferences.getValue("enableArticleRatings", null));
boolean enableArticleComments = GetterUtil.getBoolean(preferences.getValue("enableArticleComments", null), true);

String selectionMethod = preferences.getValue("selectionMethod", "group");
long[] resourcePrimKeys = GetterUtil.getLongValues(preferences.getValues("resourcePrimKeys", null));

boolean allArticles = GetterUtil.getBoolean(preferences.getValue("allArticles", null), true);
String orderByColumn = preferences.getValue("orderByColumn", "modified-date");
boolean orderByAscending = GetterUtil.getBoolean(preferences.getValue("orderByAscending", null));

boolean assetEntryQueryContains = GetterUtil.getBoolean(preferences.getValue("assetEntryQueryContains", null), true);
boolean assetEntryQueryAndOperator = GetterUtil.getBoolean(preferences.getValue("assetEntryQueryAndOperator", null));
String assetEntryQueryName = preferences.getValue("assetEntryQueryName", "asset-categories");
long[] assetCategoryIds = GetterUtil.getLongValues(preferences.getValues("assetCategoryIds", null));
String[] assetTagNames = preferences.getValues("assetTagNames", new String[0]);

int rssDelta = GetterUtil.getInteger(preferences.getValue("rssDelta", StringPool.BLANK), SearchContainer.DEFAULT_DELTA);
String rssDisplayStyle = preferences.getValue("rssDisplayStyle", RSSUtil.DISPLAY_STYLE_FULL_CONTENT);
String rssFormat = preferences.getValue("rssFormat", "atom10");

String rssFormatType = RSSUtil.getFormatType(rssFormat);
double rssFormatVersion = RSSUtil.getFormatVersion(rssFormat);

OrderByComparator orderByComparator = null;

if (orderByColumn.equals("create-date")) {
	orderByComparator = new ArticleCreateDateComparator(orderByAscending);
}
else if (orderByColumn.equals("modified-date")) {
	orderByComparator = new ArticleModifiedDateComparator(orderByAscending);
}
else if (orderByColumn.equals("priority")) {
	orderByComparator = new ArticlePriorityComparator(orderByAscending);
}
else if (orderByColumn.equals("title")) {
	orderByComparator = new ArticleTitleComparator(orderByAscending);
}

if (articleWindowState.equals(WindowState.MAXIMIZED.toString()) && windowState.equals(WindowState.MAXIMIZED)) {
	PortletURL portletURL = renderResponse.createRenderURL();

	portletURL.setWindowState(WindowState.NORMAL);

	portletDisplay.setURLBack(portletURL.toString());
}
%>