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
package org.netbeans.modules.debugger.jpda.truffle.source;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import org.netbeans.api.java.classpath.ClassPath;
import org.netbeans.api.java.project.JavaProjectConstants;
import org.netbeans.api.java.queries.BinaryForSourceQuery;
import org.netbeans.api.project.FileOwnerQuery;
import org.netbeans.api.project.Project;
import org.netbeans.api.project.ProjectManager;
import org.netbeans.api.project.ProjectUtils;
import org.netbeans.api.project.SourceGroup;
import org.netbeans.api.project.Sources;
import org.netbeans.spi.java.queries.BinaryForSourceQueryImplementation;
import org.netbeans.spi.java.queries.SourceForBinaryQueryImplementation;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.filesystems.URLMapper;

public final class SourceBinaryTranslator {

    private static final String[] SOURCE_IDS = new String[] {JavaProjectConstants.SOURCES_TYPE_RESOURCES, JavaProjectConstants.SOURCES_TYPE_JAVA, JavaProjectConstants.SOURCES_TYPE_MODULES};
    /**
     * Returns a file from binary location, that corresponds to the provided one.
     * If none is found, the provided file's URI is returned.
     */
    public static URI source2Binary(FileObject fileObject) {
        Project project = FileOwnerQuery.getOwner(fileObject);
        if (project != null) {
            BinaryForSourceQueryImplementation binaryForSource = project.getLookup().lookup(BinaryForSourceQueryImplementation.class);
            if (binaryForSource != null) {
                Sources sources = ProjectUtils.getSources(project);
                for (String sourceId : SOURCE_IDS) {
                    SourceGroup[] sourceGroups = sources.getSourceGroups(sourceId);
                    for (SourceGroup sourceGroup : sourceGroups) {
                        FileObject sourceRoot = sourceGroup.getRootFolder();
                        String relativePath = FileUtil.getRelativePath(sourceRoot, fileObject);
                        if (relativePath != null) {
                            BinaryForSourceQuery.Result binaryRoots = binaryForSource.findBinaryRoots(sourceRoot.toURL());
                            if (binaryRoots != null) {
                                URL[] roots = binaryRoots.getRoots();
                                for (URL root : roots) {
                                    FileObject rootFo = URLMapper.findFileObject(root);
                                    if (rootFo != null) {
                                        FileObject binaryFo = rootFo.getFileObject(relativePath);
                                        if (binaryFo != null) {
                                            return binaryFo.toURI();
                                        }
                                    }
                                }
                            }
                            break;
                        }
                    }
                }
            }
        }
        return fileObject.toURI();
    }


    /**
     * Returns a file from source location, that corresponds to the provided one.
     * If none is found, the provided file's URI is returned.
     */
    public static URI binary2Source(URI uri) {
        FileObject fileObject;
        try {
            fileObject = URLMapper.findFileObject(uri.toURL());
        } catch (MalformedURLException ex) {
            return uri;
        }
        if (fileObject != null) {
            Project project = FileOwnerQuery.getOwner(fileObject);
            if (project != null) {
                BinaryForSourceQueryImplementation binaryForSource = project.getLookup().lookup(BinaryForSourceQueryImplementation.class);
                if (binaryForSource != null) {
                    Sources sources = ProjectUtils.getSources(project);
                    for (String sourceId : SOURCE_IDS) {
                        SourceGroup[] sourceGroups = sources.getSourceGroups(sourceId);
                        for (SourceGroup sourceGroup : sourceGroups) {
                            FileObject sourceRoot = sourceGroup.getRootFolder();
                            BinaryForSourceQuery.Result binaryRoots = binaryForSource.findBinaryRoots(sourceRoot.toURL());
                            if (binaryRoots != null) {
                                URL[] roots = binaryRoots.getRoots();
                                for (URL root : roots) {
                                    FileObject rootFo = URLMapper.findFileObject(root);
                                    if (rootFo != null) {
                                        String relativePath = FileUtil.getRelativePath(rootFo, fileObject);
                                        if (relativePath != null) {
                                            FileObject sourceFo = sourceRoot.getFileObject(relativePath);
                                            if (sourceFo != null) {
                                                return sourceFo.toURI();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return uri;
    }
}
