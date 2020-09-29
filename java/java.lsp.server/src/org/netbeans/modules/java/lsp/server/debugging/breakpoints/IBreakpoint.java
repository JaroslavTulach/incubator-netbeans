/*******************************************************************************
* Copyright (c) 2017 Microsoft Corporation and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*     Microsoft Corporation - initial API and implementation
*******************************************************************************/

package org.netbeans.modules.java.lsp.server.debugging.breakpoints;

import java.util.concurrent.CompletableFuture;
import org.netbeans.api.debugger.Breakpoint;

public interface IBreakpoint extends AutoCloseable {

    Breakpoint getNBBreakpoint();

    String className();

    int getLineNumber();

    int getHitCount();

    void setHitCount(int hitCount);

    CompletableFuture<IBreakpoint> install();

    void putProperty(Object key, Object value);

    Object getProperty(Object key);

    String getCondition();

    void setCondition(String condition);

    String getLogMessage();

    void setLogMessage(String logMessage);
}
