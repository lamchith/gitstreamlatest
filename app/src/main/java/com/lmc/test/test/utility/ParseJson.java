package com.lmc.test.test.utility;

import android.util.JsonReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lmarathchathu on 15/11/2016.
 */
public class ParseJson {

    public ArrayList<Details> parsejson(InputStream in){
        ArrayList<Details> list=new ArrayList<Details>();

        try {
            JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
            try {
                reader.beginArray();

                while(reader.hasNext()){

                        reader.beginObject();
                    Details details=new Details();
                        while(reader.hasNext()){

                                String name =reader.nextName();

                                if(name.equals("repo")){
                                    getRepoDetails(reader,details);
                                }
                                else if(name.equals("type")){
                                    details.eventType=reader.nextString();
                                }

                                else{
                                    reader.skipValue();
                                }

                        }
                    list.add(details);
                        reader.endObject();




                }

                reader.endArray();
            } catch (IOException e) {
                e.printStackTrace();
            }


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    return list;
    }

    private Details getRepoDetails(JsonReader reader, Details details){

        try {
            reader.beginObject();
            while(reader.hasNext()){



                    String name =reader.nextName();

                    if(name.equals("name")){
                        details.repoName=reader.nextString();
                    }
                    else if(name.equals("url")){
                        details.repoUrl=reader.nextString();
                    }

                    else{
                        reader.skipValue();
                    }


            }
            reader.endObject();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return details;
    }




}
