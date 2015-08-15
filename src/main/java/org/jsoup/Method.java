/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jsoup;

/**
 *
 * @author peer.bridge
 *
 */
public enum Method {

    GET(false), POST(true), PUT(true), DELETE(false), PATCH(true);

    private final boolean hasBody;

    Method(boolean hasBody) {
        this.hasBody = hasBody;
    }

    public final boolean hasBody() {
        return hasBody;
    }
}
