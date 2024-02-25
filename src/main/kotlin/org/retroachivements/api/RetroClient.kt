package org.retroachivements.api

import org.retroachivements.api.core.CoreClient
import org.retroachivements.api.data.RetroCredentials

class RetroClient(credentials: RetroCredentials, debugging: Boolean = false)
    : CoreClient(credentials, "https://retroachievements.org/", debugging) {

    // the API interface for the client
    val api: RetroInterface = retroClient.create(RetroInterface::class.java)
}
