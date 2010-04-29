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
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class backpackActivity extends Activity
{
	public static final int FAILED = 1,
	DLG_ITEMINFO = 2,
	MENU_REFRESH = 50,
	MENU_STATS = 51;
	
	public static int
	numHats,
	numWeapons,
	numCraftables;
	
	public static int positionClicked;
	
	private final int DLG_STATS = 256;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.backpack);
		
		GridView gridview = (GridView) findViewById(R.id.gridview);
		gridview.setAdapter(new BackpackAdapter(this));
		
		gridview.setOnItemClickListener(
				new AdapterView.OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView parent, View v,
							int position, long id) {
						// TODO Auto-generated method stub
						positionClicked = position;
						showDialog(DLG_ITEMINFO);
						
					}
				});
	}
	
	public boolean onCreateOptionsMenu(Menu menu)
	{
		menu.add(0, MENU_REFRESH, 0, "Refresh" );
		menu.add(0, MENU_STATS, 0, "Stats" );
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
			case MENU_REFRESH:
				GridView gridview = (GridView) findViewById(R.id.gridview);
				gridview.setAdapter(new BackpackAdapter(this));
				return true;
			case MENU_STATS:
				showDialog(DLG_STATS);
				return true;
		}
		return false;
	}
	
	protected void onPrepareDialog(int id, Dialog dialog)
	{
		switch (id)
		{
			case DLG_ITEMINFO:
				
				GridView gridview = (GridView) findViewById(R.id.gridview);
				BackpackAdapter adapter = (BackpackAdapter) gridview.getAdapter();
				
				TF2Item item = adapter.backpackItems.get(positionClicked);
					
				Dialog itemDialog = dialog;
				itemDialog.setTitle(item.itemname);
				
				TextView text = (TextView) itemDialog.findViewById(R.id.dialogtext);
				String attribText = "";
				for (int i = 0; i < item.attributes.size(); i++)
				{
					attribText = attribText.concat(item.attributes.get(i).description);
					attribText = attribText.concat("\n");
					Log.i("TF2 Items", item.attributes.get(i).description);
				}
				
				text.setText(attribText);
				Log.i("TF2 Items", attribText);
				
				
				
				ImageView image = (ImageView) itemDialog.findViewById(R.id.dialogimage);
				image.setImageResource(item.drawable);
				
				
				break;
			case DLG_STATS:
				AlertDialog dlg = (AlertDialog) dialog;
				dlg.setMessage("Weapons: " + numWeapons + "\n" +
						"Hats: " + numHats + "\n" +
						"Craftables: " + numCraftables);
				break;
		}
	}
	
	protected Dialog onCreateDialog(int id)
	{
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		if (id == FAILED)
		{
			builder
			.setMessage("Profile is either private or it does not exist.")
			.setNeutralButton("OK",new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Intent intent = new Intent();
					setResult(RESULT_OK, intent);
					finish();
					
				}
			});
			return builder.show();
		}
		if (id == DLG_ITEMINFO)
		{
			//Context mContext = getApplicationContext();
			
			Dialog itemDialog = new Dialog(this);
			itemDialog.setContentView(R.layout.itemdialog);
			
			return itemDialog;
		}
		else if (id == DLG_STATS)
		{
			builder.setMessage("")
			.setNeutralButton("OK", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// Don't do shit, this is a dialog with nothin' but info.
					return;
				}
			});
			return builder.show();
		}
		return null;
	}
}
