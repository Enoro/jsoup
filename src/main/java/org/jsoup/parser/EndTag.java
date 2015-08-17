/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsoup.parser;

/**
 *
 * @author peer.bridge
 */
final class EndTag extends TokenTag {

    EndTag() {
        super();
        type = TokenType.EndTag;
    }

    @Override
    public String toString() {
        return "</" + name() + ">";
    }
    
}
