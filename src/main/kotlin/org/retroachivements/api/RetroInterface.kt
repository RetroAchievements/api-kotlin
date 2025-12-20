package org.retroachivements.api

import co.infinum.retromock.meta.Mock
import co.infinum.retromock.meta.MockResponse
import com.haroldadmin.cnradapter.NetworkResponse
import org.retroachivements.api.data.pojo.user.*
import org.retroachivements.api.core.DateFormat
import org.retroachivements.api.core.RequiresCache
import org.retroachivements.api.data.pojo.ErrorResponse
import org.retroachivements.api.data.pojo.achievement.GetAchievementUnlocks
import org.retroachivements.api.data.pojo.comments.GetComments
import org.retroachivements.api.data.pojo.event.GetAchievementOfTheWeek
import org.retroachivements.api.data.pojo.feed.GetClaims
import org.retroachivements.api.data.pojo.feed.GetRecentGameAwards
import org.retroachivements.api.data.pojo.feed.GetTopTenUsers
import org.retroachivements.api.data.pojo.game.*
import org.retroachivements.api.data.pojo.system.GetConsoleID
import org.retroachivements.api.data.pojo.system.GetGameList
import org.retroachivements.api.data.pojo.ticket.*
import org.retroachivements.api.data.pojo.user.GetUserCompletedGames
import org.retroachivements.api.data.pojo.user.GetUserRecentlyPlayedGames
import org.retroachivements.api.data.pojo.user.GetUserSummary
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import java.util.*

interface RetroInterface {

    /**
     * A call to this function will retrieve the current top ten users
     * on the site.
     */
    @Mock @MockResponse(body = "/v1/feed/GetTopTenUsers.json")
    @GET("/API/API_GetTopTenUsers.php")
    suspend fun getTopTenUsers(): NetworkResponse<GetTopTenUsers.Response, ErrorResponse>

    /**
     * A call to this function will retrieve minimal user profile information, such as their ID, motto, most recent game ID, avatar, and points.
     */
    @Mock @MockResponse(body = "/v1/user/GetUserProfile.json")
    @POST("/API/API_GetUserProfile.php")
    suspend fun getUserProfile(@Query("u") username: String): NetworkResponse<GetUserProfile.Response, ErrorResponse>

    /**
     * A call to this function will retrieve a list of a target user's recently unlocked achievements, via their username. By default, it fetches achievements unlocked in the last hour.
     */
    @Mock @MockResponse(body = "/v1/user/GetUserRecentAchievements.json")
    @POST("/API/API_GetUserRecentAchievements.php")
    suspend fun getUserRecentAchievements(
        @Query("u") username: String,
        @Query("m") minutes: Long = 60
    ): NetworkResponse<GetUserRecentAchievements.Response, ErrorResponse>

    /**
     * A call to this function will retrieve a list of achievements unlocked by a given user between two given dates.
     */
    @Mock @MockResponse(body = "/v1/user/GetAchievementsEarnedBetween.json")
    @POST("/API/API_GetAchievementsEarnedBetween.php")
    suspend fun getAchievementsEarnedBetween(
        @Query("u") username: String,
        @Query("f") @DateFormat("yyyy-MM-dd") fromDate: Date,
        @Query("t") @DateFormat("yyyy-MM-dd") toDate: Date
    ): NetworkResponse<GetUserRecentAchievements.Response, ErrorResponse>

    /**
     * A call to this function will retrieve a list of achievements unlocked by a given user on a specified date.
     */
    @Mock @MockResponse(body = "/v1/user/GetAchievementsEarnedOnDay.json")
    @POST("/API/API_GetAchievementsEarnedOnDay.php")
    suspend fun getAchievementsEarnedOnDay(
        @Query("u") username: String,
        @Query("d") @DateFormat("yyyy-MM-dd") date: Date
    ): NetworkResponse<GetUserRecentAchievements.Response, ErrorResponse>

