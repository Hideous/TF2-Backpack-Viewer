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

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

public class usernameActivity extends Activity
{
    /** Called when the activity is first created. */
	
	public static String vanityId;
	
	private final int DLG_STRING = 0,
	DLG_CONNECT = 1;
	
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //this.setTitle("TF2 Backpack");
        
        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(usernameActivity.this);
        
        String name = prefs.getString("vanityid", "");
        
        Button submit = (Button) findViewById(R.id.submitButton);
        AutoCompleteTextView text = (AutoCompleteTextView) findViewById(R.id.nameField);
        text.setText(name);
        text.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(usernameActivity.this);
			        
			    String name = prefs.getString("vanityid", "");
			    
			    AutoCompleteTextView text = (AutoCompleteTextView) findViewById(R.id.nameField);
				// TODO Auto-generated method stub
				if (text.getSelectionStart() == text.getSelectionEnd()
						&& text.getSelectionStart() == -1 && text.getText().toString() == name)
					text.setText("");
			}
		});
        
        //TODO: Auto-completion. It's a tricky son of a bitch.
        //text.setAdapter(new PrefsAdapter());
        
        submit.setOnClickListener(
    		new View.OnClickListener()
	        {
				
				@Override
				public void onClick(View v)
				{
					ConnectivityManager connmgr =  (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
					Log.i("TF2 Items", "---------- RELOADING ----------");
					AutoCompleteTextView text = (AutoCompleteTextView) findViewById(R.id.nameField);
					vanityId = text.getText().toString();
					
					Editor edit = prefs.edit();
					edit.putString("vanityid", vanityId);
					edit.commit();
					
					if (vanityId.length() == 0)
					{
						showDialog(DLG_STRING);
					}
					else if (!connmgr.getNetworkInfo(0).isConnected() &&
							!connmgr.getNetworkInfo(1).isConnected())
					{
						showDialog(DLG_CONNECT);
					}
					else
					{	
						Intent myIntent = new Intent(v.getContext(), backpackActivity.class);
						startActivityForResult(myIntent, 0);
					}
				}
			}
    	);
    }
    
    protected Dialog onCreateDialog(int id)
    {
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	switch (id)
    	{
    		case DLG_STRING:
    			builder.setMessage("Please enter a Steam Vanity ID.")
    			.setNeutralButton("OK", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						return;
					}
				});
    			break;
    			
    		case DLG_CONNECT:
    			builder.setMessage("Could not connect to the internet.")
    			.setNeutralButton("OK", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						return;
					}
				});
    			break;
    	}
    	return builder.show();
    }
}