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
final class TokenCharacter extends Token {
    private String data;

    TokenCharacter() {
        super();
        type = TokenType.Character;
    }

    @Override
    Token reset() {
        data = null;
        return this;
    }

    TokenCharacter data(String data) {
        this.data = data;
        return this;
    }

    String getData() {
        return data;
    }

    @Override
    public String toString() {
        return getData();
    }
    
}