    /**
     * A call to this function will retrieve extended metadata about a game, in addition to a user's progress about that game. This is targeted via a game's unique ID and a given username.
     */
    @Mock @MockResponse(body = "/v1/game/GetGameInfoAndUserProgress.json")
    @POST("/API/API_GetGameInfoAndUserProgress.php")
    suspend fun getGameInfoAndUserProgress(
        @Query("u") username: String,
        @Query("g") gameId: Long,
        @Query("a") includeUserAward: Int = 0
    ): NetworkResponse<GetGameInfoAndUserProgress.Response, ErrorResponse>

    /**
     * A call to this endpoint will retrieve information about the average time to unlock achievements in a game, targeted via its unique ID.
     */
    @Mock @MockResponse(body = "/v1/game/GetGameProgression.json")
    @POST("/API/API_GetGameProgression.php")
    suspend fun getGameProgression(
        @Query("i") gameId: Long,
        @Query("h") hardcore: Int = 0
    ): NetworkResponse<GetGameProgression.Response, ErrorResponse>

    /**
     * A call to this function will retrieve a giver user's completion progress, targeted by their username.
     */
    @Mock @MockResponse(body = "/v1/user/GetUserCompletionProgress.json")
    @POST("/API/API_GetUserCompletionProgress.php")
    suspend fun getUserCompletionProgress(
        @Query("u") username: String,
        @Query("c") maxRecords: Int = 100,
        @Query("o") skipRecords: Int = 0
    ): NetworkResponse<GetUserCompletionProgress.Response, ErrorResponse>

    /**
     * A call to this function will retrieve metadata about the target user's site awards, via their username.
     */
    @Mock @MockResponse(body = "/v1/user/GetUserAwards.json")
    @POST("/API/API_GetUserAwards.php")
    suspend fun getUserAwards(
        @Query("u") username: String
    ): NetworkResponse<GetUserAwards.Response, ErrorResponse>

    /**
     * A call to this function will retrieve a list of achievement set claims made over the lifetime of a given user, targeted by their username.
     */
    @Mock @MockResponse(body = "/v1/user/GetUserClaims.json")
    @POST("/API/API_GetUserClaims.php")
    suspend fun getUserClaims(
        @Query("u") username: String
    ): NetworkResponse<GetUserClaims.Response, ErrorResponse>

    /**
     * A call to this function will retrieve metadata about how a given user has performed/ranked on a given game, targeted by game ID.
     */
    @Mock @MockResponse(body = "/v1/user/GetUserGameRankAndScore.json")
    @POST("/API/API_GetUserGameRankAndScore.php")
    suspend fun getUserGameRankAndScore(
        @Query("u") username: String,
        @Query("g") gameId: Long
    ): NetworkResponse<GetUserGameRankAndScore.Response, ErrorResponse>

    /**
     * A call to this function will retrieve a given user's hardcore and softcore points.
     */
    @Mock @MockResponse(body = "/v1/user/GetUserPoints.json")
    @POST("/API/API_GetUserPoints.php")
    suspend fun getUserPoints(
        @Query("u") username: String,
    ): NetworkResponse<GetUserPoints.Response, ErrorResponse>

    /**
     * A call to this function will retrieve a given user's progress on a given list of games, targeted by game ID.
     */
    @Mock @MockResponse(body = "/v1/user/GetUserProgress.json")
    @POST("/API/API_GetUserProgress.php")
    suspend fun getUserProgress(
        @Query("u") username: String,
        @Query("i") gameId: String
    ): NetworkResponse<GetUserProgress.Response, ErrorResponse>

    /**
     * A call to this function will retrieve a list of a target user's recently played games, via their username.
     */
    @Mock @MockResponse(body = "/v1/user/GetUserRecentlyPlayedGames.json")
    @POST("/API/API_GetUserRecentlyPlayedGames.php")
    suspend fun getUserRecentlyPlayedGames(
        @Query("u") username: String,
        @Query("c") count: Int = 10,
        @Query("o") offset: Int = 0
    ): NetworkResponse<GetUserRecentlyPlayedGames.Response, ErrorResponse>

