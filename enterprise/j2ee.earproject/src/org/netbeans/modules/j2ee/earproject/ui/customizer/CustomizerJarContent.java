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

package org.netbeans.modules.j2ee.earproject.ui.customizer;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import org.netbeans.api.java.project.JavaProjectConstants;
import org.netbeans.modules.j2ee.api.ejbjar.EjbProjectConstants;
import org.netbeans.modules.javaee.project.api.ui.utils.UIUtil;
import org.netbeans.modules.java.api.common.classpath.ClassPathSupport;
import org.netbeans.modules.java.api.common.classpath.ClassPathSupport.Item;
import org.netbeans.modules.java.api.common.project.ui.ClassPathUiSupport;
import org.netbeans.modules.java.api.common.project.ui.customizer.EditMediator;
import org.netbeans.modules.j2ee.deployment.devmodules.api.J2eePlatform;
import org.netbeans.modules.j2ee.earproject.classpath.ClassPathSupportCallbackImpl;
import org.openide.util.HelpCtx;
import org.openide.util.NbBundle;

/**
 * Customizer for Enterprise Application packaging.
 */
public class CustomizerJarContent extends JPanel implements HelpCtx.Provider {
    private static final long serialVersionUID = 1L;
    
    private final EarProjectProperties uiProperties;
    
    public CustomizerJarContent(EarProjectProperties earProperties) {
        this.uiProperties = earProperties;
        initComponents();
        this.getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(CustomizerJarContent.class, "ACS_CustomizeEAR_A11YDesc"));
        
        jTextFieldFileName.setDocument(uiProperties.ARCHIVE_NAME_MODEL);
        jTextFieldExContent.setDocument( uiProperties.BUILD_CLASSES_EXCLUDES_MODEL );
        uiProperties.ARCHIVE_COMPRESS_MODEL.setMnemonic( jCheckBoxCompress.getMnemonic() );
        jCheckBoxCompress.setModel( uiProperties.ARCHIVE_COMPRESS_MODEL );
        ClassPathUiSupport.Callback callback = new ClassPathUiSupport.Callback() {
            public void initItem(Item item) {
                if (item.getType() != ClassPathSupport.Item.TYPE_LIBRARY || !item.getLibrary().getType().equals(J2eePlatform.LIBRARY_TYPE)) {
                    item.setAdditionalProperty(ClassPathSupportCallbackImpl.PATH_IN_DEPLOYMENT, "/"); //NOI18N
                }
            }
        };
        EditMediator.register( uiProperties.getProject(),
                uiProperties.getProject().getAntProjectHelper(),
                uiProperties.getProject().getReferenceHelper(),
                EditMediator.createListComponent(jTableAddContent, uiProperties.EAR_CONTENT_ADDITIONAL_MODEL.getDefaultListModel()) , 
                jButtonAddJar.getModel(),
                jButtonAddLib.getModel(),
                jButtonAddProject.getModel(),
                jButtonRemove.getModel(),
                (new JButton()).getModel(), // no button in UI
                (new JButton()).getModel(), // no button in UI
                (new JButton()).getModel(), // no button in UI
                uiProperties.SHARED_LIBRARIES_MODEL,
                callback,
                new String[]{EjbProjectConstants.ARTIFACT_TYPE_J2EE_MODULE_IN_EAR_ARCHIVE, JavaProjectConstants.ARTIFACT_TYPE_JAR},
                null, JFileChooser.FILES_ONLY);
        jTableAddContent.setModel( uiProperties.EAR_CONTENT_ADDITIONAL_MODEL);
        jTableAddContent.setDefaultRenderer(ClassPathSupport.Item.class, uiProperties.CLASS_PATH_TABLE_RENDERER);
        UIUtil.initTwoColumnTableVisualProperties(this, jTableAddContent);
        jTableAddContent.setRowHeight(jTableAddContent.getRowHeight() + 4);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxCompress = new javax.swing.JCheckBox();
        jLabelExContent = new javax.swing.JLabel();
        jLabelAddContent = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableAddContent = new javax.swing.JTable();
        jButtonAddJar = new javax.swing.JButton();
        jButtonAddLib = new javax.swing.JButton();
        jButtonAddProject = new javax.swing.JButton();
        jButtonRemove = new javax.swing.JButton();
        jTextFieldFileName = new javax.swing.JTextField();
        jLabelFileName = new javax.swing.JLabel();
        jLabelExContent1 = new javax.swing.JLabel();
        jTextFieldExContent = new javax.swing.JTextField();

