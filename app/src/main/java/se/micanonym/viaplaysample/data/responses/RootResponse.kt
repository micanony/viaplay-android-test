package se.micanonym.viaplaysample.data.responses

import com.google.gson.annotations.SerializedName

data class RootResponse(
    @SerializedName(value = "_links")
    val links: Links
)