    /**
     * A call to this function will retrieve summary information about a given user, targeted by username.
     */
    @Mock @MockResponse(body = "/v1/user/GetUserSummary.json")
    @POST("/API/API_GetUserSummary.php")
    suspend fun getUserSummary(
        @Query("u") username: String
    ): NetworkResponse<GetUserSummary.Response, ErrorResponse>

    /**
     * A call to this function will retrieve completion metadata about the games a given user has played.
     * It returns two entries per each game: one for the softcore completion and one for the hardcore completion.
     * These are designated by the hardcoreMode property on each completion object.
     */
    @Mock @MockResponse(body = "/v1/user/GetUserCompletedGames.json")
    @POST("/API/API_GetUserCompletedGames.php")
    @Deprecated("This endpoint is considered legacy. The `getUserCompletionProgress` endpoint will almost always be a better fit for your use case.")
    suspend fun getUserCompletedGames(
        @Query("u") username: String
    ): NetworkResponse<GetUserCompletedGames.Response, ErrorResponse>

    /**
     * A call to this function will retrieve a given user's "Want to Play Games" list, targeted by their username.
     * Results will only be returned if the target user is yourself, or if both you and the target user follow each other.
     */
    @Mock @MockResponse(body = "/v1/user/GetUserWantToPlayList.json")
    @POST("/API/API_GetUserWantToPlayList.php")
    suspend fun getUserWantToPlayList(
        @Query("u") username: String,
        @Query("c") maxRecords: Int = 100,
        @Query("o") skipRecords: Int = 0
    ): NetworkResponse<GetUserWantToPlayList.Response, ErrorResponse>

    /**
     * A call to this function will retrieve a list of users that I follow.
     */
    @Mock @MockResponse(body = "/v1/user/GetUsersIFollow.json")
    @POST("/API/API_GetUsersIFollow.php")
    suspend fun getUsersIFollow(
        @Query("o") offset: Int = 0,
        @Query("c") count: Int = 100
    ): NetworkResponse<GetUsersIFollow.Response, ErrorResponse>

    /**
     * A call to this function will retrieve a list of users that are following me.
     */
    @Mock @MockResponse(body = "/v1/user/GetUsersFollowingMe.json")
    @POST("/API/API_GetUsersFollowingMe.php")
    suspend fun getUsersFollowingMe(
        @Query("o") offset: Int = 0,
        @Query("c") count: Int = 100
    ): NetworkResponse<GetUsersFollowingMe.Response, ErrorResponse>

    /**
     * A call to this endpoint will retrieve a given user's set requests, maximum total requests and points until next request.
     */
    @Mock @MockResponse(body = "/v1/user/GetUserSetRequests.json")
    @POST("/API/API_GetUserSetRequests.php")
    suspend fun getUserSetRequests(
        @Query("u") userId: String,
        @Query("t") all: Int = 0
    ): NetworkResponse<GetUserSetRequests.Response, ErrorResponse>

    /**
     * A call to this function will retrieve basic metadata about a game, targeted via its unique ID.
     */
    @Mock @MockResponse(body = "/v1/game/GetGame.json")
    @POST("/API/API_GetGame.php")
    suspend fun getGame(
        @Query("i") gameId: Long
    ): NetworkResponse<GetGame.Response, ErrorResponse>

    /**
     * A call to this function will retrieve extended metadata about a game, targeted via its unique ID.
     */
    @Mock @MockResponse(body = "/v1/game/GetGameExtended.json")
    @POST("/API/API_GetGameExtended.php")
    suspend fun getGameExtended(
        @Query("i") gameId: Long,
        @Query("f") unofficial: Int = 3
    ): NetworkResponse<GetGameExtended.Response, ErrorResponse>

