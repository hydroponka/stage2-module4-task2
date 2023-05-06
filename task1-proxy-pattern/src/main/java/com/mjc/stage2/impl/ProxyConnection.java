package com.mjc.stage2.impl;


import com.mjc.stage2.Connection;

public class ProxyConnection implements Connection {
    private RealConnection realConnection;

    public ProxyConnection(RealConnection realConnection) {
        this.realConnection = realConnection;
    }

    public void reallyClose() {
        realConnection.close();
        if (realConnection.isClosed()){
            ConnectionPool.getInstance().releaseConnection(realConnection);
        }
    }

    @Override
    public void close() {
    }

    @Override
    public boolean isClosed() {
        return realConnection.isClosed();
    }
    // Implement methods here!
}
