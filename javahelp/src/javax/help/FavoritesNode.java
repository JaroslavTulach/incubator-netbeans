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

package javax.help;

import javax.swing.tree.*;
import java.beans.*;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * A class for Favorites node. This class forces none-folders to have children.
 *
 * @author Richard Gregor
 * @version   1.5     10/30/06
 */

public class FavoritesNode extends DefaultMutableTreeNode  {
    /**
     * Header part of xml file
     */
    public static final String HEADER="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
    "<!DOCTYPE favorites\n PUBLIC \""+FavoritesView.publicIDString+
    "\"\n        \"http://java.sun.com/products/javahelp/favorites_2_0.dtd\">\n"+
    "\n<favorites version=\"2.0\">\n";
    
    /**
     * XML element name
     */
    public static final String ELEMENT="favoriteitem";
    /**
     * Footer of xml document
     */
    public static final String FOOTER="</favorites>";
    /**
     * FavoritesItem userObject of this node
     */
    private FavoritesItem item;   
    /**
     * Creates a FavoritesNode for FavoritesItem.
     *
     * @param item The FavoritesItem
     */
    public FavoritesNode(FavoritesItem item) {
        super(item);
        this.item = item;
    }
    
    /**
     * Returns wheter node is allowed to have children or not.
     */
    public boolean getAllowsChildren() {
        return ((FavoritesItem) getUserObject()).isFolder();
    }
    
    /**
     * Adds the child node.
     *
     * @param child The DefaultMutableTreeNode with FavoritesItem as UserObject.
     */
    public void add(DefaultMutableTreeNode child) {
        super.add(child);
        FavoritesItem childItem = (FavoritesItem) child.getUserObject();
        FavoritesItem oldParent = childItem.getParent();
        FavoritesItem newParent = (FavoritesItem) getUserObject();
        newParent.add(childItem);        
    }
    
    /**
     * Removes the child node.
     *
     * @param child Node to remove.
     */
    public void remove(DefaultMutableTreeNode child) {
        super.remove(child);
        FavoritesItem childItem = (FavoritesItem) ((FavoritesNode) child).getUserObject();
        FavoritesItem ParentItem = (FavoritesItem) getUserObject();
        if (parent != null)
            ParentItem.remove(childItem);
    }
    /**
     * Returns the number of visible children
     *
     */
    public int getVisibleChildCount(){
        int count = 0;
        if( item == null)
            return 0;
        
        for(Enumeration en = item.getChildren().elements(); en.hasMoreElements();){
            FavoritesItem nItem =(FavoritesItem)en.nextElement();
            if(nItem.isVisible())
                count++;
        }
        return count;
    }
    /**
     * Returns the string representation of offset.
     */
    public String getOffset(){
        String parentOffset = null;
        String offset = null;
        
        FavoritesNode parent = (FavoritesNode)getParent();
        if(parent != null){
            parentOffset = parent.getOffset();
            offset = parentOffset + "  ";
        }else
            offset = "  ";
        
        return offset;
    }
    /**
     * Exports nodes descendants to the OutputStream
     *
     * @param out The OutputStream
     */
    public void export(OutputStream out) throws IOException{        
        OutputStreamWriter writer = new OutputStreamWriter(out);
        writer = exportHeader(out);
        //exportNode(writer);
        Enumeration chldn = children(); 
        if(!(chldn.equals(DefaultMutableTreeNode.EMPTY_ENUMERATION))){
            while(chldn.hasMoreElements()){
                FavoritesNode node = (FavoritesNode)chldn.nextElement();
                node.exportNode(writer);
            }
        }
        writer.write(FOOTER);
        //out.close();
        writer.close();
    }

    /**
     * Exports node and its descendants to the xml file according favorites.dtd.
     *
     * @param out The OutputStream
     */
    public void exportNode(OutputStreamWriter writer) throws IOException{
        TreeNode paren = getParent();        
        FavoritesItem item = (FavoritesItem)getUserObject();        
        writer.write(getOffset()+"<"+getXMLElement()+ " text=\""+item.getName()+"\" ");
        String target = item.getTarget();
        if(target != null)
            writer.write("target=\""+target+"\" ");
        String url = item.getURLSpec();
        if(url != null)
            writer.write("url=\""+url+"\"");
        String hstitle = item.getHelpSetTitle();
        if(hstitle != null)
            writer.write(" hstitle=\""+hstitle+"\"");
        Enumeration chldn = children(); 
        if(chldn.equals(DefaultMutableTreeNode.EMPTY_ENUMERATION))
            writer.write("/>\n");
        else{ 
            writer.write(">\n");
            Enumeration offspring = children.elements();
            while(offspring.hasMoreElements()){
                FavoritesNode off = (FavoritesNode)offspring.nextElement();
                debug("offspring: "+off);
                off.exportNode(writer);
            }
            writer.write(getOffset()+"</"+ELEMENT+">\n");
        }
        
     
    }
    
    /**
     * Exports header defined for this type of node to the OutputStream.
     *
     * @param out The OutputStream.
     */
    public OutputStreamWriter exportHeader(OutputStream out) throws IOException{
        //OutputStreamWriter writer = new OutputStreamWriter(out,"UTF-8")
        
        OutputStreamWriter writer = new OutputStreamWriter(out,"UTF-8");
        writer.write(HEADER);
        return writer;
    }
    
    /**
     * Returns the XML header string
     */
    public String getXMLHeader(){
        return HEADER;
    }
    /**
     * Returns the XML element string
     */
    public String getXMLElement(){
        return ELEMENT;
    }
    
    /**
     * Returns  the deep copy of node
     */
    public FavoritesNode getDeepCopy(){
        
	return new FavoritesNode((FavoritesItem)item.clone());
	/*
        FavoritesNode copy = null;
        ObjectOutputStream out = null;
        ObjectInputStream in = null;
        
        try{            
            ByteArrayOutputStream bOut = new ByteArrayOutputStream();
            out = new ObjectOutputStream(bOut);
            out.writeObject(this);
            out.flush();
            
            in = new ObjectInputStream(new ByteArrayInputStream(bOut.toByteArray()));            
            copy =(FavoritesNode) in.readObject();
            
            out.close();
            in.close();
        }catch(Exception e){
            System.err.println(e);
        }
        
        return copy;
	*/

    }
    
    /**
     * Returns wheter node is visible or not
     */
    public boolean isVisible(){
        return item.isVisible();
    }
    
    /**
     * Sets visibility of node
     */
    public void setVisible(boolean vis){
        item.setVisible(vis);
    }
        
    /**
     * Debugging code
     */
    private static final boolean debug = false;
    private static void debug(String msg) {
  	if (debug) {
  	    System.err.println("FavoritesNode: "+msg);
	}
    }
    
}
