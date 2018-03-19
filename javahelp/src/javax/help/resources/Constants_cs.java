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

package javax.help.resources;

import java.util.ListResourceBundle;

/**
 * Constants used for localizing JavaHelp.
 *
 * These are in the form of key, value.
 * Translators take care to only translate the values.
 *
 * @author Stepan Marek
 * @version	1.9	10/30/06
 *
 */
 
public class Constants_cs extends ListResourceBundle {
    /**
     * Overrides ListResourceBundle.
     */
    public Object[][] getContents() {
        return new Object[][] {

	    //  Constant strings and patterns
	    { "helpset.wrongPublicID",
		  "Nezn\u00e1m\u00e9 PublicID {0}"},
	    { "helpset.wrongTitle",
		  "Zkou\u0161\u00edm nastavit nadpis na {0}, ale nadpis m\u00e1 ji\u017e hodnotu {1}."},
	    { "helpset.wrongHomeID",
		  "Zkou\u0161\u00edm nastavit homeID na {0}, ale homeID ma ji\u017e hodnotu {1}."},
	    { "helpset.subHelpSetTrouble",
		  "Nelze vytvo\u0159it subhelpset: {0}"},
	    { "helpset.malformedURL",
		  "Chybn\u00fd form\u00e1t URL: {0}"},
	    { "helpset.incorrectURL",
		  "Chybn\u00e9 URL: {0}"},
	    { "helpset.wrongText",
		  "{0} nem\u016f\u017ee obsahovat text {1}."},
	    { "helpset.wrongTopLevel",
		  "{0} nem\u016f\u017ee b\u00fdt top level tag."},
	    { "helpset.wrongParent",
		  "P\u0159edch\u016fdce tagu {0} nem\u016f\u017ee b\u00fdt {1}."},
	    { "helpset.unbalanced",
		  "Nesoum\u011brn\u00fd tag {0}"},
	    { "helpset.wrongLocale",
		  "Upozorn\u011bn\u00ed: xml:lang atribut {0} je v konfliktu s implicitn\u00edmi hodnotami {1} a {2}"},
	    { "helpset.unknownVersion",
		  "Nezn\u00e1m\u00e1 verze {0}"},

		// IndexView messages
	    { "index.invalidIndexFormat",
		  "Upozorn\u011bn\u00ed: Index m\u00e1 chybn\u00fd form\u00e1t"},
	    { "index.unknownVersion",
		  "Nezn\u00e1m\u00e1 verze {0}"},

		// TOCView messages
	    { "toc.wrongPublicID",
		  "Nezn\u00e1m\u00e9 PublicID {0}"},
	    { "toc.invalidTOCFormat",
		  "Upozorn\u011bn\u00ed: TOC m\u00e1 chybn\u00fd form\u00e1t TOC"},
	    { "toc.unknownVersion",
		  "Nezn\u00e1m\u00e1 verze {0}"},
                  
                // FavoritesView messages
	    { "favorites.invalidFavoritesFormat",
		  "Upozorn\u011bn\u00ed: Nespr\u00e1vn\u00fd form\u00e1t souboru Favorites.xml"},
	    { "favorites.unknownVersion",
		  "Nespr\u00e1vn\u00e1 verze {0}."},

		// Map messages
	    { "map.wrongPublicID",
		  "Nezn\u00e1m\u00e9 PublicID {0}"},
	    { "map.invalidMapFormat",
		  "Upozorn\u011bn\u00ed: Map m\u00e1 chybn\u00fd form\u00e1t"},
	    { "map.unknownVersion",
		  "Nezn\u00e1m\u00e1 verze {0}"},

	    // GUI components
	    // Labels
	    { "index.findLabel", "Vyhledat: "},

	    { "search.findLabel", "Vyhledat: "},
	    { "search.hitDesc", "Po\u010det v\u00fdskyt\u016f v dokumentu"},
	    { "search.qualityDesc", "Nejni\u017e\u0161\u00ed chybovost v dokumentu" },
	    { "search.high", "Velmi vysok\u00e1"},
	    { "search.midhigh", "Vysok\u00e1"},
	    { "search.mid", "St\u0159edn\u00ed"},
	    { "search.midlow", "N\u00edzk\u00e1"},
	    { "search.low", "Velmi n\u00edzk\u00e1"},

            { "favorites.add", "P\u0159idej"},
            { "favorites.remove", "Sma\u017e"},
            { "favorites.folder", "Slo\u017eka"},
            { "favorites.name", "N\u00e1zev"},
            { "favorites.cut", "Vyst\u0159ihni"},
            { "favorites.paste", "Vlo\u017e"},
            { "favorites.copy" ,"Kop\u00edruj" },
            
	    { "history.homePage", "Domovsk\u00e1 Str\u00e1nka"},
            { "history.unknownTitle", "<nezn\u00e1m\u00fd titulek>"},

	    // ToolTips
	    { "tooltip.BackAction", "P\u0159edchoz\u00ed"},
	    { "tooltip.ForwardAction", "N\u00e1sleduj\u00edc\u00ed"},
	    { "tooltip.PrintAction", "Tisk"},
	    { "tooltip.PrintSetupAction", "Nastaven\u00ed str\u00e1nky"},
	    { "tooltip.ReloadAction", "Obnovit"},
            { "tooltip.FavoritesAction", "P\u0159idej k obl\u00edben\u00fdm polo\u017ek\u00e1m"},
            { "tooltip.HomeAction", "Go to home page"},

	    // Accessibility names
	    { "access.BackAction", "Sp\u00e1tky"},
	    { "access.ForwardAction", "Vp\u0159ed"},
	    { "access.HistoryAction", "Historie"},
	    { "access.PrintAction", "Tisk"},
	    { "access.PrintSetupAction", "Nastaven\u00ed Tisku"},
	    { "access.ReloadAction", "Obnoven\u00ed"},
            { "access.HomeAction", "Domovsk\u00e1 Str\u00e1nka"},
            { "access.FavoritesAction", "P\u0159idej k obl\u00edben\u00fdm"},
            { "access.contentViewer", "Prohl\u00ed\u017ee\u010d obsahu"}
       };
    }
}
