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

import java.util.ArrayList;

import android.text.format.Time;
import android.util.Log;

public class TF2Item
{
	public String itemname;
	public int level;
	public ArrayList<TF2ItemAttribute> attributes;
	public int drawable;
	public int id;
	public int imageresource;
	public int quality;
	
	public static final int
	NEGATIVE = -1,
	NEUTRAL = 0,
	POSITIVE = 1;
	
	public TF2Item(int itemid, int lvl, int quality)
	{
		id = itemid;
		level = lvl;
		this.quality = quality;
		attributes = new ArrayList<TF2ItemAttribute>();
		setItemById();
	}
	
	public TF2Item(int itemid, int lvl, int quality, int timestamp) {
		// TODO Auto-generated constructor stub
		id = itemid;
		level = lvl;
		this.quality = quality;
		attributes = new ArrayList<TF2ItemAttribute>();
		setTimestampId(timestamp);
	}

	private void setTimestampId(int timestamp) {
		// TODO Auto-generated method stub
		String qualname = "";
		switch (quality)
		{
			case 7:
				qualname = "Community ";
				break;
			case 8:
				qualname = "Valve ";
				break;
			case 9:
				qualname = "Self-made ";
				break;
		}
		
		switch (id)
		{
			case 164:
				itemname = "Grizzled Veteran";
				drawable = R.drawable.item_all_goldmedal;
				break;
			case 165:
				itemname = "Soldier of Fortune";
				drawable = R.drawable.item_all_silvermedal;
				break;
			case 166:
				itemname = "Mercenary";
				drawable = R.drawable.item_all_bronzemedal;
				break;
			case 170:
				itemname = "Primeval Warrior";
				drawable = R.drawable.item_all_platinummedal;
				break;
		}
		
		long tt = timestamp;
		
		Time t = new Time("GMT");
		t.set(tt * 1000);
		
		add(NEUTRAL, "Hire Date: " + t.format("%B %e, %Y (%T) GMT"));
		
		itemname = qualname.concat(itemname);
		
		backpackActivity.numMisc += 1;
	}

	private void add(int pos, String desc)
	{
		attributes.add(new TF2ItemAttribute(pos, desc));
	}
	
