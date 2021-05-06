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

package org.netbeans.api.maven.impl;

import org.netbeans.modules.maven.spi.actions.AbstractMavenActionsProvider;
import java.io.InputStream;
import org.netbeans.api.maven.MavenActions;
import org.netbeans.api.project.Project;
import org.netbeans.modules.maven.api.NbMavenProject;
import org.netbeans.spi.project.LookupProvider.Registration.ProjectType;
import org.netbeans.spi.project.ProjectServiceProvider;
import org.openide.util.Lookup;

@ProjectServiceProvider(
    service=org.netbeans.modules.maven.spi.actions.MavenActionsProvider.class,
    projectTypes = {
        @ProjectType(
            id="org-netbeans-modules-maven/_any",
            position=663
        )
    }
)
public final class PerProjectActionGoalProvider extends AbstractMavenActionsProvider {
    private final Project project;

    public PerProjectActionGoalProvider(Project project) {
        this.project = project;
    }

    @Override
    protected InputStream getActionDefinitionStream() {
        NbMavenProject maven = project.getLookup().lookup(NbMavenProject.class);
        if (maven == null) {
            return null;
        }
        for (MavenActions info : project.getLookup().lookupAll(MavenActions.class)) {
            if (maven.hasPlugin(info.getPluginIds())) {
                ClassLoader l = Lookup.getDefault().lookup(ClassLoader.class);
                if (l == null) {
                    l = Thread.currentThread().getContextClassLoader();
                }
                if (l == null) {
                    l = info.getClass().getClassLoader();
                }
                
                InputStream is = l.getResourceAsStream(info.getResource());
                if (is == null) {
                    throw new NullPointerException("Cannot find resource " + info.getResource());
                }
                return is;
            }
        }
        return null;
    }
}
