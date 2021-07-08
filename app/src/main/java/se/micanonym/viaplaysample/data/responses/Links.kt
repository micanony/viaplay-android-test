package se.micanonym.viaplaysample.data.responses

import com.google.gson.annotations.SerializedName
import se.micanonym.viaplaysample.data.models.Section

data class Links(
    @SerializedName(value = "viaplay:sections")
    val sections: List<Section>
)
