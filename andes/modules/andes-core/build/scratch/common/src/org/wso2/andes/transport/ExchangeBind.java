package org.wso2.andes.transport;
/*
 * 
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * 
 */


import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.wso2.andes.transport.codec.Decoder;
import org.wso2.andes.transport.codec.Encodable;
import org.wso2.andes.transport.codec.Encoder;

import org.wso2.andes.transport.network.Frame;

import org.wso2.andes.util.Strings;




public final class ExchangeBind extends Method {

    public static final int TYPE = 1796;

    public final int getStructType() {
        return TYPE;
    }

    public final int getSizeWidth() {
        return 0;
    }

    public final int getPackWidth() {
        return 2;
    }

    public final boolean hasPayload() {
        return false;
    }

    public final byte getEncodedTrack() {
        return Frame.L4;
    }

    public final boolean isConnectionControl()
    {
        return false;
    }

    private short packing_flags = 0;
    private String queue;
    private String exchange;
    private String bindingKey;
    private Map<String,Object> arguments;


    public ExchangeBind() {}


    public ExchangeBind(String queue, String exchange, String bindingKey, Map<String,Object> arguments, Option ... _options) {
        if(queue != null) {
            setQueue(queue);
        }
        if(exchange != null) {
            setExchange(exchange);
        }
        if(bindingKey != null) {
            setBindingKey(bindingKey);
        }
        if(arguments != null) {
            setArguments(arguments);
        }

        for (int i=0; i < _options.length; i++) {
            switch (_options[i]) {
            case SYNC: this.setSync(true); break;
            case BATCH: this.setBatch(true); break;
            case UNRELIABLE: this.setUnreliable(true); break;
            case NONE: break;
            default: throw new IllegalArgumentException("invalid option: " + _options[i]);
            }
        }

    }

    public <C> void dispatch(C context, MethodDelegate<C> delegate) {
        delegate.exchangeBind(context, this);
    }


    public final boolean hasQueue() {
        return (packing_flags & 256) != 0;
    }

    public final ExchangeBind clearQueue() {
        packing_flags &= ~256;
        this.queue = null;
        this.dirty = true;
        return this;
    }

    public final String getQueue() {
        return queue;
    }

    public final ExchangeBind setQueue(String value) {
        this.queue = value;
        packing_flags |= 256;
        this.dirty = true;
        return this;
    }

    public final ExchangeBind queue(String value) {
        return setQueue(value);
    }

    public final boolean hasExchange() {
        return (packing_flags & 512) != 0;
    }

    public final ExchangeBind clearExchange() {
        packing_flags &= ~512;
        this.exchange = null;
        this.dirty = true;
        return this;
    }

    public final String getExchange() {
        return exchange;
    }

    public final ExchangeBind setExchange(String value) {
        this.exchange = value;
        packing_flags |= 512;
        this.dirty = true;
        return this;
    }

    public final ExchangeBind exchange(String value) {
        return setExchange(value);
    }

    public final boolean hasBindingKey() {
        return (packing_flags & 1024) != 0;
    }

    public final ExchangeBind clearBindingKey() {
        packing_flags &= ~1024;
        this.bindingKey = null;
        this.dirty = true;
        return this;
    }

    public final String getBindingKey() {
        return bindingKey;
    }

    public final ExchangeBind setBindingKey(String value) {
        this.bindingKey = value;
        packing_flags |= 1024;
        this.dirty = true;
        return this;
    }

    public final ExchangeBind bindingKey(String value) {
        return setBindingKey(value);
    }

    public final boolean hasArguments() {
        return (packing_flags & 2048) != 0;
    }

    public final ExchangeBind clearArguments() {
        packing_flags &= ~2048;
        this.arguments = null;
        this.dirty = true;
        return this;
    }

    public final Map<String,Object> getArguments() {
        return arguments;
    }

    public final ExchangeBind setArguments(Map<String,Object> value) {
        this.arguments = value;
        packing_flags |= 2048;
        this.dirty = true;
        return this;
    }

    public final ExchangeBind arguments(Map<String,Object> value) {
        return setArguments(value);
    }




    public void write(Encoder enc)
    {
        enc.writeUint16(packing_flags);
        if ((packing_flags & 256) != 0)
            enc.writeStr8(this.queue);
        if ((packing_flags & 512) != 0)
            enc.writeStr8(this.exchange);
        if ((packing_flags & 1024) != 0)
            enc.writeStr8(this.bindingKey);
        if ((packing_flags & 2048) != 0)
            enc.writeMap(this.arguments);

    }

    public void read(Decoder dec)
    {
        packing_flags = (short) dec.readUint16();
        if ((packing_flags & 256) != 0)
            this.queue = dec.readStr8();
        if ((packing_flags & 512) != 0)
            this.exchange = dec.readStr8();
        if ((packing_flags & 1024) != 0)
            this.bindingKey = dec.readStr8();
        if ((packing_flags & 2048) != 0)
            this.arguments = dec.readMap();

    }

    public Map<String,Object> getFields()
    {
        Map<String,Object> result = new LinkedHashMap<String,Object>();

        if ((packing_flags & 256) != 0)
            result.put("queue", getQueue());
        if ((packing_flags & 512) != 0)
            result.put("exchange", getExchange());
        if ((packing_flags & 1024) != 0)
            result.put("bindingKey", getBindingKey());
        if ((packing_flags & 2048) != 0)
            result.put("arguments", getArguments());


        return result;
    }

}
