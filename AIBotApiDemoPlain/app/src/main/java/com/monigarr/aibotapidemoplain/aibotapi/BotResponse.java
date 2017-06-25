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

import java.io.Serializable;

public class BotResponse implements Serializable {
    private String mBotSaid;
    private String mYouSaid;

    public String getBotSaid(){
        return mBotSaid;
    }

    public String getYouSaid(){
        return mYouSaid;
    }

    public void setBotSaid(String mBotSaid) {
        this.mBotSaid = mBotSaid;
    }

    public void setYouSaid(String mYouSaid){
        this.mYouSaid = mYouSaid;
    }
}
