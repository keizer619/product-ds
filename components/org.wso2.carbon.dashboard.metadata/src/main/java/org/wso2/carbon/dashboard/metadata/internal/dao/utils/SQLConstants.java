/*
 *  Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */
package org.wso2.carbon.dashboard.metadata.internal.dao.utils;

/**
 * Class to define SQL queries and constants
 */
public class SQLConstants {

    public static final String DASHBOARD_UUID = "DASHBOARD_UUID";
    public static final String DASHBOARD_NAME = "DASHBOARD_NAME";
    public static final String DASHBOARD_VERSION = "DASHBOARD_VERSION";
    public static final String DASHBOARD_OWNER = "DASHBOARD_OWNER";
    public static final String DASHBOARD_UPDATEDBY = "DASHBOARD_UPDATEDBY";
    public static final String DASHBOARD_DESCRIPTION = "DASHBOARD_DESCRIPTION";
    public static final String DASHBOARD_SHARED = "DASHBOARD_SHARED";
    public static final String DASHBOARD_CONTENT = "DASHBOARD_CONTENT";
    public static final String DASHBOARD_PARENT_ID = "DASHBOARD_PARENT_ID";
    public static final String DASHBOARD_CREATED_TIME = "DASHBOARD_CREATED_TIME";
    public static final String DASHBOARD_LAST_UPDATED = "DASHBOARD_LAST_UPDATED";


    public static final String ADD_METADATA_QUERY = "INSERT INTO DASHBOARD_RESOURCE (DASHBOARD_UUID, DASHBOARD_NAME, " +
            "DASHBOARD_VERSION, DASHBOARD_OWNER, DASHBOARD_UPDATEDBY, DASHBOARD_DESCRIPTION, DASHBOARD_SHARED, " +
            "DASHBOARD_PARENT_ID , DASHBOARD_CONTENT, DASHBOARD_CREATED_TIME, DASHBOARD_LAST_UPDATED)" +
            " VALUES (?, ?, ?, ?, ?, ?, ?, ? , ?, ?, ?)";

    public static final String UPDATE_METADATA_QUERY = "UPDATE DASHBOARD_RESOURCE SET DASHBOARD_NAME = ?, " +
            "DASHBOARD_VERSION = ?, DASHBOARD_DESCRIPTION = ?,DASHBOARD_OWNER = ?, DASHBOARD_UPDATEDBY= ?, " +
            "DASHBOARD_SHARED = ?, DASHBOARD_LAST_UPDATED = ?, DASHBOARD_CONTENT = ? WHERE DASHBOARD_UUID = ? ";

    public static final String GET_METADATA_QUERY = "SELECT DASHBOARD_UUID, DASHBOARD_NAME, DASHBOARD_VERSION, " +
            "DASHBOARD_OWNER, DASHBOARD_UPDATEDBY, DASHBOARD_DESCRIPTION, DASHBOARD_SHARED, DASHBOARD_PARENT_ID, " +
            "DASHBOARD_CREATED_TIME,DASHBOARD_LAST_UPDATED, DASHBOARD_CONTENT FROM DASHBOARD_RESOURCE " +
            "WHERE DASHBOARD_OWNER = ? AND DASHBOARD_NAME = ? AND DASHBOARD_VERSION = ?";

    public static final String GET_METADATA_BY_UUID = "SELECT DASHBOARD_UUID, DASHBOARD_NAME, DASHBOARD_VERSION, " +
            "DASHBOARD_OWNER, DASHBOARD_UPDATEDBY, DASHBOARD_DESCRIPTION, DASHBOARD_SHARED, DASHBOARD_PARENT_ID," +
            " DASHBOARD_CREATED_TIME,DASHBOARD_LAST_UPDATED, DASHBOARD_CONTENT FROM DASHBOARD_RESOURCE " +
            "WHERE DASHBOARD_UUID = ?";

    public static final String GET_METADATA_BY_OWNER_AND_NAME = "SELECT DASHBOARD_UUID, DASHBOARD_NAME, " +
            "DASHBOARD_VERSION, DASHBOARD_OWNER, DASHBOARD_UPDATEDBY, DASHBOARD_DESCRIPTION, DASHBOARD_SHARED, " +
            "DASHBOARD_PARENT_ID, DASHBOARD_CREATED_TIME,DASHBOARD_LAST_UPDATED, DASHBOARD_CONTENT " +
            "FROM DASHBOARD_RESOURCE WHERE DASHBOARD_OWNER = ? AND DASHBOARD_NAME = ?";

    public static final String GET_METADATA_BY_NAME = "SELECT DASHBOARD_UUID, DASHBOARD_NAME, DASHBOARD_VERSION, " +
            "DASHBOARD_OWNER, DASHBOARD_UPDATEDBY, DASHBOARD_DESCRIPTION, DASHBOARD_SHARED, DASHBOARD_PARENT_ID," +
            " DASHBOARD_CREATED_TIME,DASHBOARD_LAST_UPDATED, DASHBOARD_CONTENT " +
            "FROM DASHBOARD_RESOURCE WHERE DASHBOARD_NAME = ?";

    public static final String DELETE_METADATA_QUERY = "DELETE FROM DASHBOARD_RESOURCE WHERE DASHBOARD_OWNER = ? " +
            "AND DASHBOARD_NAME = ?";

    public static final String DELETE_METADATA_UIID = "DELETE FROM DASHBOARD_RESOURCE WHERE DASHBOARD_UUID = ?";


    public static final String LIST_METADATA_QUERY = "SELECT DASHBOARD_UUID, DASHBOARD_NAME, DASHBOARD_VERSION, " +
            "DASHBOARD_OWNER, DASHBOARD_UPDATEDBY, DASHBOARD_DESCRIPTION, DASHBOARD_SHARED, DASHBOARD_PARENT_ID, " +
            "DASHBOARD_CREATED_TIME,DASHBOARD_LAST_UPDATED, DASHBOARD_CONTENT FROM DASHBOARD_RESOURCE";


    public static final String GET_METADATA_BY_NAME_AND_VERSION = "SELECT DASHBOARD_UUID, DASHBOARD_NAME, " +
            "DASHBOARD_VERSION, DASHBOARD_OWNER, DASHBOARD_UPDATEDBY, DASHBOARD_DESCRIPTION, DASHBOARD_SHARED, " +
            "DASHBOARD_PARENT_ID, DASHBOARD_CREATED_TIME,DASHBOARD_LAST_UPDATED, DASHBOARD_CONTENT " +
            "FROM DASHBOARD_RESOURCE WHERE DASHBOARD_NAME = ? AND DASHBOARD_VERSION = ?";
}
