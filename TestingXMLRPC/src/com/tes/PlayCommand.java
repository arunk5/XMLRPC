package com.tes;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
 

/**
 *
 * @author Srikanth A
 */
public class PlayCommand implements Runnable{

    
    private Process p;
    private final String command;
    private final SAPConn conn;
    private final String cmd1 = "java -cp .;\"" + System.getProperty("user.home")
            + "\\SAP Clients\\SAPGUI for Java 7.40rev7\\jar\\GuiStartS.jar\";"
            + "./lib/javassist-3.14.0-GA.jar;./lib/mysqlconnect.jar;"
            + "./lib/externalCommunicationS.jar;./lib/iCubeS.jar;./lib/JNetBeanS.jar;"
            + "./lib/pdfViewerS.jar;./lib/platincoreS.jar;./lib/platinlangS.jar;"
            + "./lib/platinr3S.jar;./lib/platinsecS.jar;./lib/platinwdpS.jar;"
            + "./lib/sapCalendarS.jar;./lib/sapChartS.jar;./lib/sapComboBoxS.jar;"
            + "./lib/sapContextMenuS.jar;./lib/sapGridS.jar;./lib/sapHtmlCoreS.jar;"
            + "./lib/sapHtmlS.jar;./lib/sapImageS.jar;./lib/sapInputFieldS.jar;"
            + "./lib/sapJnetS.jar;./lib/sapPdfViewerS.jar;./lib/sapTextEditS.jar;"
            + "./lib/sapToolBarS.jar;./lib/sapTreeS.jar;./lib/jcifs-1.3.18.jar; -javaagent:./lib/Engine.jar=";
    private final String cmd2 = " com.sap.platin.Gui -n -o conn=/H/";

    /**
     *
     * @param command
     * @param conn
     */
      
    public PlayCommand(String command, SAPConn conn) {
          
        this.command = command;
        this.conn = conn;      
    }
    
    /**
     *
     */
    public void stopProcess()
    {
        if(p.isAlive())            
            p.destroy();
    }


    @Override
    public void run() {
        String id = null;
        try {
            String s = null;            
            System.out.println("Play: "+ cmd1+this.command+cmd2+this.conn.getSystem()
                      +"/S/32"+this.conn.getInstance()+"/&clnt="+this.conn.getClient()+"&user="+this.conn.getUid()
                     + "&pass="+this.conn.getPwd()+"&tran="+this.conn.getTcode());
             p = Runtime.getRuntime().exec(cmd1+this.command+cmd2+this.conn.getSystem()
                      +"/S/32"+this.conn.getInstance()+"/&clnt="+this.conn.getClient()+"&user="+this.conn.getUid()
                     + "&pass="+this.conn.getPwd()+"&tran="+this.conn.getTcode());
            
            BufferedReader stdInput = new BufferedReader(new
                         InputStreamReader(p.getInputStream()));
            
            BufferedReader stdError = new BufferedReader(new
                         InputStreamReader(p.getErrorStream()));
           
            // read the output from the command
            System.out.println("Here is the standard output of the command:\n");
            while ((s = stdInput.readLine()) != null) {
            //     logger.info("Process Status: " +  Thread.currentThread().getState());
             //   logger.info("Process Priority: " +  Thread.currentThread().getPriority());
            	System.out.println(s);
            }            
            // read any errors from the attempted command
            System.out.println("Here is the standard error of the command (if any):\n");
            while ((s = stdError.readLine()) != null) {
            	System.out.println(s);
            }
        } catch (IOException ex) {
            Logger.getLogger(PlayCommand.class.getName()).log(Level.SEVERE, null, ex);
        }         
    }
}
