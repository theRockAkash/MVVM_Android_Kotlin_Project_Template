package com.dkm.app.utils

import com.dkm.app.BuildConfig

/**
 * Created by akash on 11/21/2023.
 * Know more about author on <a href="https://akash.cloudemy.in">...</a>
 */
object Constants {

    val BASE_URL: String
        get() {
            return if (BuildConfig.DEBUG)
                "http://www.google.com"
            else "http://www.google.com"
        }


    const val TAG = "DKM TAG"

}