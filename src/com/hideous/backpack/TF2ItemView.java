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

import android.content.Context;

public class TF2ItemView extends android.widget.ImageView {

	public TF2Item item;
	
	public TF2ItemView(Context context, TF2Item item) {
		super(context);
		// TODO Auto-generated constructor stub
		this.item = item;
	}
	
	public void resetDrawableToItem()
	{
		setImageResource(item.drawable);
	}
	

}
