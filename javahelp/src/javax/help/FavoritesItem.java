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

import java.util.Vector;
import java.util.Locale;
import javax.help.Map.ID;
import java.awt.datatransfer.*;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.net.MalformedURLException;

/**
 * A class for individual favorites items.
 *
 * @author Richard Gregor
 * @version   1.6     10/30/06
 */

public class FavoritesItem extends TreeItem implements Transferable, Serializable{
    private boolean isFolder = false;
    
    final public static DataFlavor FAVORITES_FLAVOR =
    new DataFlavor(FavoritesItem.class, "Favorites Item");
    
    static DataFlavor flavors[] = {FAVORITES_FLAVOR };
    
    private FavoritesItem parent = null;
    private Vector children = new Vector();
    private String url= null;
    private String target = null;
    private String title = null;
    //determines wheter item was initialized as empty or not
    private boolean emptyInitState = true;   
    private boolean visible = true;

    /**
     * Creates item with name
     *
     * @param name The name of item
     */
    public FavoritesItem(String name){     
	setName(name);
    }
    
    /**
     * Creates empty item
     */
    public FavoritesItem(){
        this(null);
    }
    /**
     * Creates FavoritesItem.
     *
     * @param name The name of item
     * @param target The target of item
     * @param url The external representation of url
     * @param title The title of the HelpSet
     * @param locale The Locale of this item
     */
    public FavoritesItem(String name, String target, String url, String title, Locale locale){
        this(name);
        this.target = target;
        this.url = url;
        this.locale = locale;
        this.title = title;
    }
    
    public void setVisible(boolean visible){
        this.visible = visible;
    }

    public boolean isVisible(){
        return visible;
    }

    /**
     * Returns the id for this item.
     */
    public String getTarget() {
        return target;
    }

    /**
     *Returns the external representation of url for this item.
     */
    public String getURLSpec(){
        return url;
    }    

    /**
     * Return the URL for this item
     */
    public URL getURL () {
	try {
	    return new URL(url);
	} catch (MalformedURLException e) {
	}
	return null;
    }
	
    /**
     * Returns the title of HelpSet
     */
    public String getHelpSetTitle(){
        return title;
    }

    /**
     * Sets this item as folder.
     */
    public void setAsFolder(){
        isFolder = true;
    }

    /**
     * Returns wheter item allows children or not
     */
    public boolean allowsChildren(){
        return isFolder();
    }
    
    /**
     * Returns whether or not this item is leaf
     */
    public boolean isLeaf(){
        return(!isFolder());
    }
    /**
     * Returns whether or not this item is folder.
     */
    public boolean isFolder(){
        return isFolder;
    }
    
    /**
     * Adds FavoritesItem as a child.
     *
     * @param item The FavoritesItem.
     */
    public void add(FavoritesItem item) {
        item.setParent(this);
        children.add(item);
        emptyInitState = false;
        isFolder = true;
    }
    
    /**
     * Returns true if item was initialized as empty
     */
    public boolean emptyInitState(){
        return emptyInitState;
    }
    
    /**
     * Removes FavoritesItem from vector of children.
     *
     * @param item The FavoritesItem to remove.
     */
    public void remove(FavoritesItem item) {
        item.setParent(null);
        children.remove(item);
    }

    /**
     * Returns parent of FavoritesItem.
     */
    public FavoritesItem getParent() {
        return parent;
    }
    
    /**
     * Sets the parent of this item.
     *
     * @param parent The FavoritesItem.
     */
    public void setParent(FavoritesItem parent) {
        this.parent = parent;
    }
    
    /**
     * Returns children of this FavoritesItem.
     */
    public Vector getChildren() {
        return children;
    }
    
    public Object clone(){
        FavoritesItem item = new FavoritesItem(getName(), target, url, 
					       title, locale);
        return item;
    }
    
    public String toString(){
        return getName();
    }
        
    /**
     * Returns an object which represents the data to be transferred.
     */
    public Object getTransferData(DataFlavor df) throws UnsupportedFlavorException, IOException {
        if (df.equals(FAVORITES_FLAVOR)) {
            return this;
        }
        else throw new UnsupportedFlavorException(df);
    }
    
    /**
     * Returns an array of DataFlavor objects indicating the flavors the data can be provided in.
     */
    public DataFlavor[] getTransferDataFlavors() {
        return flavors;
    }
    
    /**
     * Returns whether or not the specified data flavor is supported for this object.
     */
    public boolean isDataFlavorSupported(DataFlavor df) {
        return df.equals(FAVORITES_FLAVOR);
    }
    
}


