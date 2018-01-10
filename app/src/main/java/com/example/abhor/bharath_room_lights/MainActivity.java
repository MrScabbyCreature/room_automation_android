package com.example.abhor.bharath_room_lights;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
//    private static Button bt_light1;
    private static TextView tv_status;
    private String host_IP = "http://192.168.43.109/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_status = (TextView) findViewById(R.id.tv_status);
    }

    void l1(View view){
        toggle_light("0001");
    }

    void l2(View view){
        toggle_light("0010");
    }

    void l3(View view){
        toggle_light("0100");
    }

    void l4(View view){
        toggle_light("1000");
    }

    void l_all(View view){
        toggle_light("1111");
    }

    void toggle_light(String part_url){
        try {
            // Instantiate the RequestQueue.
            RequestQueue queue = Volley.newRequestQueue(this);

            // Request a string response from the provided URL.
            StringRequest stringRequest = new StringRequest(Request.Method.GET, host_IP + part_url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // Display the first 500 characters of the response string.
                            tv_status.setText("Connection successful!");
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    tv_status.setText("That didn't work!");
                }
            });
            // Add the request to the RequestQueue.
            queue.add(stringRequest);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
