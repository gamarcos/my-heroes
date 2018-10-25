package br.com.doghero.dhproject.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Gabriel Marcos on 20/10/2018
 */
data class UserModel(@SerializedName("first_name")val firstName: String,
                     @SerializedName("image_url")val imageUrl: String)