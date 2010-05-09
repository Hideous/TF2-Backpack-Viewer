/*****************
 * Copyright 2010 Andreas Jörgensen
 * admin@hideou.se
 * This program is distributed under the terms of the GNU General Public License.
 * 
 * 
 *  This file is part of TF2 Backpack Viewer.
 *
 *  TF2 Backpack Viewer is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  TF2 Backpack Viewer is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with TF2 Backpack Viewer.  If not, see <http://www.gnu.org/licenses/>.
 *****************/

package com.hideous.backpack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class BackpackAdapter extends BaseAdapter
{
	private Context mContext;
	private JSONObject json;
	public ArrayList<TF2Item> backpackItems;
	private String jsondata;
	private ProgressDialog loadingJson;
	
	public BackpackAdapter(Context c)
	{
		mContext = c;
		
		backpackActivity.numHats = 0;
		backpackActivity.numWeapons = 0;
		backpackActivity.numCraftables = 0;
		backpackActivity.numMisc = 0;
		loadingJson = ProgressDialog.show(c, "", "Loading backpack data...", true);
		new DownloadJSONTask().execute("ohshit");
		
	}
	
	private class DownloadJSONTask extends AsyncTask<String, Integer, Boolean>
	{
		protected Boolean doInBackground(String... strings)
		{
			Log.i("TF2 Items", "Entering second thread thingy");
			String url = "http://www.steamcommunity.com/id/"
				.concat(usernameActivity.vanityId)
				.concat("/tfitems?json=1");
			
			HttpClient httpclient = new DefaultHttpClient();
			HttpGet httpget = new HttpGet(url);
			
			HttpResponse response;
			
			try
			{
				response = httpclient.execute(httpget);
				
				HttpEntity entity = response.getEntity();
				
				backpackItems = new ArrayList<TF2Item>();
				
				if (entity != null)
				{
					InputStream instream = entity.getContent();
					jsondata = convertStreamToString(instream);
					
					json = new JSONObject(jsondata);
					
					JSONArray nameArray = json.names();
					JSONArray valArray = json.toJSONArray(nameArray);
					for (int i=0; i < valArray.length(); i++)
					{
						JSONObject itemjson = valArray.getJSONObject(i);
						int itemid = itemjson.getInt("defindex");
						int level = itemjson.getInt("level");
						int quality = itemjson.getInt("quality");
						if (itemid == 164 || itemid == 165 || itemid == 166 || itemid == 170)
						{
							JSONObject timeArray = itemjson.getJSONObject("attributes");
							int timestamp = timeArray.getInt("143");
							backpackItems.add(new TF2Item(itemid, level, quality, 
									timestamp));
						}
						else
						{
							backpackItems.add(new TF2Item(itemid, level, quality));
						}
						
					}
				}
				publishProgress(100);
				loadingJson.dismiss();
				return true;
			}
			catch (JSONException je)
			{
				//je.printStackTrace();
				
				return false;
			} 
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				//e.printStackTrace();
				return false;
			}
		}
		
		protected void onProgressUpdate(Integer... progress)
		{
			Log.i("TF2 Items", progress[0].toString());
		}
		
		protected void onPostExecute(Boolean result)
		{
			//Log.i("TF2 Items", "Data loaded, entered onPostExecute");
			loadingJson.dismiss();
			notifyDataSetChanged();
			
			if (result == false)
			{
				Activity currActivity = (Activity) mContext;
				currActivity.showDialog(backpackActivity.FAILED);
			}
		}
	}
	
	private static String convertStreamToString(InputStream is) {
        /*
         * To convert the InputStream to String we use the BufferedReader.readLine()
         * method. We iterate until the BufferedReader return null which means
         * there's no more data to read. Each line will appended to a StringBuilder
         * and returned as String.
         */
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
 
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		if (backpackItems == null) return 0;
		
		return backpackItems.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TF2ItemView imageView;
		if (convertView == null)
		{
			imageView = new TF2ItemView(mContext, backpackItems.get(position));
			imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
			imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
			imageView.setPadding(3, 3, 3, 3);
		}
		else
		{
			imageView = (TF2ItemView) convertView;
			imageView.item = backpackItems.get(position);
		}
		
		imageView.resetDrawableToItem();
		/*Log.i("itemslol", "Position ".concat(Integer.toString(position).concat(", Item is ")
				.concat(imageView.item.itemname)));*/
		return imageView;
	}

}
