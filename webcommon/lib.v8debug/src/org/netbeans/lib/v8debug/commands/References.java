/*
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
 */
package org.netbeans.lib.v8debug.commands;

import org.netbeans.lib.v8debug.V8Arguments;
import org.netbeans.lib.v8debug.V8Body;
import org.netbeans.lib.v8debug.V8Command;
import org.netbeans.lib.v8debug.V8Request;
import org.netbeans.lib.v8debug.vars.V8Value;

/**
 *
 * @author Martin Entlicher
 */
public final class References {
    
    private References() {}
    
    public enum Type {
        referencedBy,
        constructedBy
    }
    
    public static V8Request createRequest(long sequence, Type type, long handle) {
        return new V8Request(sequence, V8Command.References, new Arguments(type, handle));
    }
    
    public static final class Arguments extends V8Arguments {
        
        private final Type type;
        private final long handle;
        
        public Arguments(Type type, long handle) {
            this.type = type;
            this.handle = handle;
        }

        public Type getType() {
            return type;
        }

        public long getHandle() {
            return handle;
        }
    }
    
    public static final class ResponseBody extends V8Body {
        
        private final V8Value[] references;
        
        public ResponseBody(V8Value[] references) {
            this.references = references;
        }

        public V8Value[] getReferences() {
            return references;
        }
    }
}
