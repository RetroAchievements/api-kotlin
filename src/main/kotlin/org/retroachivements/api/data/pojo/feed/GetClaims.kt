package org.retroachivements.api.data.pojo.feed

import com.google.gson.annotations.SerializedName

class GetClaims {

    class Response: ArrayList<Response.Claim>() {
        data class Claim(
            @SerializedName("ID")
            val id: Long,

            @SerializedName("User")
            val user: String,

            @SerializedName("GameID")
            val gameId: Long,

            @SerializedName("GameTitle")
            val gameTitle: String,

            @SerializedName("GameIcon")
            val gameIcon: String,

            @SerializedName("ConsoleName")
            val consoleName: String,

            @SerializedName("ConsoleID")
            val consoleId: Long,

            @SerializedName("ClaimType")
            val claimType: Int,

            @SerializedName("SetType")
            val setType: Int,

            @SerializedName("Status")
            val status: Int,

            @SerializedName("Extension")
            val extension: Int,

            @SerializedName("Special")
            val special: Int,

            @SerializedName("Created")
            val created: String,

            @SerializedName("Updated")
            val updated: String,

            @SerializedName("DoneTime")
            val doneTime: String,

            @SerializedName("MinutesLeft")
            val minutesLeft: Long,

            @SerializedName("UserIsJrDev")
            val userIsJrDev: Int
        )
    }
}
