/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsoup.parser;

import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.BooleanAttribute;

/**
 *
 * @author peer.bridge
 */
abstract class TokenTag extends Token {
    protected String tagName;
    private String pendingAttributeName; // attribute names are generally caught in one hop, not accumulated
    private StringBuilder pendingAttributeValue = new StringBuilder(); // but values are accumulated, from e.g. & in hrefs
    private boolean hasEmptyAttributeValue = false; // distinguish boolean attribute from empty string value
    private boolean hasPendingAttributeValue = false;
    boolean selfClosing = false;
    Attributes attributes; // start tags get attributes on construction. End tags get attributes on first new attribute (but only for parser convenience, not used).

    @Override
    TokenTag reset() {
        tagName = null;
        pendingAttributeName = null;
        reset(pendingAttributeValue);
        hasEmptyAttributeValue = false;
        hasPendingAttributeValue = false;
        selfClosing = false;
        attributes = null;
        return this;
    }

    final void newAttribute() {
        if (attributes == null) {
            attributes = new Attributes();
        }
        if (pendingAttributeName != null) {
            Attribute attribute;
            if (hasPendingAttributeValue) {
                attribute = new Attribute(pendingAttributeName, pendingAttributeValue.toString());
            } else if (hasEmptyAttributeValue) {
                attribute = new Attribute(pendingAttributeName, "");
            } else {
                attribute = new BooleanAttribute(pendingAttributeName);
            }
            attributes.put(attribute);
        }
        pendingAttributeName = null;
        hasEmptyAttributeValue = false;
        hasPendingAttributeValue = false;
        reset(pendingAttributeValue);
    }

    final void finaliseTag() {
        // finalises for emit
        if (pendingAttributeName != null) {
            // todo: check if attribute name exists; if so, drop and error
            newAttribute();
        }
    }

    final String name() {
        Validate.isFalse(tagName == null || tagName.length() == 0);
        return tagName;
    }

    final TokenTag name(String name) {
        tagName = name;
        return this;
    }

    final boolean isSelfClosing() {
        return selfClosing;
    }

    @SuppressWarnings(value = {"TypeMayBeWeakened"})
    final Attributes getAttributes() {
        return attributes;
    }

    // these appenders are rarely hit in not null state-- caused by null chars.
    final void appendTagName(String append) {
        tagName = tagName == null ? append : tagName.concat(append);
    }

    final void appendTagName(char append) {
        appendTagName(String.valueOf(append));
    }

    final void appendAttributeName(String append) {
        pendingAttributeName = pendingAttributeName == null ? append : pendingAttributeName.concat(append);
    }

    final void appendAttributeName(char append) {
        appendAttributeName(String.valueOf(append));
    }

    final void appendAttributeValue(String append) {
        ensureAttributeValue();
        pendingAttributeValue.append(append);
    }

    final void appendAttributeValue(char append) {
        ensureAttributeValue();
        pendingAttributeValue.append(append);
    }

    final void appendAttributeValue(char[] append) {
        ensureAttributeValue();
        pendingAttributeValue.append(append);
    }

    final void setEmptyAttributeValue() {
        hasEmptyAttributeValue = true;
    }

    private void ensureAttributeValue() {
        hasPendingAttributeValue = true;
    }
    
}
