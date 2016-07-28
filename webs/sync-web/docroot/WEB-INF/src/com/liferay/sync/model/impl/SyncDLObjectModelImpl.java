/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.liferay.sync.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.liferay.sync.model.SyncDLObject;
import com.liferay.sync.model.SyncDLObjectModel;
import com.liferay.sync.model.SyncDLObjectSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the SyncDLObject service. Represents a row in the &quot;SyncDLObject&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.sync.model.SyncDLObjectModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SyncDLObjectImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SyncDLObjectImpl
 * @see com.liferay.sync.model.SyncDLObject
 * @see com.liferay.sync.model.SyncDLObjectModel
 * @generated
 */
@JSON(strict = true)
public class SyncDLObjectModelImpl extends BaseModelImpl<SyncDLObject>
	implements SyncDLObjectModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a sync d l object model instance should use the {@link com.liferay.sync.model.SyncDLObject} interface instead.
	 */
	public static final String TABLE_NAME = "SyncDLObject";
	public static final Object[][] TABLE_COLUMNS = {
			{ "syncDLObjectId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createTime", Types.BIGINT },
			{ "modifiedTime", Types.BIGINT },
			{ "repositoryId", Types.BIGINT },
			{ "parentFolderId", Types.BIGINT },
			{ "treePath", Types.VARCHAR },
			{ "name", Types.VARCHAR },
			{ "extension", Types.VARCHAR },
			{ "mimeType", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "changeLog", Types.VARCHAR },
			{ "extraSettings", Types.CLOB },
			{ "version", Types.VARCHAR },
			{ "versionId", Types.BIGINT },
			{ "size_", Types.BIGINT },
			{ "checksum", Types.VARCHAR },
			{ "event", Types.VARCHAR },
			{ "lastPermissionChangeDate", Types.TIMESTAMP },
			{ "lockExpirationDate", Types.TIMESTAMP },
			{ "lockUserId", Types.BIGINT },
			{ "lockUserName", Types.VARCHAR },
			{ "type_", Types.VARCHAR },
			{ "typePK", Types.BIGINT },
			{ "typeUuid", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table SyncDLObject (syncDLObjectId LONG not null primary key,companyId LONG,userId LONG,userName VARCHAR(75) null,createTime LONG,modifiedTime LONG,repositoryId LONG,parentFolderId LONG,treePath STRING null,name VARCHAR(255) null,extension VARCHAR(75) null,mimeType VARCHAR(75) null,description STRING null,changeLog VARCHAR(75) null,extraSettings TEXT null,version VARCHAR(75) null,versionId LONG,size_ LONG,checksum VARCHAR(75) null,event VARCHAR(75) null,lastPermissionChangeDate DATE null,lockExpirationDate DATE null,lockUserId LONG,lockUserName VARCHAR(75) null,type_ VARCHAR(75) null,typePK LONG,typeUuid VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table SyncDLObject";
	public static final String ORDER_BY_JPQL = " ORDER BY syncDLObject.modifiedTime ASC, syncDLObject.repositoryId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY SyncDLObject.modifiedTime ASC, SyncDLObject.repositoryId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.sync.model.SyncDLObject"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.sync.model.SyncDLObject"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.sync.model.SyncDLObject"),
			true);
	public static long EVENT_COLUMN_BITMASK = 1L;
	public static long MODIFIEDTIME_COLUMN_BITMASK = 2L;
	public static long PARENTFOLDERID_COLUMN_BITMASK = 4L;
	public static long REPOSITORYID_COLUMN_BITMASK = 8L;
	public static long TYPE_COLUMN_BITMASK = 16L;
	public static long TYPEPK_COLUMN_BITMASK = 32L;
	public static long VERSION_COLUMN_BITMASK = 64L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static SyncDLObject toModel(SyncDLObjectSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		SyncDLObject model = new SyncDLObjectImpl();

		model.setSyncDLObjectId(soapModel.getSyncDLObjectId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateTime(soapModel.getCreateTime());
		model.setModifiedTime(soapModel.getModifiedTime());
		model.setRepositoryId(soapModel.getRepositoryId());
		model.setParentFolderId(soapModel.getParentFolderId());
		model.setTreePath(soapModel.getTreePath());
		model.setName(soapModel.getName());
		model.setExtension(soapModel.getExtension());
		model.setMimeType(soapModel.getMimeType());
		model.setDescription(soapModel.getDescription());
		model.setChangeLog(soapModel.getChangeLog());
		model.setExtraSettings(soapModel.getExtraSettings());
		model.setVersion(soapModel.getVersion());
		model.setVersionId(soapModel.getVersionId());
		model.setSize(soapModel.getSize());
		model.setChecksum(soapModel.getChecksum());
		model.setEvent(soapModel.getEvent());
		model.setLastPermissionChangeDate(soapModel.getLastPermissionChangeDate());
		model.setLockExpirationDate(soapModel.getLockExpirationDate());
		model.setLockUserId(soapModel.getLockUserId());
		model.setLockUserName(soapModel.getLockUserName());
		model.setType(soapModel.getType());
		model.setTypePK(soapModel.getTypePK());
		model.setTypeUuid(soapModel.getTypeUuid());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<SyncDLObject> toModels(SyncDLObjectSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<SyncDLObject> models = new ArrayList<SyncDLObject>(soapModels.length);

		for (SyncDLObjectSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.sync.model.SyncDLObject"));

	public SyncDLObjectModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _syncDLObjectId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSyncDLObjectId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _syncDLObjectId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return SyncDLObject.class;
	}

	@Override
	public String getModelClassName() {
		return SyncDLObject.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("syncDLObjectId", getSyncDLObjectId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createTime", getCreateTime());
		attributes.put("modifiedTime", getModifiedTime());
		attributes.put("repositoryId", getRepositoryId());
		attributes.put("parentFolderId", getParentFolderId());
		attributes.put("treePath", getTreePath());
		attributes.put("name", getName());
		attributes.put("extension", getExtension());
		attributes.put("mimeType", getMimeType());
		attributes.put("description", getDescription());
		attributes.put("changeLog", getChangeLog());
		attributes.put("extraSettings", getExtraSettings());
		attributes.put("version", getVersion());
		attributes.put("versionId", getVersionId());
		attributes.put("size", getSize());
		attributes.put("checksum", getChecksum());
		attributes.put("event", getEvent());
		attributes.put("lastPermissionChangeDate", getLastPermissionChangeDate());
		attributes.put("lockExpirationDate", getLockExpirationDate());
		attributes.put("lockUserId", getLockUserId());
		attributes.put("lockUserName", getLockUserName());
		attributes.put("type", getType());
		attributes.put("typePK", getTypePK());
		attributes.put("typeUuid", getTypeUuid());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long syncDLObjectId = (Long)attributes.get("syncDLObjectId");

		if (syncDLObjectId != null) {
			setSyncDLObjectId(syncDLObjectId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Long createTime = (Long)attributes.get("createTime");

		if (createTime != null) {
			setCreateTime(createTime);
		}

		Long modifiedTime = (Long)attributes.get("modifiedTime");

		if (modifiedTime != null) {
			setModifiedTime(modifiedTime);
		}

		Long repositoryId = (Long)attributes.get("repositoryId");

		if (repositoryId != null) {
			setRepositoryId(repositoryId);
		}

		Long parentFolderId = (Long)attributes.get("parentFolderId");

		if (parentFolderId != null) {
			setParentFolderId(parentFolderId);
		}

		String treePath = (String)attributes.get("treePath");

		if (treePath != null) {
			setTreePath(treePath);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String extension = (String)attributes.get("extension");

		if (extension != null) {
			setExtension(extension);
		}

		String mimeType = (String)attributes.get("mimeType");

		if (mimeType != null) {
			setMimeType(mimeType);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String changeLog = (String)attributes.get("changeLog");

		if (changeLog != null) {
			setChangeLog(changeLog);
		}

		String extraSettings = (String)attributes.get("extraSettings");

		if (extraSettings != null) {
			setExtraSettings(extraSettings);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		Long versionId = (Long)attributes.get("versionId");

		if (versionId != null) {
			setVersionId(versionId);
		}

		Long size = (Long)attributes.get("size");

		if (size != null) {
			setSize(size);
		}

		String checksum = (String)attributes.get("checksum");

		if (checksum != null) {
			setChecksum(checksum);
		}

		String event = (String)attributes.get("event");

		if (event != null) {
			setEvent(event);
		}

		Date lastPermissionChangeDate = (Date)attributes.get(
				"lastPermissionChangeDate");

		if (lastPermissionChangeDate != null) {
			setLastPermissionChangeDate(lastPermissionChangeDate);
		}

		Date lockExpirationDate = (Date)attributes.get("lockExpirationDate");

		if (lockExpirationDate != null) {
			setLockExpirationDate(lockExpirationDate);
		}

		Long lockUserId = (Long)attributes.get("lockUserId");

		if (lockUserId != null) {
			setLockUserId(lockUserId);
		}

		String lockUserName = (String)attributes.get("lockUserName");

		if (lockUserName != null) {
			setLockUserName(lockUserName);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Long typePK = (Long)attributes.get("typePK");

		if (typePK != null) {
			setTypePK(typePK);
		}

		String typeUuid = (String)attributes.get("typeUuid");

		if (typeUuid != null) {
			setTypeUuid(typeUuid);
		}
	}

	@JSON
	@Override
	public long getSyncDLObjectId() {
		return _syncDLObjectId;
	}

	@Override
	public void setSyncDLObjectId(long syncDLObjectId) {
		_syncDLObjectId = syncDLObjectId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public long getCreateTime() {
		return _createTime;
	}

	@Override
	public void setCreateTime(long createTime) {
		_createTime = createTime;
	}

	@JSON
	@Override
	public long getModifiedTime() {
		return _modifiedTime;
	}

	@Override
	public void setModifiedTime(long modifiedTime) {
		_columnBitmask = -1L;

		if (!_setOriginalModifiedTime) {
			_setOriginalModifiedTime = true;

			_originalModifiedTime = _modifiedTime;
		}

		_modifiedTime = modifiedTime;
	}

	public long getOriginalModifiedTime() {
		return _originalModifiedTime;
	}

	@JSON
	@Override
	public long getRepositoryId() {
		return _repositoryId;
	}

	@Override
	public void setRepositoryId(long repositoryId) {
		_columnBitmask = -1L;

		if (!_setOriginalRepositoryId) {
			_setOriginalRepositoryId = true;

			_originalRepositoryId = _repositoryId;
		}

		_repositoryId = repositoryId;
	}

	public long getOriginalRepositoryId() {
		return _originalRepositoryId;
	}

	@JSON
	@Override
	public long getParentFolderId() {
		return _parentFolderId;
	}

	@Override
	public void setParentFolderId(long parentFolderId) {
		_columnBitmask |= PARENTFOLDERID_COLUMN_BITMASK;

		if (!_setOriginalParentFolderId) {
			_setOriginalParentFolderId = true;

			_originalParentFolderId = _parentFolderId;
		}

		_parentFolderId = parentFolderId;
	}

	public long getOriginalParentFolderId() {
		return _originalParentFolderId;
	}

	@JSON(include = false)
	@Override
	public String getTreePath() {
		if (_treePath == null) {
			return StringPool.BLANK;
		}
		else {
			return _treePath;
		}
	}

	@Override
	public void setTreePath(String treePath) {
		_treePath = treePath;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@JSON
	@Override
	public String getExtension() {
		if (_extension == null) {
			return StringPool.BLANK;
		}
		else {
			return _extension;
		}
	}

	@Override
	public void setExtension(String extension) {
		_extension = extension;
	}

	@JSON
	@Override
	public String getMimeType() {
		if (_mimeType == null) {
			return StringPool.BLANK;
		}
		else {
			return _mimeType;
		}
	}

	@Override
	public void setMimeType(String mimeType) {
		_mimeType = mimeType;
	}

	@JSON
	@Override
	public String getDescription() {
		if (_description == null) {
			return StringPool.BLANK;
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@JSON
	@Override
	public String getChangeLog() {
		if (_changeLog == null) {
			return StringPool.BLANK;
		}
		else {
			return _changeLog;
		}
	}

	@Override
	public void setChangeLog(String changeLog) {
		_changeLog = changeLog;
	}

	@JSON
	@Override
	public String getExtraSettings() {
		if (_extraSettings == null) {
			return StringPool.BLANK;
		}
		else {
			return _extraSettings;
		}
	}

	@Override
	public void setExtraSettings(String extraSettings) {
		_extraSettings = extraSettings;
	}

	@JSON
	@Override
	public String getVersion() {
		if (_version == null) {
			return StringPool.BLANK;
		}
		else {
			return _version;
		}
	}

	@Override
	public void setVersion(String version) {
		_columnBitmask |= VERSION_COLUMN_BITMASK;

		if (_originalVersion == null) {
			_originalVersion = _version;
		}

		_version = version;
	}

	public String getOriginalVersion() {
		return GetterUtil.getString(_originalVersion);
	}

	@JSON
	@Override
	public long getVersionId() {
		return _versionId;
	}

	@Override
	public void setVersionId(long versionId) {
		_versionId = versionId;
	}

	@JSON
	@Override
	public long getSize() {
		return _size;
	}

	@Override
	public void setSize(long size) {
		_size = size;
	}

	@JSON
	@Override
	public String getChecksum() {
		if (_checksum == null) {
			return StringPool.BLANK;
		}
		else {
			return _checksum;
		}
	}

	@Override
	public void setChecksum(String checksum) {
		_checksum = checksum;
	}

	@JSON
	@Override
	public String getEvent() {
		if (_event == null) {
			return StringPool.BLANK;
		}
		else {
			return _event;
		}
	}

	@Override
	public void setEvent(String event) {
		_columnBitmask |= EVENT_COLUMN_BITMASK;

		if (_originalEvent == null) {
			_originalEvent = _event;
		}

		_event = event;
	}

	public String getOriginalEvent() {
		return GetterUtil.getString(_originalEvent);
	}

	@JSON(include = false)
	@Override
	public Date getLastPermissionChangeDate() {
		return _lastPermissionChangeDate;
	}

	@Override
	public void setLastPermissionChangeDate(Date lastPermissionChangeDate) {
		_lastPermissionChangeDate = lastPermissionChangeDate;
	}

	@JSON
	@Override
	public Date getLockExpirationDate() {
		return _lockExpirationDate;
	}

	@Override
	public void setLockExpirationDate(Date lockExpirationDate) {
		_lockExpirationDate = lockExpirationDate;
	}

	@JSON
	@Override
	public long getLockUserId() {
		return _lockUserId;
	}

	@Override
	public void setLockUserId(long lockUserId) {
		_lockUserId = lockUserId;
	}

	@Override
	public String getLockUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getLockUserId(), "uuid", _lockUserUuid);
	}

	@Override
	public void setLockUserUuid(String lockUserUuid) {
		_lockUserUuid = lockUserUuid;
	}

	@JSON
	@Override
	public String getLockUserName() {
		if (_lockUserName == null) {
			return StringPool.BLANK;
		}
		else {
			return _lockUserName;
		}
	}

	@Override
	public void setLockUserName(String lockUserName) {
		_lockUserName = lockUserName;
	}

	@JSON
	@Override
	public String getType() {
		if (_type == null) {
			return StringPool.BLANK;
		}
		else {
			return _type;
		}
	}

	@Override
	public void setType(String type) {
		_columnBitmask |= TYPE_COLUMN_BITMASK;

		if (_originalType == null) {
			_originalType = _type;
		}

		_type = type;
	}

	public String getOriginalType() {
		return GetterUtil.getString(_originalType);
	}

	@JSON
	@Override
	public long getTypePK() {
		return _typePK;
	}

	@Override
	public void setTypePK(long typePK) {
		_columnBitmask |= TYPEPK_COLUMN_BITMASK;

		if (!_setOriginalTypePK) {
			_setOriginalTypePK = true;

			_originalTypePK = _typePK;
		}

		_typePK = typePK;
	}

	public long getOriginalTypePK() {
		return _originalTypePK;
	}

	@JSON
	@Override
	public String getTypeUuid() {
		if (_typeUuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _typeUuid;
		}
	}

	@Override
	public void setTypeUuid(String typeUuid) {
		_typeUuid = typeUuid;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			SyncDLObject.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SyncDLObject toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (SyncDLObject)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SyncDLObjectImpl syncDLObjectImpl = new SyncDLObjectImpl();

		syncDLObjectImpl.setSyncDLObjectId(getSyncDLObjectId());
		syncDLObjectImpl.setCompanyId(getCompanyId());
		syncDLObjectImpl.setUserId(getUserId());
		syncDLObjectImpl.setUserName(getUserName());
		syncDLObjectImpl.setCreateTime(getCreateTime());
		syncDLObjectImpl.setModifiedTime(getModifiedTime());
		syncDLObjectImpl.setRepositoryId(getRepositoryId());
		syncDLObjectImpl.setParentFolderId(getParentFolderId());
		syncDLObjectImpl.setTreePath(getTreePath());
		syncDLObjectImpl.setName(getName());
		syncDLObjectImpl.setExtension(getExtension());
		syncDLObjectImpl.setMimeType(getMimeType());
		syncDLObjectImpl.setDescription(getDescription());
		syncDLObjectImpl.setChangeLog(getChangeLog());
		syncDLObjectImpl.setExtraSettings(getExtraSettings());
		syncDLObjectImpl.setVersion(getVersion());
		syncDLObjectImpl.setVersionId(getVersionId());
		syncDLObjectImpl.setSize(getSize());
		syncDLObjectImpl.setChecksum(getChecksum());
		syncDLObjectImpl.setEvent(getEvent());
		syncDLObjectImpl.setLastPermissionChangeDate(getLastPermissionChangeDate());
		syncDLObjectImpl.setLockExpirationDate(getLockExpirationDate());
		syncDLObjectImpl.setLockUserId(getLockUserId());
		syncDLObjectImpl.setLockUserName(getLockUserName());
		syncDLObjectImpl.setType(getType());
		syncDLObjectImpl.setTypePK(getTypePK());
		syncDLObjectImpl.setTypeUuid(getTypeUuid());

		syncDLObjectImpl.resetOriginalValues();

		return syncDLObjectImpl;
	}

	@Override
	public int compareTo(SyncDLObject syncDLObject) {
		int value = 0;

		if (getModifiedTime() < syncDLObject.getModifiedTime()) {
			value = -1;
		}
		else if (getModifiedTime() > syncDLObject.getModifiedTime()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getRepositoryId() < syncDLObject.getRepositoryId()) {
			value = -1;
		}
		else if (getRepositoryId() > syncDLObject.getRepositoryId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SyncDLObject)) {
			return false;
		}

		SyncDLObject syncDLObject = (SyncDLObject)obj;

		long primaryKey = syncDLObject.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		SyncDLObjectModelImpl syncDLObjectModelImpl = this;

		syncDLObjectModelImpl._originalModifiedTime = syncDLObjectModelImpl._modifiedTime;

		syncDLObjectModelImpl._setOriginalModifiedTime = false;

		syncDLObjectModelImpl._originalRepositoryId = syncDLObjectModelImpl._repositoryId;

		syncDLObjectModelImpl._setOriginalRepositoryId = false;

		syncDLObjectModelImpl._originalParentFolderId = syncDLObjectModelImpl._parentFolderId;

		syncDLObjectModelImpl._setOriginalParentFolderId = false;

		syncDLObjectModelImpl._originalVersion = syncDLObjectModelImpl._version;

		syncDLObjectModelImpl._originalEvent = syncDLObjectModelImpl._event;

		syncDLObjectModelImpl._originalType = syncDLObjectModelImpl._type;

		syncDLObjectModelImpl._originalTypePK = syncDLObjectModelImpl._typePK;

		syncDLObjectModelImpl._setOriginalTypePK = false;

		syncDLObjectModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SyncDLObject> toCacheModel() {
		SyncDLObjectCacheModel syncDLObjectCacheModel = new SyncDLObjectCacheModel();

		syncDLObjectCacheModel.syncDLObjectId = getSyncDLObjectId();

		syncDLObjectCacheModel.companyId = getCompanyId();

		syncDLObjectCacheModel.userId = getUserId();

		syncDLObjectCacheModel.userName = getUserName();

		String userName = syncDLObjectCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			syncDLObjectCacheModel.userName = null;
		}

		syncDLObjectCacheModel.createTime = getCreateTime();

		syncDLObjectCacheModel.modifiedTime = getModifiedTime();

		syncDLObjectCacheModel.repositoryId = getRepositoryId();

		syncDLObjectCacheModel.parentFolderId = getParentFolderId();

		syncDLObjectCacheModel.treePath = getTreePath();

		String treePath = syncDLObjectCacheModel.treePath;

		if ((treePath != null) && (treePath.length() == 0)) {
			syncDLObjectCacheModel.treePath = null;
		}

		syncDLObjectCacheModel.name = getName();

		String name = syncDLObjectCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			syncDLObjectCacheModel.name = null;
		}

		syncDLObjectCacheModel.extension = getExtension();

		String extension = syncDLObjectCacheModel.extension;

		if ((extension != null) && (extension.length() == 0)) {
			syncDLObjectCacheModel.extension = null;
		}

		syncDLObjectCacheModel.mimeType = getMimeType();

		String mimeType = syncDLObjectCacheModel.mimeType;

		if ((mimeType != null) && (mimeType.length() == 0)) {
			syncDLObjectCacheModel.mimeType = null;
		}

		syncDLObjectCacheModel.description = getDescription();

		String description = syncDLObjectCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			syncDLObjectCacheModel.description = null;
		}

		syncDLObjectCacheModel.changeLog = getChangeLog();

		String changeLog = syncDLObjectCacheModel.changeLog;

		if ((changeLog != null) && (changeLog.length() == 0)) {
			syncDLObjectCacheModel.changeLog = null;
		}

		syncDLObjectCacheModel.extraSettings = getExtraSettings();

		String extraSettings = syncDLObjectCacheModel.extraSettings;

		if ((extraSettings != null) && (extraSettings.length() == 0)) {
			syncDLObjectCacheModel.extraSettings = null;
		}

		syncDLObjectCacheModel.version = getVersion();

		String version = syncDLObjectCacheModel.version;

		if ((version != null) && (version.length() == 0)) {
			syncDLObjectCacheModel.version = null;
		}

		syncDLObjectCacheModel.versionId = getVersionId();

		syncDLObjectCacheModel.size = getSize();

		syncDLObjectCacheModel.checksum = getChecksum();

		String checksum = syncDLObjectCacheModel.checksum;

		if ((checksum != null) && (checksum.length() == 0)) {
			syncDLObjectCacheModel.checksum = null;
		}

		syncDLObjectCacheModel.event = getEvent();

		String event = syncDLObjectCacheModel.event;

		if ((event != null) && (event.length() == 0)) {
			syncDLObjectCacheModel.event = null;
		}

		Date lastPermissionChangeDate = getLastPermissionChangeDate();

		if (lastPermissionChangeDate != null) {
			syncDLObjectCacheModel.lastPermissionChangeDate = lastPermissionChangeDate.getTime();
		}
		else {
			syncDLObjectCacheModel.lastPermissionChangeDate = Long.MIN_VALUE;
		}

		Date lockExpirationDate = getLockExpirationDate();

		if (lockExpirationDate != null) {
			syncDLObjectCacheModel.lockExpirationDate = lockExpirationDate.getTime();
		}
		else {
			syncDLObjectCacheModel.lockExpirationDate = Long.MIN_VALUE;
		}

		syncDLObjectCacheModel.lockUserId = getLockUserId();

		syncDLObjectCacheModel.lockUserName = getLockUserName();

		String lockUserName = syncDLObjectCacheModel.lockUserName;

		if ((lockUserName != null) && (lockUserName.length() == 0)) {
			syncDLObjectCacheModel.lockUserName = null;
		}

		syncDLObjectCacheModel.type = getType();

		String type = syncDLObjectCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			syncDLObjectCacheModel.type = null;
		}

		syncDLObjectCacheModel.typePK = getTypePK();

		syncDLObjectCacheModel.typeUuid = getTypeUuid();

		String typeUuid = syncDLObjectCacheModel.typeUuid;

		if ((typeUuid != null) && (typeUuid.length() == 0)) {
			syncDLObjectCacheModel.typeUuid = null;
		}

		return syncDLObjectCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(55);

		sb.append("{syncDLObjectId=");
		sb.append(getSyncDLObjectId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createTime=");
		sb.append(getCreateTime());
		sb.append(", modifiedTime=");
		sb.append(getModifiedTime());
		sb.append(", repositoryId=");
		sb.append(getRepositoryId());
		sb.append(", parentFolderId=");
		sb.append(getParentFolderId());
		sb.append(", treePath=");
		sb.append(getTreePath());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", extension=");
		sb.append(getExtension());
		sb.append(", mimeType=");
		sb.append(getMimeType());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", changeLog=");
		sb.append(getChangeLog());
		sb.append(", extraSettings=");
		sb.append(getExtraSettings());
		sb.append(", version=");
		sb.append(getVersion());
		sb.append(", versionId=");
		sb.append(getVersionId());
		sb.append(", size=");
		sb.append(getSize());
		sb.append(", checksum=");
		sb.append(getChecksum());
		sb.append(", event=");
		sb.append(getEvent());
		sb.append(", lastPermissionChangeDate=");
		sb.append(getLastPermissionChangeDate());
		sb.append(", lockExpirationDate=");
		sb.append(getLockExpirationDate());
		sb.append(", lockUserId=");
		sb.append(getLockUserId());
		sb.append(", lockUserName=");
		sb.append(getLockUserName());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", typePK=");
		sb.append(getTypePK());
		sb.append(", typeUuid=");
		sb.append(getTypeUuid());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(85);

		sb.append("<model><model-name>");
		sb.append("com.liferay.sync.model.SyncDLObject");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>syncDLObjectId</column-name><column-value><![CDATA[");
		sb.append(getSyncDLObjectId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createTime</column-name><column-value><![CDATA[");
		sb.append(getCreateTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedTime</column-name><column-value><![CDATA[");
		sb.append(getModifiedTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>repositoryId</column-name><column-value><![CDATA[");
		sb.append(getRepositoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentFolderId</column-name><column-value><![CDATA[");
		sb.append(getParentFolderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>treePath</column-name><column-value><![CDATA[");
		sb.append(getTreePath());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extension</column-name><column-value><![CDATA[");
		sb.append(getExtension());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mimeType</column-name><column-value><![CDATA[");
		sb.append(getMimeType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>changeLog</column-name><column-value><![CDATA[");
		sb.append(getChangeLog());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extraSettings</column-name><column-value><![CDATA[");
		sb.append(getExtraSettings());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>version</column-name><column-value><![CDATA[");
		sb.append(getVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>versionId</column-name><column-value><![CDATA[");
		sb.append(getVersionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>size</column-name><column-value><![CDATA[");
		sb.append(getSize());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>checksum</column-name><column-value><![CDATA[");
		sb.append(getChecksum());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>event</column-name><column-value><![CDATA[");
		sb.append(getEvent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastPermissionChangeDate</column-name><column-value><![CDATA[");
		sb.append(getLastPermissionChangeDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lockExpirationDate</column-name><column-value><![CDATA[");
		sb.append(getLockExpirationDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lockUserId</column-name><column-value><![CDATA[");
		sb.append(getLockUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lockUserName</column-name><column-value><![CDATA[");
		sb.append(getLockUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typePK</column-name><column-value><![CDATA[");
		sb.append(getTypePK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>typeUuid</column-name><column-value><![CDATA[");
		sb.append(getTypeUuid());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = SyncDLObject.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			SyncDLObject.class
		};
	private long _syncDLObjectId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private long _createTime;
	private long _modifiedTime;
	private long _originalModifiedTime;
	private boolean _setOriginalModifiedTime;
	private long _repositoryId;
	private long _originalRepositoryId;
	private boolean _setOriginalRepositoryId;
	private long _parentFolderId;
	private long _originalParentFolderId;
	private boolean _setOriginalParentFolderId;
	private String _treePath;
	private String _name;
	private String _extension;
	private String _mimeType;
	private String _description;
	private String _changeLog;
	private String _extraSettings;
	private String _version;
	private String _originalVersion;
	private long _versionId;
	private long _size;
	private String _checksum;
	private String _event;
	private String _originalEvent;
	private Date _lastPermissionChangeDate;
	private Date _lockExpirationDate;
	private long _lockUserId;
	private String _lockUserUuid;
	private String _lockUserName;
	private String _type;
	private String _originalType;
	private long _typePK;
	private long _originalTypePK;
	private boolean _setOriginalTypePK;
	private String _typeUuid;
	private long _columnBitmask;
	private SyncDLObject _escapedModel;
}