        org.openide.awt.Mnemonics.setLocalizedText(jCheckBoxCompress, NbBundle.getMessage(CustomizerJarContent.class, "LBL_CustomizeEAR_Commpres_JCheckBox")); // NOI18N
        jCheckBoxCompress.setMargin(new java.awt.Insets(0, 0, 0, 0));

        org.openide.awt.Mnemonics.setLocalizedText(jLabelExContent, NbBundle.getMessage(CustomizerJarContent.class, "LBL_CustomizeEAR_Content_JLabel")); // NOI18N

        jLabelAddContent.setLabelFor(jTableAddContent);
        org.openide.awt.Mnemonics.setLocalizedText(jLabelAddContent, NbBundle.getMessage(CustomizerJarContent.class, "LBL_CustomizeEAR_AddContent_JLabel")); // NOI18N

        jTableAddContent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTableAddContent);
        jTableAddContent.getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(CustomizerJarContent.class, "LBL_AACH_ProjectJarFiles_JLabel")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButtonAddJar, NbBundle.getMessage(CustomizerJarContent.class, "LBL_CustomizeEAR_AddJar_JButton")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButtonAddLib, NbBundle.getMessage(CustomizerJarContent.class, "LBL_CustomizeEAR_AddLib_JButton")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButtonAddProject, NbBundle.getMessage(CustomizerJarContent.class, "LBL_CustomizeEAR_AddProject_JButton")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jButtonRemove, NbBundle.getMessage(CustomizerJarContent.class, "LBL_CustomizeEAR_Remove_JButton")); // NOI18N

        jTextFieldFileName.setEditable(false);

        jLabelFileName.setLabelFor(jTextFieldFileName);
        org.openide.awt.Mnemonics.setLocalizedText(jLabelFileName, NbBundle.getMessage(CustomizerJarContent.class, "LBL_CustomizeEAR_FileName_JLabel")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabelExContent1, NbBundle.getMessage(CustomizerJarContent.class, "LBL_CustomizeEAR_Content_Comment_JLabel")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBoxCompress)
                    .addComponent(jLabelAddContent)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButtonAddProject, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonAddLib, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonAddJar, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelExContent)
                                .addComponent(jLabelFileName))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTextFieldFileName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                                .addComponent(jLabelExContent1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldExContent, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFileName)
                    .addComponent(jTextFieldFileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelExContent)
                    .addComponent(jTextFieldExContent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelExContent1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBoxCompress)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelAddContent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonAddProject)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAddLib)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAddJar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonRemove)
                        .addContainerGap())
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)))
        );

        jCheckBoxCompress.getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(CustomizerJarContent.class, "ACS_CustomizeEAR_Commpres_A11YDesc")); // NOI18N
        jButtonAddJar.getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(CustomizerJarContent.class, "ACS_CustomizeEAR_AddJar_A11YDesc")); // NOI18N
        jButtonAddLib.getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(CustomizerJarContent.class, "ACS_CustomizeEAR_AddLib_A11YDesc")); // NOI18N
        jButtonAddProject.getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(CustomizerJarContent.class, "ACS_CustomizeEAR_AddProject_A11YDesc")); // NOI18N
        jButtonRemove.getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(CustomizerJarContent.class, "ACS_CustomizeEAR_AdditionalRemove_A11YDesc")); // NOI18N
        jTextFieldFileName.getAccessibleContext().setAccessibleDescription(NbBundle.getMessage(CustomizerJarContent.class, "ACS_CustomizeEAR_FileName_A11YDesc")); // NOI18N
    }// </editor-fold>//GEN-END:initComponents
            
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddJar;
    private javax.swing.JButton jButtonAddLib;
    private javax.swing.JButton jButtonAddProject;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JCheckBox jCheckBoxCompress;
    private javax.swing.JLabel jLabelAddContent;
    private javax.swing.JLabel jLabelExContent;
    private javax.swing.JLabel jLabelExContent1;
    private javax.swing.JLabel jLabelFileName;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableAddContent;
    private javax.swing.JTextField jTextFieldExContent;
    private javax.swing.JTextField jTextFieldFileName;
    // End of variables declaration//GEN-END:variables
    
    /** Help context where to find more about the paste type action.
     * @return the help context for this action
     */
    public HelpCtx getHelpCtx() {
        return new HelpCtx(CustomizerJarContent.class);
    }
    
}
