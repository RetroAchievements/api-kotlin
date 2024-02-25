package org.retroachivements.api.data.pojo.ticket

import com.google.gson.annotations.SerializedName

class GetMostTicketedGames {

    data class Response(
        @SerializedName("MostReportedGames")
        val mostReportedGames: ArrayList<ReportedGame>,

        @SerializedName("URL")
        val url: String
    ) {
        data class ReportedGame(
            @SerializedName("GameID")
            val gameId: Long,

            @SerializedName("GameTitle")
            val gameTitle: String,

            @SerializedName("GameIcon")
            val gameIcon: String,

            @SerializedName("Console")
            val console: String,

            @SerializedName("OpenTicket")
            val openTicket: Long
        )
    }
}
