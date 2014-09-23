/*
*  Copyright (c) 2005-2010, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
*
*  WSO2 Inc. licenses this file to you under the Apache License,
*  Version 2.0 (the "License"); you may not use this file except
*  in compliance with the License.
*  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/

package org.wso2.carbon.stat.publisher.publisher;

import org.apache.log4j.Logger;
import org.wso2.carbon.stat.publisher.conf.JMXConfiguration;
import org.wso2.carbon.stat.publisher.conf.StatPublisherConfiguration;
import org.wso2.carbon.stat.publisher.conf.StreamConfiguration;
import org.wso2.carbon.stat.publisher.exception.StatPublisherConfigurationException;
import org.wso2.carbon.stat.publisher.exception.StatPublisherRuntimeException;
import org.wso2.carbon.stat.publisher.internal.ds.ServiceValueHolder;
import org.wso2.carbon.stat.publisher.registry.RegistryPersistenceManager;
import org.wso2.carbon.user.api.UserStoreException;
import org.wso2.carbon.user.core.tenant.TenantManager;

import javax.management.*;
import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * StatPublisherObserver create observer Instance for every tenant
 * Stat publishing activation and deactivation methods handle by this class
 */

public class StatPublisherObserver {

    private static final Logger logger = Logger.getLogger(StatPublisherObserver.class);
    private StatPublisherConfiguration statPublisherConfiguration;
    private RegistryPersistenceManager registryPersistenceManager;
    private Timer timer;
    private TimerTask statPublisherTimerTask;
    public StatPublisherDataAgent statPublisherDataAgent;
    private String tenantDomain = null;
    private int tenantID;
    TenantManager tenantManager = ServiceValueHolder.getInstance().getRealmService().getTenantManager();

    public String getTenantDomain() {
        return tenantDomain;
    }

    public StatPublisherObserver(JMXConfiguration jmxConfiguration, StreamConfiguration streamConfiguration,
                                 int tenantID) throws StatPublisherConfigurationException {
        this.tenantID = tenantID;
        registryPersistenceManager = new RegistryPersistenceManager();
        this.statPublisherConfiguration = registryPersistenceManager.loadConfigurationData(tenantID);
        if (statPublisherConfiguration.isSystemStatEnable() || statPublisherConfiguration.isMbStatEnable() || statPublisherConfiguration.isMessageStatEnable()) {
            statPublisherDataAgent =
                    new StatPublisherDataAgent(jmxConfiguration, streamConfiguration, statPublisherConfiguration);
        }

    }

    /**
     * Start periodical statistic Publishing using timer task
     * activate publishing after read registry configurations
     */
    public void startMonitor() throws UserStoreException {

        if (statPublisherConfiguration.isMessageStatEnable()) {
            tenantDomain = tenantManager.getDomain(tenantID);
        }

        //Checking  System or MB stat enable or not
        if (statPublisherConfiguration.isSystemStatEnable() || statPublisherConfiguration.isMbStatEnable()) {

            statPublisherTimerTask = new TimerTask() {
                @Override
                public void run() {
                    //check system stat enable configuration
                    if (statPublisherConfiguration.isSystemStatEnable()) {
                        //System stat publishing activated
                        try {
                            statPublisherDataAgent.sendSystemStats();
                        } catch (MalformedObjectNameException e) {
                         throw new StatPublisherRuntimeException(e);
                        } catch (ReflectionException e) {
                            throw new StatPublisherRuntimeException(e);
                        } catch (IOException e) {
                            throw new StatPublisherRuntimeException(e);
                        } catch (InstanceNotFoundException e) {
                            throw new StatPublisherRuntimeException(e);
                        } catch (AttributeNotFoundException e) {
                            throw new StatPublisherRuntimeException(e);
                        } catch (MBeanException e) {
                            throw new StatPublisherRuntimeException(e);
                        }
                        logger.info("System stat Publishing activated ");
                    }
                    //check MB stat enable configuration
                    if (statPublisherConfiguration.isMbStatEnable()) {
                        try {
                            statPublisherDataAgent.sendMBStats();
                        } catch (MalformedObjectNameException e) {
                            throw new StatPublisherRuntimeException(e);
                        } catch (ReflectionException e) {
                            throw new StatPublisherRuntimeException(e);
                        } catch (IOException e) {
                            throw new StatPublisherRuntimeException(e);
                        } catch (InstanceNotFoundException e) {
                            throw new StatPublisherRuntimeException(e);
                        } catch (AttributeNotFoundException e) {
                            throw new StatPublisherRuntimeException(e);
                        } catch (MBeanException e) {
                            throw new StatPublisherRuntimeException(e);
                        }

                        logger.info("MB stat Publishing activated ");
                    }
                }


            };
            timer = new Timer();
            // scheduling the task at fixed rate
            Thread timerTaskThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    long timeInterval = 15000;
                    timer.scheduleAtFixedRate(statPublisherTimerTask, new Date(), timeInterval);
                }
            });
            timerTaskThread.start();
        }
    }

    /**
     * Stop periodical statistic Publishing uby stopping timer task
     */
    public void stopMonitor() {
        if (timer != null) {
            timer.cancel();
        }
    }

    public StatPublisherConfiguration getStatPublisherConfiguration() {
        return statPublisherConfiguration;
    }
}