    /**
     * A call to this function will retrieve the hashes linked to a game, targeted via its unique ID.
     */
    @Mock @MockResponse(body = "/v1/game/GetGameHashes.json")
    @POST("/API/API_GetGameHashes.php")
    suspend fun getGameHashes(
        @Query("i") gameId: Long
    ): NetworkResponse<GetGameHashes.Response, ErrorResponse>

    /**
     * A call to this function will retrieve the list of achievement IDs for a game, targeted by game ID.
     * This can be useful if you'd like to quickly check how many achievements a particular game has.
     * Using this, you can also detect if a game has received a revision.
     * For example, if a game had 100 achievements last month and has 102 today,
     * you know the game's achievement set has been revised.
     */
    @Mock @MockResponse(body = "/v1/game/GetAchievementCount.json")
    @POST("/API/API_GetAchievementCount.php")
    suspend fun getAchievementCount(
        @Query("i") gameId: Long
    ): NetworkResponse<GetAchievementCount.Response, ErrorResponse>

    /**
     * A call to this function will retrieve a dictionary of the number of players who have earned
     * a specific number of achievements for a given game ID. This function can be used to determine
     * the total mastery count for a game, as well as how rare that overall mastery is.
     */
    @Mock @MockResponse(body = "/v1/game/GetAchievementDistribution.json")
    @POST("/API/API_GetAchievementDistribution.php")
    suspend fun getAchievementDistribution(
        @Query("i") gameId: Long,
        @Query("h") hardcore: Int = 0,
        @Query("f") official: Int = 3
    ): NetworkResponse<GetAchievementDistribution.Response, ErrorResponse>

    /**
     * A call to this function will retrieve metadata about either the latest masters for a game, or the highest points earners for a game. The game is targeted via its unique ID.
     */
    @Mock @MockResponse(body = "/v1/game/GetGameRankAndScore.json")
    @POST("/API/API_GetGameRankAndScore.php")
    suspend fun getGameRankAndScore(
        @Query("g") gameId: Long,
        @Query("t") masters: Int = 0
    ): NetworkResponse<GetGameRankAndScore.Response, ErrorResponse>

    /**
     * A call to this function will retrieve a given game's list of leaderboards, targeted by the game's ID.
     */
    @Mock @MockResponse(body = "/v1/game/GetGameLeaderboards.json")
    @POST("/API/API_GetGameLeaderboards.php")
    suspend fun getGameLeaderboards(
        @Query("i") gameId: Long,
        @Query("o") offset: Int = 0,
        @Query("c") count: Int = 100
    ): NetworkResponse<GetGameLeaderboards.Response, ErrorResponse>

    /**
     * A call to this function will retrieve a given leaderboard's entries, targeted by its ID.
     */
    @Mock @MockResponse(body = "/v1/game/GetLeaderboardEntries.json")
    @POST("/API/API_GetLeaderboardEntries.php")
    suspend fun getLeaderboardEntries(
        @Query("i") gameId: Long,
        @Query("o") offset: Int = 0,
        @Query("c") count: Int = 100
    ): NetworkResponse<GetLeaderboardEntries.Response, ErrorResponse>

    /**
     * A call to this function will retrieve a given leaderboard's entries, targeted by its ID.
     */
    @Mock @MockResponse(body = "/v1/game/GetUserGameLeaderboards.json")
    @POST("/API/API_GetUserGameLeaderboards.php")
    suspend fun getUserGameLeaderboards(
        @Query("i") gameId: Long,
        @Query("u") userId: String? = null,
        @Query("o") offset: Int = 0,
        @Query("c") count: Int = 100
    ): NetworkResponse<GetUserGameLeaderboard.Response, ErrorResponse>

    /**
     * A call to this function will retrieve the complete list of all system ID and name pairs on the site.
     *
     * [activeSystemsOnly] set to 1
     * [gameSystemsOnly] set to 1
     */
    @Mock @MockResponse(body = "/v1/system/GetConsoleIDs.json")
    @POST("/API/API_GetConsoleIDs.php")
    suspend fun getConsoleIds(
        @Query("a") activeSystemsOnly: Int = 0,
        @Query("g") gameSystemsOnly: Int = 0
    ): NetworkResponse<GetConsoleID.Response, ErrorResponse>

