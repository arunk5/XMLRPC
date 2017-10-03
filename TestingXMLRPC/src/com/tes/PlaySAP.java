package com.tes;

public class PlaySAP {
	SAPConn con = new SAPConn();
	public int  trigger(int a, int b){
		 String idvalue = "584";
	        initSAPConn();
	        PlayCommand play = new PlayCommand("play:" + idvalue + "|" + "script#" + idvalue, con);
	        Thread tplay = new Thread(play);
	        tplay.start();
	        return 0;
	}
	
	 private void initSAPConn(){
	    	con.setClient("100");
	    	con.setInstance("04");
	    	con.setPwd("stravis123");
	    	con.setSid("DEM");
	    	con.setSystem("192.168.1.16");
	    	con.setTcode("FBL3N");
	    	con.setUid("tst_vms");
	    }

}
