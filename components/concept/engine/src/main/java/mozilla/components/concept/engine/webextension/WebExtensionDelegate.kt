/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package mozilla.components.concept.engine.webextension

import mozilla.components.concept.engine.EngineSession

/**
 * Notifies applications or other components of engine events related to web
 * extensions e.g. an extension was installed, or an extension wants to open
 * a new tab.
 */
interface WebExtensionDelegate {

    /**
     * Invoked when a web extension was installed successfully.
     *
     * @param webExtension The installed extension.
     */
    fun onInstalled(webExtension: WebExtension) = Unit

    /**
     * Invoked when a web extension attempts to open a new tab via
     * browser.tabs.create.
     *
     * @param webExtension An instance of [WebExtension] or null if extension
     * was not registered with the engine.
     * @param url the target url to be loaded in a new tab.
     * @param engineSession an instance of engine session to open a new tab with.
     */
    fun onNewTab(webExtension: WebExtension?, url: String, engineSession: EngineSession) = Unit

    /**
     * Invoked when a web extension attempts to close a tab via browser.tabs.remove.
     *
     * @param webExtension An instance of [WebExtension] or null if extension
     * was not registered with the engine.
     * @param engineSession then engine session fo the tab to be closed.
     * @return true if the tab was closed, otherwise false.
     */
    fun onCloseTab(webExtension: WebExtension?, engineSession: EngineSession) = false
}
