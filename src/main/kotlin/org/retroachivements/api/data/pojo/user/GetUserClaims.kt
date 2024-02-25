package org.retroachivements.api.data.pojo.user

import com.google.gson.annotations.SerializedName

class GetUserClaims {

    class Response: ArrayList<Response.Claim>() {
        data class Claim(
            @SerializedName("ID")
            val id: Long,

            @SerializedName("User")
            val user: String,

            @SerializedName("GameID")
            val gameId: String,

            @SerializedName("GameTitle")
            val gameTitle: String,

            @SerializedName("GameIcon")
            val gameIcon: String,

            @SerializedName("ConsoleName")
            val consoleName: String,

            @SerializedName("ClaimType")
            val claimType: Long,

            @SerializedName("SetType")
            val setType: Long,

            @SerializedName("Status")
            val status: Int,

            @SerializedName("Extension")
            val extension: Long,

            @SerializedName("Special")
            val special: Long,

            @SerializedName("Created")
            val created: String,

            @SerializedName("DoneTime")
            val doneTime: String,

            @SerializedName("Updated")
            val updated: String,

            @SerializedName("MinutesLeft")
            val minutesLeft: Long
        )
    }
}
