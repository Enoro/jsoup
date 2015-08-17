/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsoup.parser;

import org.jsoup.nodes.Attributes;

/**
 *
 * @author peer.bridge
 */
final class TokenStartTag extends TokenTag {

    TokenStartTag() {
        super();
        attributes = new Attributes();
        type = TokenType.StartTag;
    }

    @Override
    TokenTag reset() {
        super.reset();
        attributes = new Attributes();
        // todo - would prefer these to be null, but need to check Element assertions
        return this;
    }

    TokenStartTag nameAttr(String name, Attributes attributes) {
        this.tagName = name;
        this.attributes = attributes;
        return this;
    }

    @Override
    public String toString() {
        if (attributes != null && attributes.size() > 0) {
            return "<" + name() + " " + attributes.toString() + ">";
        } else {
            return "<" + name() + ">";
        }
    }
    
}
