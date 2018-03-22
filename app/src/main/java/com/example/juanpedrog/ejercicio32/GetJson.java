package com.example.juanpedrog.ejercicio32;
import android.os.AsyncTask;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by juanpedrog on 19/03/18.
 */

public class GetJson extends AsyncTask<Void,Void,Void> {
    String data="";
    String name="",id="";
    String singleParced="";

    @Override
    protected Void doInBackground(Void... voids) {
        try{
            URL url=new URL("https://graph.facebook.com/"+MainActivity.input.getText().toString()+"?access_token=EAACEdEose0cBACK4NplDzZBEeZBrTezyylFN4VDla5rpOWc4Kt15uF2ZAyhogN4RVskAQLETiuR3MIM7vH4jld9jlROUhj623PCDF2qynJeiYqZClWpCZCnih5WbZB4UwglVXFnCwKBSJGaqOTDEdBJroL60CLHbjCZAZCosFPCSxebVJdnGCbGivPsJiWwcaAqJGgiZAdBkIawZDZD");
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            InputStream inputStream=httpURLConnection.getInputStream();
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
            String line="";
            while(line!=null){
                line=bufferedReader.readLine();
                data+=line;
            }
            JSONObject JO=new JSONObject(data);
            name="Nombre: "+JO.get("name");
            id="Id: "+JO.get("id");

        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        MainActivity.data.setText(name);
        MainActivity.id.setText(id);

    }
}
