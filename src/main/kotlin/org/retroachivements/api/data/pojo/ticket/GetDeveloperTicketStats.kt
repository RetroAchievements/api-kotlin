package org.retroachivements.api.data.pojo.ticket

import com.google.gson.annotations.SerializedName

class GetDeveloperTicketStats {

    data class Response(
        @SerializedName("User")
        val user: String,

        @SerializedName("Open")
        val open: Long,

        @SerializedName("Close")
        val close: Long,

        @SerializedName("Resolved")
        val resolved: Long,

        @SerializedName("Total")
        val total: Long,

        @SerializedName("URL")
        val url: String
    )
}
