package com.example.hp.newsread;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

/**
 * Created by hp on 14-07-2018.
 */

public class newstask extends AsyncTask<String,Void,ArrayList<Event>> {
    Context mContext;
    ListView mView;
    public static final String TAG = "Main_Activity";
    public newstask(Context baseContext,View baseView) {
        mContext = baseContext;
        mView = (ListView) baseView;
    }

    @Override
    protected ArrayList<Event> doInBackground(String... urls)
    {
        Log.i(TAG, "doInBackground: ");
        URL url = null;
        try {
            url = new URL(urls[0]);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        String jsonres = "";
        jsonres = makeHTTpRequest(url);
        return extractFeatureFromJson(jsonres);

    }

    @Override
    protected void onPostExecute(ArrayList<Event> events) {
        Log.i(TAG, "onPostExecute: ");
        super.onPostExecute(events);
        customadapt adapter = new customadapt(mContext, events);
        mView.setAdapter(adapter);



    }

    private String makeHTTpRequest(URL url)
    {
        String jsonResponse = "";
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;

        try {
            urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setConnectTimeout(10000);
            urlConnection.setReadTimeout(15000);
            urlConnection.connect();
            inputStream = urlConnection.getInputStream();
            jsonResponse = readFromStream(inputStream);

            }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally {
            if(urlConnection!=null)
            {
                urlConnection.disconnect();
            }
            if (inputStream!=null)
            {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return jsonResponse;
    }

    private String readFromStream(InputStream in)
    {
        StringBuilder output = new StringBuilder();
        if(in!=null)
        {
            InputStreamReader inputStreamReader = new InputStreamReader(in, Charset.forName("UTF-8"));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            try {
                String line = bufferedReader.readLine();
                while(line!=null)
                {
                    output.append(line);
                    line = bufferedReader.readLine();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return output.toString();
    }

    private ArrayList<Event> extractFeatureFromJson(String jsonresp)
    {
        ArrayList<Event> NEWS = new ArrayList<Event>();
        try {
            JSONObject baseJSONresp = new JSONObject(jsonresp);
            JSONArray ArticleArr = baseJSONresp.getJSONArray("articles");
            int i =0;

            while(i<ArticleArr.length())
            {
                JSONObject news = ArticleArr.getJSONObject(i);
                String title = news.getString("title");
                String url = news.getString("url");
                String publishedAt =news.getString("publishedAt");
                NEWS.add(new Event(title,url,publishedAt));
                i++;

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return NEWS;

    }
}
