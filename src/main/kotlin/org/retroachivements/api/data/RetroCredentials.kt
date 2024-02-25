package org.retroachivements.api.data

/**
 * [RetroCredentials] are the credentials necessary to authenticate to
 * the endpoints for RetroAchievements
 *
 * [username] the user's RetroAchievements.org username
 * [apiKey] the RetroAchievements.org API key
 */
data class RetroCredentials(
    val username: String,
    val apiKey: String
)
