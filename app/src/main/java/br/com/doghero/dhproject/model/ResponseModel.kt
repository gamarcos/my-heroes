package br.com.doghero.dhproject.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Gabriel Marcos on 20/10/2018
 */
data class ResponseModel(@SerializedName("id") val id: Int?,
                         @SerializedName("is_superhero") val isSuperHero: Boolean,
                         @SerializedName("user") val user: UserModel,
                         @SerializedName("address_neighborhood") val neighborhood: String,
                         @SerializedName("price") val price: Int)