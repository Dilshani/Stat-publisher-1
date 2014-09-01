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
package org.wso2.andes;

/**
 * AMQPInvalidClassException indicates an error when trying to store an illegally typed argument in a field table.
 *
 * <p/><table id="crc"><caption>CRC Card</caption>
 * <tr><th> Responsibilities <th> Collaborations
 * <tr><td> Represents illegal argument type for field table values.
 * </table>
 *
 * @todo Could just re-use an exising exception like IllegalArgumentException or ClassCastException.
 */
public class AMQPInvalidClassException extends RuntimeException
{
    /** Error message text when trying to store an unsupported class or null object */
    public static final String INVALID_OBJECT_MSG = "Only Primitive objects allowed. Object is: ";
    
    public AMQPInvalidClassException(String s)
    {
        super(s);
    }
}
