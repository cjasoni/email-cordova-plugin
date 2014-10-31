package com.cjasoni.cordova.plugins;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONArray;
import org.json.JSONException;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.text.Html;

import com.cjasoni.cordova.plugins.Mail;
 
//@SuppressLint("ParserError")
public class EmailComposer extends CordovaPlugin {
    
    public final String ACTION_SEND_EMAIL = "sendEmail";
    
    
     
    @Override
    public boolean execute(String action, JSONArray arg1, CallbackContext callbackContext) {
        //PluginResult result = new PluginResult(Status.INVALID_ACTION);
        if (action.equals(ACTION_SEND_EMAIL)) {
            try {
                String message = arg1.getString(0); 
                String emailTo = arg1.getString(1); 
                this.sendEmailViaGmail(message,emailTo);
                callbackContext.success();
                return true;
            }
            catch (JSONException ex) {
                callbackContext.error(ex.getMessage());
                return false;
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return false;
    }

    private void sendEmailViaGmail(String body, String emailTo) throws Exception{
    	
    	String gmail = "cjasonigdotw@gmail.com";
    	String password = "gamedealoftheweek";
    	String subject = "Game Deal of the Week";
        Mail m = new Mail(gmail,password);
        String[] toArr = {emailTo};
        m.set_to(toArr);
        m.set_from(gmail);
        m.set_body(body);
        m.set_subject(subject);
        boolean sendFlag = m.send();

    }

    /*
    
        

     @Override
     public PluginResult execute(String action, JSONArray arg1, String callbackId) {
        PluginResult result = new PluginResult(Status.INVALID_ACTION);
            if (action.equals(ACTION_SEND_EMAIL)) {
            try {
                String message = arg1.getString(0);
                this.sendEmailViaGmail(message);
                result = new PluginResult(Status.OK);

            }
            catch (JSONException ex) {
                result = new PluginResult(Status.JSON_EXCEPTION, ex.getMessage());
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 
        }
        return result;
     }

     private void sendEmailViaGmail(String body) throws Exception{
        Mail m = new Mail("From_email_address@gmail.com", "your password");
        String[] toArr = {"TO_EMAIL_ADDRESS@gmail.com"};
        m.set_to(toArr);
        m.set_from("FROM_EMAIL_ADDRESS@gmail.com");
        m.set_body(body);
        m.set_subject("TEST SUBJECT");
        boolean sendFlag = m.send();

     }

     */
}