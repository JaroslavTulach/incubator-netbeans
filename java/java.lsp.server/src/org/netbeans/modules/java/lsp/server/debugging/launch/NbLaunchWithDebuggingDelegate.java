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
package org.netbeans.modules.java.lsp.server.debugging.launch;

import java.util.Map;
import org.netbeans.modules.java.lsp.server.debugging.DebugAdapterContext;


/**
 *
 * @author martin
 */
public class NbLaunchWithDebuggingDelegate extends NbLaunchDelegate {

    @Override
    public void postLaunch(Map<String, Object> launchArguments, DebugAdapterContext context) {
        // context.getTreadsProvider().initialize(context, Collections.emptyMap());
        // send an InitializedEvent to indicate that the debugger is ready to accept
        // configuration requests (e.g. SetBreakpointsRequest, SetExceptionBreakpointsRequest).
        context.getClient().initialized();
    }

    @Override
    public void preLaunch(Map<String, Object> launchArguments, DebugAdapterContext context) {
        // debug only
        context.setAttached(false);
        context.setSourcePaths((String[])launchArguments.get("sourcePaths"));
        context.setVmStopOnEntry((Boolean)launchArguments.get("stopOnEntry"));
        // context.setMainClass(LaunchRequestHandler.parseMainClassWithoutModuleName(launchArguments.get("mainClass")));
// TODO:        context.setStepFilters(launchArguments.get("stepFilters"));
    }
}
