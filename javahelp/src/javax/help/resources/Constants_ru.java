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
 * Constants used for localizing JavaHelp
 *
 * These are in the form of key, value.
 * Translators take care to only translate the values
 */

public class Constants_ru extends ListResourceBundle {
    /**
     * Overrides ListResourceBundle
     */
    public Object[][] getContents() {
        return new Object[][] {

            //  Constant strings and patterns
            { "helpset.wrongPublicID",
                  "\u041d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u044b\u0439 PublicID {0}"},
            { "helpset.wrongTitle",
                  "\u041d\u0435\u0432\u043e\u0437\u043c\u043e\u0436\u043d\u043e \u0438\u0437\u043c\u0435\u043d\u0438\u0442\u044c \u0437\u043d\u0430\u0447\u0435\u043d\u0438\u0435 title \u043d\u0430 {0} \u0442\u0430\u043a \u043a\u0430\u043a \u043e\u043d \u0443\u0436\u0435 \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d \u0432 {1}."},
            { "helpset.wrongHomeID",
                  "\u041d\u0435\u0432\u043e\u0437\u043c\u043e\u0436\u043d\u043e \u0438\u0437\u043c\u0435\u043d\u0438\u0442\u044c \u0437\u043d\u0430\u0447\u0435\u043d\u0438\u0435 homeID \u043d\u0430 {0} \u0442\u0430\u043a \u043a\u0430\u043a \u043e\u043d \u0443\u0436\u0435 \u0443\u0441\u0442\u0430\u043d\u043e\u0432\u043b\u0435\u043d \u0432 {1}."},
            { "helpset.subHelpSetTrouble",
                  "\u041e\u0448\u0438\u0431\u043a\u0430 \u0441\u043e\u0437\u0434\u0430\u043d\u0438\u044f subhelpset: {0}."},
            { "helpset.malformedURL",
                  "\u041e\u0448\u0438\u0431\u043e\u0447\u043d\u044b\u0439 URL: {0}."},
            { "helpset.incorrectURL",
                  "\u041d\u0435\u0432\u0435\u0440\u043d\u044b\u0439 URL: {0}."},
            { "helpset.wrongText",
                  "{0} \u043d\u0435 \u043c\u043e\u0436\u0435\u0442 \u0441\u043e\u0434\u0435\u0440\u0436\u0430\u0442\u044c \u0442\u0435\u043a\u0441\u0442 {1}."},
            { "helpset.wrongTopLevel",
                  "{0} \u043d\u0435 \u043c\u043e\u0436\u0435\u0442 \u0431\u044b\u0442\u044c \u0442\u0435\u0433\u043e\u043c \u0432\u0435\u0440\u0445\u043d\u0435\u0433\u043e \u0443\u0440\u043e\u0432\u043d\u044f."},
            { "helpset.wrongParent",
                  "\u0420\u043e\u0434\u0438\u0442\u0435\u043b\u044c\u0441\u043a\u0438\u0439 \u0442\u0435\u0433 {0} \u043d\u0435 \u043c\u043e\u0436\u0435\u0442 \u0431\u044b\u0442\u044c {1}."},
            { "helpset.unbalanced",
                  "\u041d\u0435\u0437\u0430\u043a\u0440\u044b\u0442\u044b\u0439 \u0442\u0435\u0433 {0}."},
            { "helpset.wrongLocale",
                  "\u041f\u0440\u0435\u0434\u0443\u043f\u0440\u0435\u0436\u0434\u0435\u043d\u0438\u0435: xml: \u044f\u0437\u044b\u043a\u043e\u0432\u043e\u0439 \u0430\u0442\u0440\u0438\u0431\u0443\u0442 {0} \u043d\u0435 \u0441\u043e\u0433\u043b\u0430\u0441\u0443\u0435\u0442\u0441\u044f \u0441 \u0430\u0442\u0440\u0438\u0431\u0443\u0442\u043e\u043c \u043f\u043e \u0443\u043c\u043e\u043b\u0447\u0430\u043d\u0438\u044e {1} \u0438 {2}"},
            { "helpset.unknownVersion",
                  "\u041d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u0430\u044f \u0432\u0435\u0440\u0441\u0438\u044f {0}."},

                // IndexView messages
            { "index.invalidIndexFormat",
                  "\u041f\u0440\u0435\u0434\u0443\u043f\u0440\u0435\u0436\u0434\u0435\u043d\u0438\u0435: \u041d\u0435\u0432\u0435\u0440\u043d\u044b\u0439 \u0444\u043e\u0440\u043c\u0430\u0442 \u0438\u043d\u0434\u0435\u043a\u0441\u0430"},
            { "index.unknownVersion",
                  "\u041d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u0430\u044f \u0432\u0435\u0440\u0441\u0438\u044f {0}."},

                // TOCView messages
            { "toc.wrongPublicID",
                  "\u041d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u044b\u0439 PublicID {0}"},
            { "toc.invalidTOCFormat",
                  "\u041f\u0440\u0435\u0434\u0443\u043f\u0440\u0435\u0436\u0434\u0435\u043d\u0438\u0435: \u041d\u0435\u0432\u0435\u0440\u043d\u044b\u0439 \u0444\u043e\u0440\u043c\u0430\u0442 \u0441\u043e\u0434\u0435\u0440\u0436\u0430\u043d\u0438\u044f"},
            { "toc.unknownVersion",
                  "\u041d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u0430\u044f \u0432\u0435\u0440\u0441\u0438\u044f {0}."},

            // FavoritesView messages
	    { "favorites.invalidFavoritesFormat",
		  "Warning: Invalid Favorites format"},
	    { "favorites.unknownVersion",
		  "Unknown Version {0}."},

                // Map messages
            { "map.wrongPublicID",
                  "\u041d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u044b\u0439  PublicID {0}"},
            { "map.invalidMapFormat",
                  "\u041f\u0440\u0435\u0434\u0443\u043f\u0440\u0435\u0436\u0434\u0435\u043d\u0438\u0435: \u041d\u0435\u0432\u0435\u0440\u043d\u044b\u0439 \u0444\u043e\u0440\u043c\u0430\u0442 \u043a\u0430\u0440\u0442\u044b"},
            { "map.unknownVersion",
                  "\u041d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u0430\u044f \u0432\u0435\u0440\u0441\u0438\u044f {0}."},

            // GUI components
            // Labels
            { "index.findLabel", "\u041d\u0430\u0439\u0442\u0438: "},

            { "search.findLabel", "\u041d\u0430\u0439\u0442\u0438: "},
 	    { "search.hitDesc", "Number of occurances in document"},
	    { "search.qualityDesc", "Lowest penality value in document" },
	    { "search.high", "High"},
	    { "search.midhigh", "Medium high"},
	    { "search.mid", "Medium"},
	    { "search.midlow", "Medium low"},
	    { "search.low", "Low"},
            
            { "favorites.add", "Add"},
            { "favorites.remove", "Remove"},
            { "favorites.folder", "New Folder"},
            { "favorites.name", "Name"},
            { "favorites.cut", "Cut"},
            { "favorites.paste", "Paste"},
            { "favorites.copy" , "Copy"},

            { "history.homePage", "Home page"},
            { "history.unknownTitle", "<unknown page title>"},

           // ToolTips
            { "tooltip.BackAction", "\u043d\u0430\u0437\u0430\u0434"},
            { "tooltip.ForwardAction", "\u0432\u043f\u0435\u0440\u0435\u0434"},
            { "tooltip.PrintAction", "\u043f\u0435\u0447\u0430\u0442\u044c"},
	    { "tooltip.PrintSetupAction", "\u043f\u0430\u0440\u0430\u043c\u0435\u0442\u0440\u044b \u0441\u0442\u0440\u0430\u043d\u0438\u0446\u044b"},
            { "tooltip.ReloadAction", "\u043e\u0431\u043d\u043e\u0432\u0438\u0442\u044c"},
            { "tooltip.HomeAction", "Go to home page"},

	    // Accessibility names
	    { "access.BackAction", "Previous Button"},
	    { "access.ForwardAction", "Next Button"},
	    { "access.HistoryAction", "History Button"},
	    { "access.PrintAction", "Print Button"},
	    { "access.PrintSetupAction", "Page Setup Button"},
	    { "access.ReloadAction", "Reload Button"},
            { "access.HomeAction", "Home Button"},
            { "access.FavoritesAction", "Add to Favorites Button"},
            { "access.contentViewer", "Content Viewer"}
       };
    }
}
