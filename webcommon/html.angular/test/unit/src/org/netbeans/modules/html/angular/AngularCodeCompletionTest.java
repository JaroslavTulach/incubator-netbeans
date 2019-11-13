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
package org.netbeans.modules.html.angular;

import java.io.File;
import java.util.Collections;
import java.util.Map;
import org.netbeans.api.java.classpath.ClassPath;
import org.netbeans.modules.javascript2.editor.JsCodeCompletionBase;
import static org.netbeans.modules.javascript2.editor.JsTestBase.JS_SOURCE_ID;
import org.netbeans.spi.java.classpath.support.ClassPathSupport;
import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;

/**
 *
 * @author Petr Pisl
 */
public class AngularCodeCompletionTest extends JsCodeCompletionBase {

    public AngularCodeCompletionTest(String testName) {
        super(testName);
    }
    
    public void testControllersProperty_01() throws Exception {
        // TODO it works in ide, not in test now
//        checkCompletion("completion/simpleController/index.html", "                    {{or^}}", false);
    }
    
    @Override
    protected Map<String, ClassPath> createClassPathsForTest() {
        return Collections.singletonMap(
            JS_SOURCE_ID,
            ClassPathSupport.createClassPath(new FileObject[] {
                FileUtil.toFileObject(new File(getDataDir(), "/completion/simpleController"))})
        );
    }
}
