package io.travelaid.util

import android.support.annotation.NonNull

/**
 * Project : max-travel-aid
 * Created by Dennis Bilson on Wed at 6:55 PM.
 * Package name : io.travelaid.util
 *
 * Class that helps to determin a user type once they are signed in
 */
enum class UserType(@NonNull val type: String) {
	/**
	 * Driver user type
	 */
	DRIVER("driver"),
	/**
	 * Passenger user type
	 */
	PASSENGER("passenger")
}