    /**
     * A call to this function will retrieve the complete list of games for a specified console on the site,
     * targeted by the console ID. If you do not know the console ID you're looking for,
     * try using the all systems function.
     */
    @Mock @MockResponse(body = "/v1/system/GetGameList.json")
    @POST("/API/API_GetGameList.php")
    @RequiresCache
    suspend fun getGameList(
        @Query("i") consoleId: Long,
        @Query("f") shouldOnlyRetrieveGamesWithAchievements: Int = 0,
        @Query("h") shouldRetrieveGameHashes: Int = 0,
        @Query("o") offset: Int = 0,
        @Query("c") count: Int = 0
    ): NetworkResponse<GetGameList.Response, ErrorResponse>

    /**
     * A call to this function will retrieve a list of users who have earned an achievement, targeted by the achievement's ID.
     */
    @Mock @MockResponse(body = "/v1/achievement/GetAchievementUnlocks.json")
    @POST("/API/API_GetAchievementUnlocks.php")
    suspend fun getAchievementUnlocks(
        @Query("a") achievementId: Long,
        @Query("o") offset: Int = 0,
        @Query("c") count: Int = 50
    ): NetworkResponse<GetAchievementUnlocks.Response, ErrorResponse>

    /**
     * A call to this function returns information about all (1000 max)
     * set claims of a specified kind: completed=1, dropped=2, or expired=3.
     */
    @Mock @MockResponse(body = "/v1/feed/GetClaims.json")
    @POST("/API/API_GetClaims.php")
    suspend fun getClaims(
        @Query("k") claimKind: Int
    ): NetworkResponse<GetClaims.Response, ErrorResponse>

    /**
     * A call to this function returns information about all (1000 max) active set claims.
     */
    @Mock @MockResponse(body = "/v1/feed/GetActiveClaims.json")
    @POST("/API/API_GetActiveClaims.php")
    suspend fun getActiveClaims(): NetworkResponse<GetClaims.Response, ErrorResponse>

    /**
     * A call to this function will retrieve all recently granted game awards across the site's userbase.
     */
    @Mock @MockResponse(body = "/v1/feed/GetRecentGameAwards.json")
    @POST("/API/API_GetRecentGameAwards.php")
    suspend fun getRecentGameAwards(
        @Query("d") @DateFormat("yyyy-MM-dd") startingDate: Date = Date(),
        @Query("c") count: Int = 25,
        @Query("o") offset: Int = 0,
        @Query("k") kinds: String = listOf("beaten-softcore", "beaten-hardcore", "completed", "mastered").joinToString()
    ): NetworkResponse<GetRecentGameAwards.Response, ErrorResponse>

    /**
     * A call to this function will retrieve comprehensive metadata about the current Achievement of the Week.
     */
    @Mock @MockResponse(body = "/v1/event/GetAchievementOfTheWeek.json")
    @POST("/API/API_GetAchievementOfTheWeek.php")
    suspend fun getAchievementOfTheWeek(): NetworkResponse<GetAchievementOfTheWeek.Response, ErrorResponse>

    /**
     * A call to getTicketData() in this manner will retrieve ticket metadata information about
     * a single achievement ticket, targeted by its ticket ID.
     */
    @Mock @MockResponse(body = "/v1/ticket/GetTicket.json")
    @POST("/API/API_GetTicketData.php")
    suspend fun getTicket(
        @Query("i") ticketId: Long
    ): NetworkResponse<GetTicketData.Response, ErrorResponse>

    /**
     * A call to getTicketData() in this manner will retrieve the games on the site with the highest count of opened achievement tickets.
     */
    @Mock @MockResponse(body = "/v1/ticket/GetMostTicketedGames.json")
    @POST("/API/API_GetTicketData.php")
    suspend fun getMostTicketedGames(
        @Query("c") count: Int = 10,
        @Query("o") offset: Int = 0,
        @Query("f") type: Int = 1
    ): NetworkResponse<GetMostTicketedGames.Response, ErrorResponse>

