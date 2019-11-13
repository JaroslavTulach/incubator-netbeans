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
package org.netbeans.modules.web.webkit.tooling.networkmonitor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Window",
        id = "org.netbeans.modules.web.webkit.tooling.networkmonitor.OpenNetworkMonitorAction")
@ActionRegistration(
        displayName = "#CTL_OpenNetworkMonitorAction")
@ActionReference(path = "Menu/Window/Web", position = 400)
@Messages("CTL_OpenNetworkMonitorAction=Network Monitor")
public final class OpenNetworkMonitorAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        NetworkMonitorTopComponent.setReopenNetworkComponent(true);
        NetworkMonitor.reopenNetworkMonitor();
    }
}
