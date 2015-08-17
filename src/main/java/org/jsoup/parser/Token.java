package org.jsoup.parser;

import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.BooleanAttribute;

/**
 * Parse tokens for the Tokeniser.
 */
abstract class Token {

    TokenType type;

    public Token() {
    }

    String tokenType() {
        return this.getClass().getSimpleName();
    }

    /**
     * Reset the data represent by this token, for reuse. Prevents the need to
     * create transfer objects for every piece of data, which immediately get
     * GCed.
     */
    abstract Token reset();

    static void reset(StringBuilder sb) {
        if (sb != null) {
            sb.delete(0, sb.length());
        }
    }

    final boolean isDoctype() {
        return type == TokenType.Doctype;
    }

    final TokenDoctype asDoctype() {
        return (TokenDoctype) this;
    }

    final boolean isStartTag() {
        return type == TokenType.StartTag;
    }

    final TokenStartTag asStartTag() {
        return (TokenStartTag) this;
    }

    final boolean isEndTag() {
        return type == TokenType.EndTag;
    }

    final EndTag asEndTag() {
        return (EndTag) this;
    }

    final boolean isComment() {
        return type == TokenType.Comment;
    }

    final TokenComment asComment() {
        return (TokenComment) this;
    }

    final boolean isCharacter() {
        return type == TokenType.Character;
    }

    final TokenCharacter asCharacter() {
        return (TokenCharacter) this;
    }

    final boolean isEOF() {
        return type == TokenType.EOF;
    }

}
