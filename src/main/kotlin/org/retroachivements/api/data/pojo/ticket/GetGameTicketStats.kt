package org.retroachivements.api.data.pojo.ticket

import com.google.gson.annotations.SerializedName

class GetGameTicketStats {

    data class Response(
        @SerializedName("GameID")
        val gameId: Long,

        @SerializedName("GameTitle")
        val gameTitle: String,

        @SerializedName("ConsoleName")
        val consoleName: String,

        @SerializedName("OpenTickets")
        val openTickets: Long,

        @SerializedName("URL")
        val url: String
    )
}
