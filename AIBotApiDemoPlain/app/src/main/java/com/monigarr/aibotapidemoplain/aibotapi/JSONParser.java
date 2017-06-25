package com.monigarr.aibotapidemoplain.aibotapi;

/**
 *
 * Created by MoniGarr.com on 6/24/2017.
 * author:          monigarr@monigarr.com
 * your dev key:    https://market.mashape.com/monigarr/ai-bots
 * tutorials:       https://github.com/monigarr/AIBotAPI
 * linkedin:        http://www.linkedin.com/in/monigarr
 * website:         http://www.MoniGarr.com
 *
 */

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JSONParser {
    public static ArrayList<BotResponse> mBotResponses = new ArrayList<>();
    public static BotResponse parseFeed(JSONObject obj) {
        try {
            BotResponse botresponse = new BotResponse();
            botresponse.setBotSaid(obj.getString("botsay"));
            botresponse.setYouSaid(obj.getString("usersay"));
            return botresponse;
        } catch (JSONException e1) {
            e1.printStackTrace();
            return null;
        }
    }

    public static ArrayList<BotResponse> parseArrayFeed(JSONArray arr){
        JSONObject obj = null;
        BotResponse botresponse = null;
        mBotResponses.clear();
        try {
            for(int i = 0; i < arr.length(); i++){
                botresponse = new BotResponse();
                botresponse.setBotSaid(obj.getString("response"));
                botresponse.setYouSaid(obj.getString("input"));
                mBotResponses.add(botresponse);
            }
            return mBotResponses;
        } catch(JSONException e1) {
            e1.printStackTrace();
            return null;
        }
    }
}

