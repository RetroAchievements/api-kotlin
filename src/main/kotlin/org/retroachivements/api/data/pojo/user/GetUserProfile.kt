package org.retroachivements.api.data.pojo.user

import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import org.retroachivements.api.core.BooleanJsonDeserializer

class GetUserProfile {
    data class Response(
        @SerializedName("User")
        val user: String,

        @SerializedName("UserPic")
        val userPic: String,

        @SerializedName("MemberSince")
        val memberSince: String,

        @SerializedName("RichPresenceMsg")
        val richPresenceMsg: String?,

        @SerializedName("LastGameID")
        val lastGameID: Long?,

        @SerializedName("ContribYield")
        val contribYield: Int,

        @SerializedName("ContribCount")
        val contribCount: Int,

        @SerializedName("TotalPoints")
        val totalPoints: Int,

        @SerializedName("TotalSoftcorePoints")
        val totalSoftcorePoints: Int,

        @SerializedName("TotalTruePoints")
        val totalTruePoints: Long,

        @SerializedName("Permissions")
        val permissions: Int,

        @JsonAdapter(BooleanJsonDeserializer::class)
        @SerializedName("Untracked")
        val untracked: Boolean,

        @SerializedName("ID")
        val id: Long,

        @JsonAdapter(BooleanJsonDeserializer::class)
        @SerializedName("UserWallActive")
        val userWallActive: Boolean,

        @SerializedName("Motto")
        val motto: String?,
    )
}
