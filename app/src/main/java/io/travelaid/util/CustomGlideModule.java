package io.travelaid.util;

import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

/**
 * Project : max-travel-aid
 * Created by Dennis Bilson on Wed at 8:22 PM.
 * Package name : io.travelaid.util
 *
 * Glide module for loading images
 */

@GlideModule
public class CustomGlideModule extends AppGlideModule {
	@Override
	public boolean isManifestParsingEnabled() {
		return false;
	}
}
