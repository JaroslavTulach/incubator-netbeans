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
package org.netbeans.api.maven;

import java.util.Map;
import org.netbeans.spi.project.LookupProvider;
import org.openide.util.Lookup;
import org.openide.util.lookup.Lookups;

public final class MavenActions {

    private final String resource;
    private final String[] pluginIds;

    private MavenActions(String resource, String[] pluginIds) {
        this.resource = resource;
        this.pluginIds = pluginIds;
    }

    public static MavenActions create(String resource, String... pluginIds) {
        return new MavenActions(resource, pluginIds);
    }
    
    private static LookupProvider create(Map<?,?> map) {
        String r = (String) map.get("resource");
        String p = (String) map.get("pluginIds");
        return new LookupProvider() {
            @Override
            public Lookup createAdditionalLookup(Lookup baseContext) {
                return Lookups.fixed(create(r, p.split(",")));
            }
        };
    }
    
    public String getResource() {
        return resource;
    }

    public String[] getPluginIds() {
        return pluginIds;
    }
}
