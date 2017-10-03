package com.tes;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

/**
 *
 * @author Srikanth A
 */
public class SAPConn {

    private String system;
    private String sid;
    private String instance;
    private String uid;
    private String pwd;
    private String tcode;
    private String client;
    
    /**
     *
     */
    public SAPConn(){
    
}

    /**
     *
     * @return
     */
    public String getClient() {
        return client;
    }

    /**
     *
     * @param client
     */
    public void setClient(String client) {
        this.client = client;
    }

    /**
     *
     * @return
     */
    public String getSystem() {
        return system;
    }

    /**
     *
     * @param system
     */
    public void setSystem(String system) {
        this.system = system;
    }

    /**
     *
     * @return
     */
    public String getSid() {
        return sid;
    }

    /**
     *
     * @param sid
     */
    public void setSid(String sid) {
        this.sid = sid;
    }

    /**
     *
     * @return
     */
    public String getInstance() {
        return instance;
    }

    /**
     *
     * @param instance
     */
    public void setInstance(String instance) {
        this.instance = instance;
    }

    /**
     *
     * @return
     */
    public String getUid() {
        return uid;
    }

    /**
     *
     * @param uid
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     *
     * @return
     */
    public String getPwd() {
        return pwd;
    }

    /**
     *
     * @param pwd
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     *
     * @return
     */
    public String getTcode() {
        return tcode;
    }

    /**
     *
     * @param tcode
     */
    public void setTcode(String tcode) {
        this.tcode = tcode;
    }

}
