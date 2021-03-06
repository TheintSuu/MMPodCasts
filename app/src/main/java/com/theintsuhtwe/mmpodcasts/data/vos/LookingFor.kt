package com.theintsuhtwe.mmpodcasts.data.vos

import com.google.gson.annotations.SerializedName

data class LookingFor(
    @SerializedName("cohosts")  val cohosts: Boolean,
    @SerializedName("cross_promotion")  val cross_promotion: Boolean,
    @SerializedName("guests")  val guests: Boolean,
    @SerializedName("sponsors")  val sponsors: Boolean
)