package org.retroachivements.api.data.pojo.ticket

import com.google.gson.annotations.SerializedName

class GetAchievementTicketStats {

    data class Response(
        @SerializedName("AchievementID")
        val achievementId: Long,

        @SerializedName("AchievementTitle")
        val achievementTitle: String,

        @SerializedName("AchievementDescription")
        val achievementDescription: String,

        @SerializedName("URL")
        val url: String,

        @SerializedName("OpenTickets")
        val openTickets: Long
    )
}
