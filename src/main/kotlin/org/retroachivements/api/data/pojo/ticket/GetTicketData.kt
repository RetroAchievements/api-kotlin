package org.retroachivements.api.data.pojo.ticket

import com.google.gson.annotations.SerializedName

class GetTicketData {

    data class Response(
        @SerializedName("ID")
        val id: Long,

        @SerializedName("AchievementID")
        val achievementId: Long,

        @SerializedName("AchievementType")
        val achievementType: String?,

        @SerializedName("AchievementTitle")
        val achievementTitle: String,

        @SerializedName("AchievementDesc")
        val achievementDesc: String,

        @SerializedName("Points")
        val points: Long,

        @SerializedName("BadgeName")
        val badgeName: String,

        @SerializedName("AchievementAuthor")
        val achievementAuthor: String,

        @SerializedName("GameID")
        val gameId: Long,

        @SerializedName("ConsoleName")
        val consoleName: String,

        @SerializedName("GameTitle")
        val gameTitle: String,

        @SerializedName("GameIcon")
        val gameIcon: String,

        @SerializedName("ReportedAt")
        val reportedAt: String,

        @SerializedName("ReportType")
        val reportType: Int,

        @SerializedName("ReportState")
        val reportState: Int,

        @SerializedName("Hardcore")
        val hardcore: Int?,

        @SerializedName("ReportNotes")
        val reportNotes: String,

        @SerializedName("ReportedBy")
        val reportedBy: String,

        @SerializedName("ResolvedAt")
        val resolvedAt: String?,

        @SerializedName("ResolvedBy")
        val resolvedBy: String?,

        @SerializedName("ReportStateDescription")
        val reportStateDescription: String,

        @SerializedName("ReportTypeDescription")
        val reportTypeDescription: String,

        @SerializedName("URL")
        val url: String?
    )
}