    /**
     * A call to getTicketData() in this manner will retrieve the most recent tickets
     */
    @Mock @MockResponse(body = "/v1/ticket/GetMostRecentTickets.json")
    @POST("/API/API_GetTicketData.php")
    suspend fun getMostRecentTickets(
        @Query("c") count: Int = 10,
        @Query("o") offset: Int = 0
    ): NetworkResponse<GetMostRecentTickets.Response, ErrorResponse>

    /**
     * A call to getTicketData() in this manner will retrieve the most recent tickets
     * to set [shouldReturnTicketsList], set the value to `1`
     * to set [isGettingTicketsForUnofficialAchievements], set the value to `5`
     */
    @Mock @MockResponse(body = "/v1/ticket/GetGameTicketStats.json")
    @POST("/API/API_GetTicketData.php")
    suspend fun getGameTicketStats(
        @Query("g") gameId: Long,
        @Query("d") shouldReturnTicketsList: Int? = null,
        @Query("f") isGettingTicketsForUnofficialAchievements: Int? = null,
        @Query("c") count: Int = 10,
        @Query("o") offset: Int = 0
    ): NetworkResponse<GetGameTicketStats.Response, ErrorResponse>

    /**
     * A call to getTicketData() in this manner will retrieve ticket stats for a developer, targeted by that developer's site username.
     */
    @Mock @MockResponse(body = "/v1/ticket/GetDeveloperTicketStats.json")
    @POST("/API/API_GetTicketData.php")
    suspend fun getDeveloperTicketStats(
        @Query("u") username: String
    ): NetworkResponse<GetDeveloperTicketStats.Response, ErrorResponse>

    /**
     * A call to getTicketData() in this manner will retrieve ticket stats for an achievement, targeted by that achievement's unique ID.
     */
    @Mock @MockResponse(body = "/v1/ticket/GetAchievementTicketStats.json")
    @POST("/API/API_GetTicketData.php")
    suspend fun getAchievementTicketStats(
        @Query("a") achievementId: Long
    ): NetworkResponse<GetAchievementTicketStats.Response, ErrorResponse>

    /**
     * A call to this function returns comments of a specified user.
     */
    @Mock @MockResponse(body = "/v1/comments/GetCommentsOnUserWall.json")
    @POST("/API/API_GetComments.php")
    suspend fun getCommentsOnUserWall(
        @Query("i") username: String,
        @Query("c") count: Int = 10,
        @Query("o") offset: Int = 0,
        @Query("t") type: Int = 3,
        @Query("sort") sort: String = "submitted"
    ): NetworkResponse<GetComments.Response, ErrorResponse>

    /**
     * A call to this function returns comments of a specified game.
     */
    @Mock @MockResponse(body = "/v1/comments/GetCommentsOnGameWall.json")
    @POST("/API/API_GetComments.php")
    suspend fun getCommentsOnGameWall(
        @Query("i") gameId: Long,
        @Query("c") count: Int = 10,
        @Query("o") offset: Int = 0,
        @Query("t") type: Int = 1,
        @Query("sort") sort: String = "submitted"
    ): NetworkResponse<GetComments.Response, ErrorResponse>

    /**
     * A call to this function returns comments of a specified achievement.
     */
    @Mock @MockResponse(body = "/v1/comments/GetCommentsOnAchievementWall.json")
    @POST("/API/API_GetComments.php")
    suspend fun getCommentsOnAchievementWall(
        @Query("i") achievementId: Long,
        @Query("c") count: Int = 10,
        @Query("o") offset: Int = 0,
        @Query("t") type: Int = 2,
        @Query("sort") sort: String = "submitted"
    ): NetworkResponse<GetComments.Response, ErrorResponse>
}
