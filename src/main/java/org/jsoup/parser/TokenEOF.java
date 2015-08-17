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
final class TokenEOF extends Token {

    TokenEOF() {
        type = TokenType.EOF;
    }

    @Override
    Token reset() {
        return this;
    }
    
}