	private void setItemById()
	{
		String qualname = "";
		switch (quality)
		{
			case 7:
				qualname = "Community ";
				break;
			case 8:
				qualname = "Valve ";
				break;
			case 9:
				qualname = "Self-made ";
				break;
		}
		switch (id)
		{
			case 0:
				itemname = "Bat";
				drawable = R.drawable.item_scout_bat;
				break;
			case 1:
				itemname = "Bottle";
				drawable = R.drawable.item_demoman_bottle;
				break;
			case 2:
				itemname = "Axe";
				drawable = R.drawable.item_pyro_axe;
				break;
			case 3:
				itemname = "Kukri";
				drawable = R.drawable.item_sniper_kukri;
				break;
			case 4:
				itemname = "Knife";
				drawable = R.drawable.item_spy_knife;
				break;
			case 5:
				itemname = "Fists";
				drawable = R.drawable.item_heavy_fists;
				break;
			case 6:
				itemname = "Shovel";
				drawable = R.drawable.item_soldier_shovel;
				break;
			case 7:
				itemname = "Wrench";
				drawable = R.drawable.item_engineer_wrench;
				break;
			case 8:
				itemname = "Bonesaw";
				drawable = R.drawable.item_medic_bonesaw;
				break;
			case 9:
			case 10:
			case 11:
			case 12:
				itemname = "Shotgun";
				drawable = R.drawable.item_shotgun;
				break;
			case 13:
				itemname = "Scattergun";
				drawable = R.drawable.item_scout_scattergun;
				break;
			case 14:
				itemname = "Sniper Rifle";
				drawable = R.drawable.item_sniper_rifle;
				break;
			case 15:
				itemname = "Minigun";
				drawable = R.drawable.item_heavy_minigun;
				break;
			case 16:
				itemname = "SMG";
				drawable = R.drawable.item_sniper_smg;
				break;
			case 17:
				itemname = "Syringe gun";
				drawable = R.drawable.item_medic_syringegun;
				break;
			case 18:
				itemname = "Rocket Launcher";
				drawable = R.drawable.item_soldier_rocketlauncer;
				break;
			case 19:
				itemname = "Grenade Launcher";
				drawable = R.drawable.item_demoman_pipelauncher;
				break;
			case 20:
				itemname = "Sticky Launcher";
				drawable = R.drawable.item_demoman_stickybomb;
				break;
			case 21:
				itemname = "Flamethrower";
				drawable = R.drawable.item_pyro_flamethrower;
			case 22:
			case 23:
				itemname = "Pistol";
				drawable = R.drawable.item_pistol;
				break;
			case 24:
				itemname = "Revolver";
				drawable = R.drawable.item_spy_revolver;
				break;
			case 25:
				itemname = "Build PDA";
				drawable = R.drawable.item_engineer_pda;
				break;
			case 26:
				itemname = "Destroy PDA";
				drawable = R.drawable.item_engineer_pda;
				break;
			case 27:
				itemname = "Disguise Kit";
				drawable = R.drawable.item_spy_cigarette;
				break;
			case 28:
				itemname = "Engineer Builder";
				drawable = R.drawable.item_engineer_pda;
				break;
			case 29:
				itemname = "Medigun";
				drawable = R.drawable.item_medic_medigun;
				break;
			case 30:
				itemname = "Invisibility Watch";
				drawable = R.drawable.item_spy_watch;
				break;
			case 31:
			case 39:
				itemname = "Flaregun";
				drawable = R.drawable.item_pyro_flaregun;
				break;
			case 35:
			case 34:
				itemname = "The Kritzkrieg";
				drawable = R.drawable.item_medic_kritzkrieg;
				add(NEUTRAL, "Ubercharge grants 100% critical chance");
				add(POSITIVE, "+25% ubercharge rate");
				break;
			case 36:
			case 33:
				itemname = "Blutsauger";
				drawable = R.drawable.item_medic_blutsauger;
				add(POSITIVE, "On Hit: +3 health");
				add(NEGATIVE, "-2 health drained per second on wearer");
				break;
			case 37:
			case 32:
				itemname = "Ubersaw";
				drawable = R.drawable.item_medic_ubersaw;
				add(POSITIVE, "On Hit: 25% ubercharge added");
				add(NEGATIVE, "-20% slower firing speed");
				break;
			case 38:
				itemname = "Axtinguisher";
				drawable = R.drawable.item_pyro_axtinguisher;
				add(POSITIVE, "100% critical hit vs burning players");
				add(NEGATIVE, "-50% damage vs non-burning players");
				add(NEGATIVE, "No critical hits vs non-burning players");
				break;
			case 40:
				itemname = "The Backburner";
				drawable = R.drawable.item_pyro_backburner;
				add(NEGATIVE, "No compression blast");
				add(POSITIVE, "100% critical hits from behind");
				break;
			case 41:
				itemname = "Natascha";
				drawable = R.drawable.item_heavy_natascha;
				add(POSITIVE, "On hit: 100% chance to slow target");
				add(NEGATIVE, "-25% damage done");
				break;
			case 42:
				itemname = "Sandvich";
				drawable = R.drawable.item_heavy_sandvich;
				break;
			case 43:
				itemname = "Killing Gloves of Boxing";
				drawable = R.drawable.item_heavy_kgb;
				add(POSITIVE, "On Kill: 5 seconds of 100% critical chance");
				add(NEGATIVE, "-20% slower firing speed");
				break;
			case 44:
				itemname = "The Sandman";
				drawable = R.drawable.item_scout_sandman;
				add(POSITIVE, "This bat knocks out a mean stun ball");
				add(NEGATIVE, "-15 max health on wearer");
				break;
			case 45:
				itemname = "Force-A-Nature";
				drawable = R.drawable.item_scout_fan;
				add(POSITIVE, "Knockback on the target and shooter");
				add(POSITIVE, "+50% faster firing speed");
				add(POSITIVE, "+20% bullets per shot");
				add(NEGATIVE, "-10% damage done");
				add(NEGATIVE, "-60% clip size");
				break;
			case 46:
				itemname = "Bonk! Atomic Punch";
				drawable = R.drawable.item_scout_bonk;
				break;
			case 47:
				itemname = "Demoman's Fro";
				drawable = R.drawable.item_demoman_afro;
				break;
			case 48:
				itemname = "Mining Light";
				drawable = R.drawable.item_engineer_mining;
				break;
			case 49:
				itemname = "Football Helmet";
				drawable = R.drawable.item_heavy_football;
				break;
			case 50:
				itemname = "Prussian Pickelhaube";
				drawable = R.drawable.item_medic_pickelhaube;
				break;
			case 51:
				itemname = "Pyro's Beanie";
				drawable = R.drawable.item_pyro_beanie;
				break;
			case 52:
				itemname = "Batter's Helmet";
				drawable = R.drawable.item_scout_batter;
				break;
			case 53:
				itemname = "Trophy Belt";
				drawable = R.drawable.item_sniper_trophybelt;
				break;
			case 54:
				itemname = "Soldier's Stash";
				drawable = R.drawable.item_soldier_stash;
				break;
			case 55:
				itemname = "Fancy Fedora";
				drawable = R.drawable.item_spy_fedora;
				break;
			case 56:
				itemname = "The Huntsman";
				drawable = R.drawable.item_sniper_huntsman;
				break;
			case 57:
				itemname = "The Razorback";
				drawable = R.drawable.item_sniper_razorback;
				add(POSITIVE, "Blocks a single backstab attempt");
				break;
			case 58:
				itemname = "Jarate";
				drawable = R.drawable.item_sniper_jarate;
				break;
			case 59:
				itemname = "Dead Ringer";
				drawable = R.drawable.item_spy_deadringer;
				add(NEUTRAL, "Cloak Type: Feign Death");
				add(NEGATIVE, "+60% cloak drain rate");
				add(POSITIVE, "+80% cloak regen rate");
				break;
			case 60:
				itemname = "Cloak and Dagger";
				drawable = R.drawable.item_spy_cnd;
				add(NEUTRAL, "Cloak Type: Motion Sensitive");
				add(POSITIVE, "+100% cloak regen rate");
				break;
			case 61:
				itemname = "The Ambassador";
				drawable = R.drawable.item_spy_ambassador;
				add(POSITIVE, "Crits on an accurate headshot");
				add(NEGATIVE, "-15% damage done");
				add(NEGATIVE, "-20% slower firing speed");
				break;
			case 94:
				itemname = "Texas Ten Gallon";
				drawable = R.drawable.item_engineer_cowboy;
				break;
			case 95:
				itemname = "Engineer's Cap";
				drawable = R.drawable.item_engineer_cap;
				break;
			case 96:
				itemname = "Officer's Ushanka";
				drawable = R.drawable.item_heavy_ushanka;
				break;
			case 97:
				itemname = "Tough Guy's Toque";
				drawable = R.drawable.item_heavy_jayne;
				break;
			case 98:
				itemname = "Stainless Pot";
				drawable = R.drawable.item_soldier_pot;
				break;
			case 99:
				itemname = "Tyrant's Helm";
				drawable = R.drawable.item_soldier_viking;
				break;
			case 100:
				itemname = "Glengarry Bonnet";
				drawable = R.drawable.item_demoman_scotsman;
				break;
			case 101:
				itemname = "Vintage Tyrolean";
				drawable = R.drawable.item_medic_tyrolean;
				break;
			case 102:
				itemname = "Respectless Rubber Glove";
				drawable = R.drawable.item_pyro_glove;
				break;
			case 103:
				itemname = "Camera Beard";
				drawable = R.drawable.item_spy_beard;
				break;
			case 104:
				itemname = "Otolaryngologist's mirror";
				drawable = R.drawable.item_medic_mirror;
				break;
			case 105:
				itemname = "Brigade Helm";
				drawable = R.drawable.item_pyro_brigade;
				break;
			case 106:
				itemname = "Bonk Helm";
				drawable = R.drawable.item_scout_bonkhelmet;
				break;
			case 107:
				itemname = "Ye Olde Baker Boy";
				drawable = R.drawable.item_scout_bakerboy;
				break;
			case 108:
				itemname = "Backbiter's Billycock";
				drawable = R.drawable.item_spy_billycock;
				break;
			case 109:
				itemname = "Professional's Panama";
				drawable = R.drawable.item_sniper_panama;
				break;
			case 110:
				itemname = "Master's Yellow Belt";
				drawable = R.drawable.item_sniper_headband;
				break;
			case 111:
				itemname = "Baseball Bill's Sports Shine";
				drawable = R.drawable.item_scout_hatless;
				break;
			case 115:
				itemname = "Mildly Disturbing Halloween Mask";
				drawable = R.drawable.item_all_halloween;
				break;
			case 116:
				itemname = "Ghastly Gibus";
				drawable = R.drawable.item_all_gibus;
				break;
			case 117:
				itemname = "Ritzy Rick's Hair Fixative";
				drawable = R.drawable.item_sniper_hatless;
				break;
			case 118:
				itemname = "Texas Slim's Dome Shine";
				drawable = R.drawable.item_engineer_hatless;
				break;
			case 120:
				itemname = "Scotsman's Stove Pipe";
				drawable = R.drawable.item_demoman_tophat;
				break;
			case 121:
				itemname = "Gentle Manne's Service Medal";
				drawable = R.drawable.item_soldier_medal;
				break;
			case 125:
				itemname = "Cheater's Lament";
				drawable = R.drawable.item_all_halo;
				break;
			case 126:
				itemname = "Bill's Hat";
				drawable = R.drawable.item_all_bill;
				break;
			case 127:
				itemname = "The Direct Hit";
				drawable = R.drawable.item_soldier_directhit;
				add(NEGATIVE, "-70% explosion radius");
				add(POSITIVE, "+80% projectile speed");
				add(POSITIVE, "+25% damage done");
				add(POSITIVE, "Mini-crits airborne targets");
				break;
			case 128:
				itemname = "The Equalizer";
				drawable = R.drawable.item_soldier_equalizer;
				add(POSITIVE, "Damage and move speed increases as the user becomes injured");
				break;
			case 129:
				itemname = "The Buff Banner";
				drawable = R.drawable.item_soldier_buffbanner;
				break;
			case 130:
				itemname = "Scottish Resistance";
				drawable = R.drawable.item_demoman_scores;
				add(POSITIVE, "Detonates stickybombs near the crosshair");
				add(POSITIVE, "Able to destroy enemy stickybombs");
				add(POSITIVE, "+50% max secondary ammo on wearer");
				add(POSITIVE, "+6 max pipebombs out");
				add(NEGATIVE, "0.4 sec slower bomb arm time");
				break;
			case 131:
				itemname = "The Chargin' Targe";
				drawable = R.drawable.item_demoman_shield;
				add(NEUTRAL, "Alt-Fire: Gain increased attack power by charging toward your enemies");
				add(POSITIVE, "+50% fire damage resistance on wearer");
				add(POSITIVE, "+50% explosive damage resistance on wearer");
				break;
			case 132:
				itemname = "The Eyelander";
				drawable = R.drawable.item_demoman_eyelander;
				add(NEUTRAL, "This weapon has a large melee range.");
				add(NEUTRAL, "Gives increased speed and health with every head you take.");
				add(NEGATIVE, "No random critical hits");
				add(NEGATIVE, "-25 max health on wearer");
				break;
			case 133:
				itemname = "The Gunboats";
				drawable = R.drawable.item_soldier_gunboats;
				add(POSITIVE, "-75% blast damage from rocket jumps");
				break;
			case 134:
				itemname = "J Axer's Dapper Topper";
				drawable = R.drawable.item_all_pillarwinner;
				add(NEUTRAL, "First Place Winner, Propaganda Contest");
				break;
			case 135:
				itemname = "Towering Pillar of Hats";
				drawable = R.drawable.item_all_pillar;
				break;
			case 136:
				itemname = "Amber's Rad As All Hell Hat";
				drawable = R.drawable.item_all_amassmentwinner;
				add(NEUTRAL, "First Runner-Up, Propaganda Contest");
				break;
			case 137:
				itemname = "Noble Amassment of Hats";
				drawable = R.drawable.item_all_amassment;
				break;
			case 138:
				itemname = "Uncle Sam";
				drawable = R.drawable.item_all_pilewinner;
				add(NEUTRAL, "Second Runner-Up, Propaganda Contest");
				break;
			case 139:
				itemname = "Modest Pile of Hat";
				drawable = R.drawable.item_all_pile;
				break;
			case 144:
				itemname = "Physician's Procedure Mask";
				drawable = R.drawable.item_medic_mask;
				break;
			case 145:
				itemname = "The Hound Dog";
				drawable = R.drawable.item_heavy_hounddog;
				break;
			case 146:
				itemname = "Hustler's Hallmark";
				drawable = R.drawable.item_demoman_pimphat;
				break;
			case 147:
				itemname = "Magistrate's Mullet";
				drawable = R.drawable.item_spy_wig;
				break;
			case 148:
				itemname = "Hotrod";
				drawable = R.drawable.item_engineer_welding;
				break;
			case 150:
				itemname = "Troublemaker's Tossle Cap";
				drawable = R.drawable.item_scout_beanie;
				break;
			case 151:
				itemname = "Triboniophorus Tyrannus";
				drawable = R.drawable.item_pyro_brainsucker;
				break;
			case 152:
				itemname = "Killer's Kabuto";
				drawable = R.drawable.item_soldier_samurai;
				break;
			case 153:
				itemname = "The Homewrecker";
				drawable = R.drawable.item_pyro_homewrecker;
				add(POSITIVE, "100% damage vs buildings");
				add(NEGATIVE, "-25% damage vs players");
				break;
			case 154:
				itemname = "The Pain Train";
				drawable = R.drawable.item_demoman_paintrain;
				add(POSITIVE, "+1 capture rate on wearer");
				add(NEGATIVE, "10% bullet damage vulnerability on wearer");
				break;
			case 158:
				itemname = "Shooter's Sola Topi";
				drawable = R.drawable.item_sniper_helmet;
				break;
			case 159: 
				itemname = "The Dalokosh Bar";
				drawable = R.drawable.item_heavy_chocolate;
				add(POSITIVE, "Adds +50 max health for 30 seconds");
				break;
			//Crafting objects
			case 5000:
				itemname = "Scrap Metal";
				drawable = R.drawable.item_crafting_scrap;
				break;
			case 5001:
				itemname = "Reclaimed Metal";
				drawable = R.drawable.item_crafting_reclaimed;
				break;
			case 5002:
				itemname = "Refined Metal";
				drawable = R.drawable.item_crafting_refined;
				break;
			case 5003:
				itemname = "Scout Class Token";
				drawable = R.drawable.item_crafting_scout;
				break;
			case 5004:
				itemname = "Sniper Class Token";
				drawable = R.drawable.item_crafting_sniper;
				break;
			case 5005:
				itemname = "Soldier Class Token";
				drawable = R.drawable.item_crafting_soldier;
				break;
			case 5006:
				itemname = "Demoman Class Token";
				drawable = R.drawable.item_crafting_demoman;
				break;
			case 5007:
				itemname = "Heavy Class Token";
				drawable = R.drawable.item_crafting_heavy;
				break;
			case 5008:
				itemname = "Medic Class Token";
				drawable = R.drawable.item_crafting_medic;
				break;
			case 5009:
				itemname = "Pyro Class Token";
				drawable = R.drawable.item_crafting_pyro;
				break;
			case 5010:
				itemname = "Spy Class Token";
				drawable = R.drawable.item_crafting_spy;
				break;
			case 5011:
				itemname = "Engineer Class Token";
				drawable = R.drawable.item_crafting_engineer;
				break;
			case 5012:
				itemname = "Primary Slot Token";
				drawable = R.drawable.item_crafting_primary;
				break;
			case 5013:
				itemname = "Secondary Slot Token";
				drawable = R.drawable.item_crafting_secondary;
				break;
			case 5014:
				itemname = "Melee Slot Token";
				drawable = R.drawable.item_crafting_melee;
				break;
			case 5015:
				itemname = "Grenade Slot Token";
				drawable = R.drawable.item_demoman_bottle;
				break;
			case 5016:
				itemname = "Building Slot Token";
				drawable = R.drawable.item_demoman_bottle;
				break;
			case 5017:
				itemname = "PDA Slot Token";
				drawable = R.drawable.item_crafting_pda;
				break;
			case 5018:
				itemname = "PDA2 Slot Token";
				drawable = R.drawable.item_crafting_pda;
				break;
			case 5019:
				itemname = "Head Slot Token";
				drawable = R.drawable.item_demoman_bottle;
				break;
				
			//Sam & Max items
			case 160:
				itemname = "The Lugermorph";
				drawable = R.drawable.item_scout_maxgun;
				add(NEUTRAL, "The ultimate in semi-concealed weaponry. There's no question you need this gun, the only question is: Where will you keep it?");
				break;
			case 161:
				itemname = "The Big Kill";
				drawable = R.drawable.item_spy_samgun;
				add(NEUTRAL,
						"Combines style with stopping power. Long exclusive to the Freelance Police, now available for other blood-thirsty mercenaries.");
				break;
			case 162:
				itemname = "Max's Severed Head";
				drawable = R.drawable.item_all_maxhead;
				add(NEUTRAL,
						"Expertly crafted headwear from cruelty-free farms in the Philippines. Hollowed-out skull casing wicks moisture away when in the heat of battle.");
				break;
				
			case 163:
				itemname = "Crit-a-Cola";
				drawable = R.drawable.item_scout_critcola;
				add(NEUTRAL,
						"While under the effects, damage done and damage taken will be mini-crits.");
				break;
				
			default:
				itemname = "Unknown item ".concat(Integer.toString(id));
				drawable = R.drawable.item_unknown;
				break;
				
		}//End switch
		itemname = qualname.concat(itemname);
		Log.i("TF2 Items", itemname);
		
		if (id <= 46 || (id >= 56 && id <= 61) || (id >= 127 && id <= 133) || (id >= 153 && id <= 163 && id != 162))
			backpackActivity.numWeapons += 1;
		else if (id == 103 || id == 144 || id == 121)
			backpackActivity.numMisc += 1;
		else if (id < 5000)
			backpackActivity.numHats += 1;
		else
			backpackActivity.numCraftables += 1;
	}
}
