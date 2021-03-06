package org.witness.informacam.utils;

import org.json.JSONException;
import org.json.JSONObject;
import org.witness.informacam.utils.Constants.Media.Manifest;

import android.graphics.Bitmap;

public class MediaManagerUtility {
	public static final class MediaManagerDisplay extends JSONObject {
		public String baseId;
		Bitmap thumbnail;
		
		public MediaManagerDisplay(JSONObject manifest) {
			try {
				if(manifest.has(Manifest.Keys.ALIAS))
					this.put(Manifest.Keys.ALIAS, manifest.getString(Manifest.Keys.ALIAS));
				else
					this.put(Manifest.Keys.ALIAS, manifest.getString(Manifest.Keys.LOCATION_OF_ORIGINAL));
				
				put(Manifest.Keys.LOCATION_OF_ORIGINAL, manifest.getString(Manifest.Keys.LOCATION_OF_ORIGINAL));
				
				baseId = getString(Manifest.Keys.LOCATION_OF_ORIGINAL).split("/original.")[0].substring(1);
				
				put(Manifest.Keys.LAST_SAVED, manifest.getLong(Manifest.Keys.LAST_SAVED));
				put(Manifest.Keys.SIZE, manifest.getInt(Manifest.Keys.SIZE));
				put(Manifest.Keys.LENGTH, manifest.getInt(Manifest.Keys.LENGTH));
				put(Manifest.Keys.WIDTH, manifest.getInt(Manifest.Keys.WIDTH));
				put(Manifest.Keys.MEDIA_TYPE, manifest.getInt(Manifest.Keys.MEDIA_TYPE));
				
				if(manifest.has(Manifest.Keys.DURATION))
					put(Manifest.Keys.DURATION, manifest.getInt(Manifest.Keys.DURATION));
				
				if(manifest.has(Manifest.Keys.THUMBNAIL))
					put(Manifest.Keys.THUMBNAIL, manifest.getString(Manifest.Keys.THUMBNAIL));
				
			} catch(JSONException e) {}
		}
	}
}
