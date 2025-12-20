package org.retroachivements.api.data.pojo.user

import com.google.gson.annotations.SerializedName

class GetUsersIFollow {
    data class Response(
        @SerializedName("Count")
        val count: Long,

        @SerializedName("Total")
        val total: Long,

        @SerializedName("Results")
        val results: List<User>,
    )

    data class User(
        @SerializedName("User")
        val user: String,

        @SerializedName("Points")
        val points: Long,

        @SerializedName("PointsSoftcore")
        val pointsSoftcore: Long,

        @SerializedName("IsFollowingMe")
        val isFollowingMe: Boolean,
    )

}
