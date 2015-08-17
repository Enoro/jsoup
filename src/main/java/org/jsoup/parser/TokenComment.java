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
final class TokenComment extends Token {
    final StringBuilder data = new StringBuilder();
    boolean bogus = false;

    @Override
    Token reset() {
        reset(data);
        bogus = false;
        return this;
    }

    TokenComment() {
        type = TokenType.Comment;
    }

    String getData() {
        return data.toString();
    }

    @Override
    public String toString() {
        return "<!--" + getData() + "-->";
    }
    
}
