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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wso2.carbon.dashboard.metadata.exception.MetadataException;
import org.wso2.carbon.datasource.core.api.DataSourceService;
import org.wso2.carbon.datasource.core.exception.DataSourceException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Util class to define DB related common operation
 */
public class DAOUtils {

    private static final DAOUtils instance = new DAOUtils();

    private static final Logger log = LoggerFactory.getLogger(DAOUtils.class);

    private static DataSourceService dataSourceService;
    private static DataSource dataSource;


    public DataSource getDataSource(String dataSourceName) throws DataSourceException {

        if (dataSourceService == null) {
            throw new RuntimeException("Datasource service is null. Cannot retrieve data source");
        }
        return (DataSource) dataSourceService.getDataSource(dataSourceName);
    }

    public void setDataSourceService(DataSourceService dataSourceService) {
        this.dataSourceService = dataSourceService;
    }


    private DAOUtils() {
        super();
    }

    public static DAOUtils getInstance() {
        return instance;
    }

    public static void initialize(String dataSourceName) throws MetadataException {
        if (dataSource != null) {
            return;
        }
        try {
            Context ctx = new InitialContext();
            try {
                dataSource = instance.getDataSource(dataSourceName);
            } catch (DataSourceException e) {
                e.printStackTrace();
            }
        } catch (NamingException e) {
            throw new MetadataException("Error while looking up the data source: " + dataSourceName, e);
        }
    }

    public static Connection getConnection() throws SQLException {
        if (dataSource != null) {
            return dataSource.getConnection();
        }
        throw new SQLException("Data source is not configured properly.");
    }

    /**
     * Utility method to close the connection streams.
     *
     * @param preparedStatement PreparedStatement
     * @param connection        Connection
     * @param resultSet         ResultSet
     */
    public static void closeAllConnections(PreparedStatement preparedStatement, Connection connection,
                                           ResultSet resultSet) {
        closeConnection(connection);
        closeResultSet(resultSet);
        closeStatement(preparedStatement);
    }

    /**
     * Close Connection
     *
     * @param dbConnection Connection
     */
    private static void closeConnection(Connection dbConnection) {
        if (dbConnection != null) {
            try {
                dbConnection.close();
            } catch (SQLException e) {
                log.warn("Database error. Could not close database connection. Continuing with " +
                        "others. - " + e.getMessage(), e);
            }
        }
    }

    /**
     * Close ResultSet
     *
     * @param resultSet ResultSet
     */
    private static void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                log.warn("Database error. Could not close ResultSet  - " + e.getMessage(), e);
            }
        }

    }

    /**
     * Close PreparedStatement
     *
     * @param preparedStatement PreparedStatement
     */
    public static void closeStatement(PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                log.warn("Database error. Could not close PreparedStatement. Continuing with" +
                        " others. - " + e.getMessage(), e);
            }
        }

    }
}
