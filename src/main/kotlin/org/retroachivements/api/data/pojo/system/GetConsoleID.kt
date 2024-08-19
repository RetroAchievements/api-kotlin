package org.retroachivements.api.data.pojo.system

import com.google.gson.annotations.SerializedName

class GetConsoleID {

    class Response: ArrayList<Response.Console>() {
        data class Console (
            @SerializedName("ID")
            val id: Long,

            @SerializedName("Name")
            val name: String,

            @SerializedName("IconURL")
            val iconUrl: String,

            @SerializedName("Active")
            val active: Boolean,

            @SerializedName("IsGameSystem")
            val isGameSystem: Boolean
        )
    }
}
