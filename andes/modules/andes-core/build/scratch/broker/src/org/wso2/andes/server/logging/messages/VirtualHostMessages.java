/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 *
 */
package org.wso2.andes.server.logging.messages;

import static org.wso2.andes.server.logging.AbstractRootMessageLogger.DEFAULT_LOG_HIERARCHY_PREFIX;

import org.apache.log4j.Logger;
import org.wso2.andes.server.logging.LogMessage;
import org.wso2.andes.server.registry.ApplicationRegistry;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Generated Using GeneratedLogMessages and LogMessages.vm
 *
 * This file is based on the content of LogMessages.properties
 *
 * It is generated so that we can provide compile time validation of the
 * message parameters.
 *
 * DO NOT EDIT DIRECTLY THIS FILE IS GENERATED.
 *
 */
public class VirtualHostMessages
{
    static ResourceBundle _messages;
    static Locale _currentLocale;
    
    public static final String VIRTUALHOST_LOG_HIERARCHY = DEFAULT_LOG_HIERARCHY_PREFIX + "virtualhost";
    public static final String CLOSED_LOG_HIERARCHY = DEFAULT_LOG_HIERARCHY_PREFIX + "virtualhost.closed";
    public static final String STATS_DATA_LOG_HIERARCHY = DEFAULT_LOG_HIERARCHY_PREFIX + "virtualhost.stats_data";
    public static final String STATS_MSGS_LOG_HIERARCHY = DEFAULT_LOG_HIERARCHY_PREFIX + "virtualhost.stats_msgs";
    public static final String CREATED_LOG_HIERARCHY = DEFAULT_LOG_HIERARCHY_PREFIX + "virtualhost.created";

    static
    {
        Logger.getLogger(VIRTUALHOST_LOG_HIERARCHY);
        Logger.getLogger(CLOSED_LOG_HIERARCHY);
        Logger.getLogger(STATS_DATA_LOG_HIERARCHY);
        Logger.getLogger(STATS_MSGS_LOG_HIERARCHY);
        Logger.getLogger(CREATED_LOG_HIERARCHY);

        reload();
    }

    public static void reload()
    {
        if (ApplicationRegistry.isConfigured())
        {
            _currentLocale = ApplicationRegistry.getInstance().getConfiguration().getLocale();
        }
        else
        {
            _currentLocale = Locale.getDefault();
        }

        _messages = ResourceBundle.getBundle("org.wso2.andes.server.logging.messages.VirtualHost_logmessages", _currentLocale);
    }


    /**
     * Log a VirtualHost message of the Format:
     * <pre>VHT-1002 : Closed</pre>
     * Optional values are contained in [square brackets] and are numbered
     * sequentially in the method call.
     *
     */
    public static LogMessage CLOSED()
    {
        String rawMessage = _messages.getString("CLOSED");

        final String message = rawMessage;

        return new LogMessage()
        {
            public String toString()
            {
                return message;
            }
            
            public String getLogHierarchy()
            {
                return CLOSED_LOG_HIERARCHY;
            }
        };
    }

    /**
     * Log a VirtualHost message of the Format:
     * <pre>VHT-1003 : {0} : {1,choice,0#delivered|1#received} : {2,number,#.###} kB/s peak : {3,number,#} bytes total</pre>
     * Optional values are contained in [square brackets] and are numbered
     * sequentially in the method call.
     *
     */
    public static LogMessage STATS_DATA(String param1, Number param2, Number param3, Number param4)
    {
        String rawMessage = _messages.getString("STATS_DATA");

        final Object[] messageArguments = {param1, param2, param3, param4};
        // Create a new MessageFormat to ensure thread safety.
        // Sharing a MessageFormat and using applyPattern is not thread safe
        MessageFormat formatter = new MessageFormat(rawMessage, _currentLocale);

        final String message = formatter.format(messageArguments);

        return new LogMessage()
        {
            public String toString()
            {
                return message;
            }
            
            public String getLogHierarchy()
            {
                return STATS_DATA_LOG_HIERARCHY;
            }
        };
    }

    /**
     * Log a VirtualHost message of the Format:
     * <pre>VHT-1004 : {0} : {1,choice,0#delivered|1#received} : {2,number,#.###} msg/s peak : {3,number,#} msgs total`</pre>
     * Optional values are contained in [square brackets] and are numbered
     * sequentially in the method call.
     *
     */
    public static LogMessage STATS_MSGS(String param1, Number param2, Number param3, Number param4)
    {
        String rawMessage = _messages.getString("STATS_MSGS");

        final Object[] messageArguments = {param1, param2, param3, param4};
        // Create a new MessageFormat to ensure thread safety.
        // Sharing a MessageFormat and using applyPattern is not thread safe
        MessageFormat formatter = new MessageFormat(rawMessage, _currentLocale);

        final String message = formatter.format(messageArguments);

        return new LogMessage()
        {
            public String toString()
            {
                return message;
            }
            
            public String getLogHierarchy()
            {
                return STATS_MSGS_LOG_HIERARCHY;
            }
        };
    }

    /**
     * Log a VirtualHost message of the Format:
     * <pre>VHT-1001 : Created : {0}</pre>
     * Optional values are contained in [square brackets] and are numbered
     * sequentially in the method call.
     *
     */
    public static LogMessage CREATED(String param1)
    {
        String rawMessage = _messages.getString("CREATED");

        final Object[] messageArguments = {param1};
        // Create a new MessageFormat to ensure thread safety.
        // Sharing a MessageFormat and using applyPattern is not thread safe
        MessageFormat formatter = new MessageFormat(rawMessage, _currentLocale);

        final String message = formatter.format(messageArguments);

        return new LogMessage()
        {
            public String toString()
            {
                return message;
            }
            
            public String getLogHierarchy()
            {
                return CREATED_LOG_HIERARCHY;
            }
        };
    }


}
