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
final class TokenDoctype extends Token {
    final StringBuilder name = new StringBuilder();
    final StringBuilder publicIdentifier = new StringBuilder();
    final StringBuilder systemIdentifier = new StringBuilder();
    boolean forceQuirks = false;

    public TokenDoctype() {
        type = TokenType.Doctype;
    }

    @Override
    Token reset() {
        reset(name);
        reset(publicIdentifier);
        reset(systemIdentifier);
        forceQuirks = false;
        return this;
    }

    String getName() {
        return name.toString();
    }

    String getPublicIdentifier() {
        return publicIdentifier.toString();
    }

    public String getSystemIdentifier() {
        return systemIdentifier.toString();
    }

    public boolean isForceQuirks() {
        return forceQuirks;
    }
    
}
