package org.retroachivements.api.data.pojo.user

import com.google.gson.annotations.SerializedName

class GetUserPoints {
    data class Response(
        @SerializedName("Points")
        val points: Long,

        @SerializedName("SoftcorePoints")
        val softcorePoints: Long
    )
}
