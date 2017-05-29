package com.monigarr.aibotapidemoplain;

/******************************************
 *  AI Bot API Demo
 *  author:     monigarr@monigarr.com
 *  website:    MoniGarr.com
 *  devKey:     https://market.mashape.com/monigarr/ai-bots#html-chat-form
 *
 *  Demo of how to use AI Bot API
 *  for your own Android projects.
 *
 *  Todo: Review TODO tab to setup your own project requirements
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.ProgressBar;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    private WebView webView;
    private ProgressBar progressBar;

    //  Todo: STEP TWO choose json or xml endpoint
    private String postUrl = "https://monigarr-monigarr-bots-v1.p.mashape.com/conversation_start.php?bot_id=1&say=who are you&format=xml";
    //private String postUrl = "https://monigarr-monigarr-bots-v1.p.mashape.com/conversation_start.php?bot_id=1&say={say}&format=xml";
    //private String postUrl = "https://monigarr-monigarr-bots-v1.p.mashape.com/conversation_start.php?bot_id=1&say={say}&format=json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = (WebView) findViewById(R.id.webView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        //  Todo: STEP ONE get your private dev key https://market.mashape.com/monigarr/ai-bots
        Map<String, String> extraHeaders = new HashMap<String, String>();
        extraHeaders.put("X-Mashape-Key","<Enter Your Dev Key Here>");
        extraHeaders.put("Accept","text/plain");

        webView.getSettings().setJavaScriptEnabled(false);
        webView.loadUrl(postUrl,extraHeaders);
        webView.setHorizontalScrollBarEnabled(false);
    }

    //  Todo: STEP THREE : build & run demo app - confirm you receive response from bot

    //  Todo: STEP FOUR : CREATE YOUR UI / UX
    //  I put a webview & progressbar in this project so you can quickly confirm that your
    //      endpoint & key is setup correctly to receive response from the AI Bot
    //
    //  Idea: Put your human entered text into the {say} portion of the endpoint
    //  Idea: Predefined Button can input hardcoded commands or text into the {say} portion of the endpoint
    //  Idea: audio input for {say} with builtin Voice Reco: http://www.androidhive.info/2014/07/android-speech-to-text-tutorial/
    //  Idea: Contact MoniGarr.com to request we enable Secret Commands for a new Customized Bot for your
    //          specific usecase: IOT, Smart Home Commands, VR, Mixed Reality and anything else you


}
