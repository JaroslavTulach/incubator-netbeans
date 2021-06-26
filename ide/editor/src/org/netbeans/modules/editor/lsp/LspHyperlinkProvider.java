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
package org.netbeans.modules.editor.lsp;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import javax.swing.text.Document;
import org.netbeans.api.actions.Editable;
import org.netbeans.api.actions.Openable;
import org.netbeans.api.lsp.HyperlinkLocation;
import org.netbeans.lib.editor.hyperlink.spi.HyperlinkProviderExt;
import org.netbeans.lib.editor.hyperlink.spi.HyperlinkType;
import org.openide.filesystems.FileObject;

/** Implemenetation of {@link HyperlinkProviderExt} that delegates to
 * {@link HyperlinkLocation}.
 */
public final class LspHyperlinkProvider implements HyperlinkProviderExt {
    private static final LspHyperlinkProvider INSTANCE = new LspHyperlinkProvider();
    private Reference<Document> lastDocument = new WeakReference<>(null);
    private int lastOffset;
    private List<HyperlinkLocation> lastLocations;

    private LspHyperlinkProvider() {
    }

    public static LspHyperlinkProvider getDefault() {
        return INSTANCE;
    }

    @Override
    public Set<HyperlinkType> getSupportedHyperlinkTypes() {
        return EnumSet.of(HyperlinkType.GO_TO_DECLARATION);
    }

    @Override
    public boolean isHyperlinkPoint(Document doc, int offset, HyperlinkType type) {
        return !findLocations(doc, offset).isEmpty();
    }

    @Override
    public int[] getHyperlinkSpan(Document doc, int offset, HyperlinkType type) {
        List<HyperlinkLocation> locs = findLocations(doc, offset);
        if (locs.isEmpty()) {
            return new int[] { offset, offset };
        } else {
            HyperlinkLocation first = locs.get(0);
            return new int[] { first.getStartOffset(), first.getEndOffset() };
        }
    }

    @Override
    public void performClickAction(Document doc, int offset, HyperlinkType type) {
        for (HyperlinkLocation hl : findLocations(doc, offset)) {
            FileObject fo = hl.getFileObject();
            Editable ed = fo.getLookup().lookup(Editable.class);
            if (ed != null) {
                ed.edit();
                return;
            }
            Openable op = fo.getLookup().lookup(Openable.class);
            if (op != null) {
                op.open();
                return;
            }
        }
    }

    @Override
    public String getTooltipText(Document doc, int offset, HyperlinkType type) {
        return "";
    }

    private List<HyperlinkLocation> findLocations(Document doc, int offset) {
        if (lastOffset == offset && lastDocument.get() == doc) {
            return lastLocations;
        }

        List<HyperlinkLocation> l;
        try {
            l = HyperlinkLocation.resolve(doc, offset).get();
        } catch (InterruptedException | ExecutionException ex) {
            l = Collections.emptyList();
        }

        return lastLocations = l;
    }

}
