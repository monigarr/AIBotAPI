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
import android.app.ProgressDialog;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.monigarr.aibotapidemoplain.R;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ParseJSONObject extends AppCompatActivity {

    //  TODO: Add Your Developer Key from https://market.mashape.com/monigarr/ai-bots
    //  TODO: Do Not share your developer key with anyone. MoniGarr will not ask for your dev key.
    private String developerkey = "you must enter your developer key here";

    private static final String TAG ="ParseJSONObject";
    private BotResponse mBotResponse;
    private TextView yousaidTextView;
    private TextView botsaidTextView;
    TextView info;
    EditText messageET;
    Button sendBtn;
    AnimationDrawable animationDrawable;

    String humansaid;
    String jsonURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parsejsonobject);

        yousaidTextView =(TextView)findViewById(R.id.edit_text_yousaid);
        botsaidTextView =(TextView)findViewById(R.id.edit_text_botsaid);
        messageET = (EditText) findViewById(R.id.messageEdit);
        sendBtn = (Button) findViewById(R.id.chatSendButton);
        info = (TextView)findViewById(R.id.info);

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAPI();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void getAPI(){
        humansaid = messageET.getText().toString();
        jsonURL = "https://monigarr-monigarr-bots-v1.p.mashape.com/conversation_start.php?bot_id=1&say=" +humansaid+ "&format=json";

        final ProgressDialog pDialog = new ProgressDialog(ParseJSONObject.this);
        pDialog.setMessage("Loading...");
        pDialog.show();

        JsonObjectRequest jsonObjReq =
                new JsonObjectRequest(Method.GET,jsonURL, null,new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        mBotResponse = JSONParser.parseFeed(response);
                        yousaidTextView.setText("You Said :" + mBotResponse.getYouSaid());
                        botsaidTextView.setText("Bot Said :" + mBotResponse.getBotSaid());
                        Log.d(TAG, response.toString());
                        pDialog.dismiss();
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d(TAG, "Error: " + error.getMessage());
                        pDialog.hide();
                    }
                }) {
                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        Map<String, String>  params = new HashMap<>();
                        params.put("X-Mashape-Key", developerkey);
                        params.put("Accept", "text/plain");
                        return params;
                    }
                };

        Volley.newRequestQueue(getApplicationContext()).add(jsonObjReq);
    }
}