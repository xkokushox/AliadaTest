package com.freakybyte.aliadatest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Jose Torres in FreakyByte on 09/06/16.
 */
public class LogInModel {
    @SerializedName("session")
    @Expose
    private SessionModel session;

    /**
     * @return The session
     */
    public SessionModel getSession() {
        return session;
    }

    /**
     * @param session The session
     */
    public void setSession(SessionModel session) {
        this.session = session;
    }


}