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
public class BrokerMessages
{
    static ResourceBundle _messages;
    static Locale _currentLocale;
    
    public static final String BROKER_LOG_HIERARCHY = DEFAULT_LOG_HIERARCHY_PREFIX + "broker";
    public static final String LISTENING_LOG_HIERARCHY = DEFAULT_LOG_HIERARCHY_PREFIX + "broker.listening";
    public static final String LOG_CONFIG_LOG_HIERARCHY = DEFAULT_LOG_HIERARCHY_PREFIX + "broker.log_config";
    public static final String CONFIG_LOG_HIERARCHY = DEFAULT_LOG_HIERARCHY_PREFIX + "broker.config";
    public static final String STATS_DATA_LOG_HIERARCHY = DEFAULT_LOG_HIERARCHY_PREFIX + "broker.stats_data";
    public static final String STOPPED_LOG_HIERARCHY = DEFAULT_LOG_HIERARCHY_PREFIX + "broker.stopped";
    public static final String STATS_MSGS_LOG_HIERARCHY = DEFAULT_LOG_HIERARCHY_PREFIX + "broker.stats_msgs";
    public static final String SHUTTING_DOWN_LOG_HIERARCHY = DEFAULT_LOG_HIERARCHY_PREFIX + "broker.shutting_down";
    public static final String STARTUP_LOG_HIERARCHY = DEFAULT_LOG_HIERARCHY_PREFIX + "broker.startup";
    public static final String READY_LOG_HIERARCHY = DEFAULT_LOG_HIERARCHY_PREFIX + "broker.ready";

    static
    {
        Logger.getLogger(BROKER_LOG_HIERARCHY);
        Logger.getLogger(LISTENING_LOG_HIERARCHY);
        Logger.getLogger(LOG_CONFIG_LOG_HIERARCHY);
        Logger.getLogger(CONFIG_LOG_HIERARCHY);
        Logger.getLogger(STATS_DATA_LOG_HIERARCHY);
        Logger.getLogger(STOPPED_LOG_HIERARCHY);
        Logger.getLogger(STATS_MSGS_LOG_HIERARCHY);
        Logger.getLogger(SHUTTING_DOWN_LOG_HIERARCHY);
        Logger.getLogger(STARTUP_LOG_HIERARCHY);
        Logger.getLogger(READY_LOG_HIERARCHY);

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

        _messages = ResourceBundle.getBundle("org.wso2.andes.server.logging.messages.Broker_logmessages", _currentLocale);
    }


    /**
     * Log a Broker message of the Format:
     * <pre>BRK-1002 : Starting : Listening on {0} port {1,number,#}</pre>
     * Optional values are contained in [square brackets] and are numbered
     * sequentially in the method call.
     *
     */
    public static LogMessage LISTENING(String param1, Number param2)
    {
        String rawMessage = _messages.getString("LISTENING");

        final Object[] messageArguments = {param1, param2};
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
                return LISTENING_LOG_HIERARCHY;
            }
        };
    }

    /**
     * Log a Broker message of the Format:
     * <pre>BRK-1007 : Using logging configuration : {0}</pre>
     * Optional values are contained in [square brackets] and are numbered
     * sequentially in the method call.
     *
     */
    public static LogMessage LOG_CONFIG(String param1)
    {
        String rawMessage = _messages.getString("LOG_CONFIG");

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
                return LOG_CONFIG_LOG_HIERARCHY;
            }
        };
    }

    /**
     * Log a Broker message of the Format:
     * <pre>BRK-1006 : Using configuration : {0}</pre>
     * Optional values are contained in [square brackets] and are numbered
     * sequentially in the method call.
     *
     */
    public static LogMessage CONFIG(String param1)
    {
        String rawMessage = _messages.getString("CONFIG");

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
                return CONFIG_LOG_HIERARCHY;
            }
        };
    }

    /**
     * Log a Broker message of the Format:
     * <pre>BRK-1008 : {0,choice,0#delivered|1#received} : {1,number,#.###} kB/s peak : {2,number,#} bytes total</pre>
     * Optional values are contained in [square brackets] and are numbered
     * sequentially in the method call.
     *
     */
    public static LogMessage STATS_DATA(Number param1, Number param2, Number param3)
    {
        String rawMessage = _messages.getString("STATS_DATA");

        final Object[] messageArguments = {param1, param2, param3};
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
     * Log a Broker message of the Format:
     * <pre>BRK-1005 : Stopped</pre>
     * Optional values are contained in [square brackets] and are numbered
     * sequentially in the method call.
     *
     */
    public static LogMessage STOPPED()
    {
        String rawMessage = _messages.getString("STOPPED");

        final String message = rawMessage;

        return new LogMessage()
        {
            public String toString()
            {
                return message;
            }
            
            public String getLogHierarchy()
            {
                return STOPPED_LOG_HIERARCHY;
            }
        };
    }

    /**
     * Log a Broker message of the Format:
     * <pre>BRK-1009 : {0,choice,0#delivered|1#received} : {1,number,#.###} msg/s peak : {2,number,#} msgs total</pre>
     * Optional values are contained in [square brackets] and are numbered
     * sequentially in the method call.
     *
     */
    public static LogMessage STATS_MSGS(Number param1, Number param2, Number param3)
    {
        String rawMessage = _messages.getString("STATS_MSGS");

        final Object[] messageArguments = {param1, param2, param3};
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
     * Log a Broker message of the Format:
     * <pre>BRK-1003 : Shuting down : {0} port {1,number,#}</pre>
     * Optional values are contained in [square brackets] and are numbered
     * sequentially in the method call.
     *
     */
    public static LogMessage SHUTTING_DOWN(String param1, Number param2)
    {
        String rawMessage = _messages.getString("SHUTTING_DOWN");

        final Object[] messageArguments = {param1, param2};
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
                return SHUTTING_DOWN_LOG_HIERARCHY;
            }
        };
    }

    /**
     * Log a Broker message of the Format:
     * <pre>BRK-1001 : Startup : Version: {0} Build: {1}</pre>
     * Optional values are contained in [square brackets] and are numbered
     * sequentially in the method call.
     *
     */
    public static LogMessage STARTUP(String param1, String param2)
    {
        String rawMessage = _messages.getString("STARTUP");

        final Object[] messageArguments = {param1, param2};
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
                return STARTUP_LOG_HIERARCHY;
            }
        };
    }

    /**
     * Log a Broker message of the Format:
     * <pre>BRK-1004 : Qpid Broker Ready</pre>
     * Optional values are contained in [square brackets] and are numbered
     * sequentially in the method call.
     *
     */
    public static LogMessage READY()
    {
        String rawMessage = _messages.getString("READY");

        final String message = rawMessage;

        return new LogMessage()
        {
            public String toString()
            {
                return message;
            }
            
            public String getLogHierarchy()
            {
                return READY_LOG_HIERARCHY;
            }
        };
    }


}
