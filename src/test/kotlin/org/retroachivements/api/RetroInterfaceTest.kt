package org.retroachivements.api

import co.infinum.retromock.Retromock
import com.haroldadmin.cnradapter.NetworkResponse
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.retroachivements.api.core.RequiresCache
import org.retroachivements.api.data.RetroCredentials
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
import org.retroachivements.api.data.pojo.user.*
import org.retroachivements.api.test.ResourceBodyFactory
import java.text.SimpleDateFormat
import java.util.*
import kotlin.test.assertNotNull


class RetroInterfaceTest {

    @Test
    fun `check getTopTenUsers response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val topTenUsers: NetworkResponse<GetTopTenUsers.Response, ErrorResponse>
                = api.getTopTenUsers()

            assert(topTenUsers is NetworkResponse.Success)

            assertNotNull((topTenUsers as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getUserProfile response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val getUserProfile: NetworkResponse<GetUserProfile.Response, ErrorResponse> = api.getUserProfile(
                username = "MaxMilyin"
            )

            assert(getUserProfile is NetworkResponse.Success)

            assertNotNull((getUserProfile as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getUserRecentAchievements response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val getUserRecentAchievements: NetworkResponse<GetUserRecentAchievements.Response, ErrorResponse> = api.getUserRecentAchievements(
                username = "MaxMilyin"
            )

            assert(getUserRecentAchievements is NetworkResponse.Success)

            assertNotNull((getUserRecentAchievements as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getAchievementsEarnedBetween response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            // create dates
            val dateFormat = SimpleDateFormat("yyyy-MM-dd")
            val fromDate: Date = dateFormat.parse("2022-01-01")
            val toDate: Date = dateFormat.parse("2022-01-08")

            val getUserRecentAchievements: NetworkResponse<GetUserRecentAchievements.Response, ErrorResponse> = api.getAchievementsEarnedBetween(
                username = "MaxMilyin",
                fromDate = fromDate,
                toDate = toDate
            )

            assert(getUserRecentAchievements is NetworkResponse.Success)

            assertNotNull((getUserRecentAchievements as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getAchievementsEarnedOnDay response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            // create dates
            val dateFormat = SimpleDateFormat("yyyy-MM-dd")
            val date: Date = dateFormat.parse("2022-01-01")

            val getUserRecentAchievements: NetworkResponse<GetUserRecentAchievements.Response, ErrorResponse> = api.getAchievementsEarnedOnDay(
                username = "MaxMilyin",
                date = date
            )

            assert(getUserRecentAchievements is NetworkResponse.Success)

            assertNotNull((getUserRecentAchievements as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getGameInfoAndUserProgress response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val getGameInfoAndUserProgress: NetworkResponse<GetGameInfoAndUserProgress.Response, ErrorResponse> = api.getGameInfoAndUserProgress(
                username = "MaxMilyin",
                gameId = 14402
            )

            assert(getGameInfoAndUserProgress is NetworkResponse.Success)

            assertNotNull((getGameInfoAndUserProgress as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getUserCompletionProgress response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val getUserCompletionProgress: NetworkResponse<GetUserCompletionProgress.Response, ErrorResponse> = api.getUserCompletionProgress(
                username = "MaxMilyin"
            )

            assert(getUserCompletionProgress is NetworkResponse.Success)

            assertNotNull((getUserCompletionProgress as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getUserAwards response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val getUserAwards: NetworkResponse<GetUserAwards.Response, ErrorResponse> = api.getUserAwards(
                username = "MaxMilyin"
            )

            assert(getUserAwards is NetworkResponse.Success)

            assertNotNull((getUserAwards as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getUserClaims response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val getUserClaims: NetworkResponse<GetUserClaims.Response, ErrorResponse> = api.getUserClaims(
                username = "Jamiras"
            )

            assert(getUserClaims is NetworkResponse.Success)

            assertNotNull((getUserClaims as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getUserGameRankAndScore response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val getUserGameRankAndScore: NetworkResponse<GetUserGameRankAndScore.Response, ErrorResponse> = api.getUserGameRankAndScore(
                username = "xelnia",
                gameId = 14402
            )

            assert(getUserGameRankAndScore is NetworkResponse.Success)

            assertNotNull((getUserGameRankAndScore as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getUserPoints response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val getUserPoints: NetworkResponse<GetUserPoints.Response, ErrorResponse> = api.getUserPoints(
                username = "xelnia"
            )

            assert(getUserPoints is NetworkResponse.Success)

            assertNotNull((getUserPoints as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getUserProgress response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val getUserProgress: NetworkResponse<GetUserProgress.Response, ErrorResponse> = api.getUserProgress(
                username = "xelnia",
                gameId = "1,14402"
            )

            assert(getUserProgress is NetworkResponse.Success)

            assertNotNull((getUserProgress as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getUserRecentlyPlayedGames response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val getUserRecentlyPlayedGames: NetworkResponse<GetUserRecentlyPlayedGames.Response, ErrorResponse> = api.getUserRecentlyPlayedGames(
                username = "xelnia"
            )

            assert(getUserRecentlyPlayedGames is NetworkResponse.Success)

            assertNotNull((getUserRecentlyPlayedGames as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getUserSummary response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val getUserSummary: NetworkResponse<GetUserSummary.Response, ErrorResponse> = api.getUserSummary(
                username = "xelnia"
            )

            assert(getUserSummary is NetworkResponse.Success)

            assertNotNull((getUserSummary as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getUserCompletedGames response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val getUserCompletedGames: NetworkResponse<GetUserCompletedGames.Response, ErrorResponse> = api.getUserCompletedGames(
                username = "MaxMilyin"
            )

            assert(getUserCompletedGames is NetworkResponse.Success)

            assertNotNull((getUserCompletedGames as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getUserWantToPlayList response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val getUserWantToPlayList: NetworkResponse<GetUserWantToPlayList.Response, ErrorResponse> = api.getUserWantToPlayList(
                username = "MaxMilyin"
            )

            assert(getUserWantToPlayList is NetworkResponse.Success)

            assertNotNull((getUserWantToPlayList as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getUsersIFollow response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val getUsersIFollow: NetworkResponse<GetUsersIFollow.Response, ErrorResponse> = api.getUsersIFollow()

            assert(getUsersIFollow is NetworkResponse.Success)

            assertNotNull((getUsersIFollow as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getUsersFollowingMe response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val getUsersFollowingMe: NetworkResponse<GetUsersFollowingMe.Response, ErrorResponse> = api.getUsersFollowingMe()

            assert(getUsersFollowingMe is NetworkResponse.Success)

            assertNotNull((getUsersFollowingMe as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getGame response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val getGame: NetworkResponse<GetGame.Response, ErrorResponse> = api.getGame(
                gameId = 14402
            )

            assert(getGame is NetworkResponse.Success)

            assertNotNull((getGame as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getGameExtended response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val getGameExtended: NetworkResponse<GetGameExtended.Response, ErrorResponse> = api.getGameExtended(
                gameId = 14402
            )

            assert(getGameExtended is NetworkResponse.Success)

            assertNotNull((getGameExtended as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getGameHashes response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val getGameHashes: NetworkResponse<GetGameHashes.Response, ErrorResponse> = api.getGameHashes(
                gameId = 14402
            )

            assert(getGameHashes is NetworkResponse.Success)

            assertNotNull((getGameHashes as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getAchievementCount response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val getAchievementCount: NetworkResponse<GetAchievementCount.Response, ErrorResponse> = api.getAchievementCount(
                gameId = 14402
            )

            assert(getAchievementCount is NetworkResponse.Success)

            assertNotNull((getAchievementCount as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getAchievementDistribution response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val getAchievementDistribution: NetworkResponse<GetAchievementDistribution.Response, ErrorResponse> = api.getAchievementDistribution(
                gameId = 14402
            )

            assert(getAchievementDistribution is NetworkResponse.Success)

            assertNotNull((getAchievementDistribution as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getGameRankAndScore response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val getAchievementDistribution: NetworkResponse<GetGameRankAndScore.Response, ErrorResponse> = api.getGameRankAndScore(
                gameId = 14402
            )

            assert(getAchievementDistribution is NetworkResponse.Success)

            assertNotNull((getAchievementDistribution as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getGameLeaderboards response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val gameLeaderboards: NetworkResponse<GetGameLeaderboards.Response, ErrorResponse> = api.getGameLeaderboards(
                gameId = 14402
            )

            assert(gameLeaderboards is NetworkResponse.Success)

            assertNotNull((gameLeaderboards as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getLeaderboardEntries response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val leaderboardEntries: NetworkResponse<GetLeaderboardEntries.Response, ErrorResponse> = api.getLeaderboardEntries(
                gameId = 14402
            )

            assert(leaderboardEntries is NetworkResponse.Success)

            assertNotNull((leaderboardEntries as NetworkResponse.Success).body)
        }
    }


    @Test
    fun `check getConsoleIds response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val getConsoleIds: NetworkResponse<GetConsoleID.Response, ErrorResponse> = api.getConsoleIds()

            assert(getConsoleIds is NetworkResponse.Success)

            assertNotNull((getConsoleIds as NetworkResponse.Success).body)
        }
    }

    @OptIn(RequiresCache::class)
    @Test
    fun `check getGameList response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val getGameList: NetworkResponse<GetGameList.Response, ErrorResponse> = api.getGameList(
                consoleId = 1
            )

            assert(getGameList is NetworkResponse.Success)

            assertNotNull((getGameList as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getAchievementUnlocks response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val getAchievementUnlocks: NetworkResponse<GetAchievementUnlocks.Response, ErrorResponse> = api.getAchievementUnlocks(
                achievementId = 13876
            )

            assert(getAchievementUnlocks is NetworkResponse.Success)

            assertNotNull((getAchievementUnlocks as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getClaims response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val getClaims: NetworkResponse<GetClaims.Response, ErrorResponse> = api.getClaims(
                claimKind = 2
            )

            assert(getClaims is NetworkResponse.Success)

            assertNotNull((getClaims as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getActiveClaims response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val getActiveClaims: NetworkResponse<GetClaims.Response, ErrorResponse> = api.getActiveClaims()

            assert(getActiveClaims is NetworkResponse.Success)

            assertNotNull((getActiveClaims as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getRecentGameAwards response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val getRecentGameAwards: NetworkResponse<GetRecentGameAwards.Response, ErrorResponse> = api.getRecentGameAwards()

            assert(getRecentGameAwards is NetworkResponse.Success)

            assertNotNull((getRecentGameAwards as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getAchievementOfTheWeek response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val getAchievementOfTheWeek: NetworkResponse<GetAchievementOfTheWeek.Response, ErrorResponse> = api.getAchievementOfTheWeek()

            assert(getAchievementOfTheWeek is NetworkResponse.Success)

            assertNotNull((getAchievementOfTheWeek as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getTicket response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val getTicket: NetworkResponse<GetTicketData.Response, ErrorResponse> = api.getTicket(
                ticketId = 12345
            )

            assert(getTicket is NetworkResponse.Success)

            assertNotNull((getTicket as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getMostTicketedGames response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val getTicket: NetworkResponse<GetMostTicketedGames.Response, ErrorResponse> = api.getMostTicketedGames()

            assert(getTicket is NetworkResponse.Success)

            assertNotNull((getTicket as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getMostRecentTickets response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val getMostRecentTickets: NetworkResponse<GetMostRecentTickets.Response, ErrorResponse> = api.getMostRecentTickets()

            assert(getMostRecentTickets is NetworkResponse.Success)

            assertNotNull((getMostRecentTickets as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getGameTicketStats response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val getGameTicketStats: NetworkResponse<GetGameTicketStats.Response, ErrorResponse> = api.getGameTicketStats(
                gameId = 14402
            )

            assert(getGameTicketStats is NetworkResponse.Success)

            assertNotNull((getGameTicketStats as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getDeveloperTicketStats response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val getDeveloperTicketStats: NetworkResponse<GetDeveloperTicketStats.Response, ErrorResponse> = api.getDeveloperTicketStats(
                username = "xelnia"
            )

            assert(getDeveloperTicketStats is NetworkResponse.Success)

            assertNotNull((getDeveloperTicketStats as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getAchievementTicketStats response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val getAchievementTicketStats: NetworkResponse<GetAchievementTicketStats.Response, ErrorResponse> = api.getAchievementTicketStats(
                achievementId = 12345
            )

            assert(getAchievementTicketStats is NetworkResponse.Success)

            assertNotNull((getAchievementTicketStats as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getCommentsOnUserWall response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val comments: NetworkResponse<GetComments.Response, ErrorResponse> = api.getCommentsOnUserWall(
                username = "MaxMilyin"
            )

            assert(comments is NetworkResponse.Success)

            assertNotNull((comments as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getCommentsOnGameWall response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val comments: NetworkResponse<GetComments.Response, ErrorResponse> = api.getCommentsOnGameWall(
                gameId = 27683
            )

            assert(comments is NetworkResponse.Success)

            assertNotNull((comments as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getCommentsOnAchievementWall response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val comments: NetworkResponse<GetComments.Response, ErrorResponse> = api.getCommentsOnAchievementWall(
                achievementId = 29733
            )

            assert(comments is NetworkResponse.Success)

            assertNotNull((comments as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getUserSetRequests response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val comments: NetworkResponse<GetUserSetRequests.Response, ErrorResponse> = api.getUserSetRequests(
                userId = "MaxMilyin"
            )

            assert(comments is NetworkResponse.Success)

            assertNotNull((comments as NetworkResponse.Success).body)
        }
    }

    @Test
    fun `check getUserGameLeaderboards response parser`() {

        runBlocking {

            // obtain mocked version of the API
            val api = createMockedApi()

            val comments: NetworkResponse<GetUserGameLeaderboard.Response, ErrorResponse> = api.getUserGameLeaderboards(
                gameId = 27683,
                userId = "MaxMilyin"
            )

            assert(comments is NetworkResponse.Success)

            assertNotNull((comments as NetworkResponse.Success).body)
        }
    }

    private fun createMockedApi(): RetroInterface {

        val client = RetroClient(RetroCredentials("<username>", "<web api key>"))
        val retro = client.retroClient

        val mockRetrofit: Retromock = Retromock.Builder()
            .defaultBodyFactory(ResourceBodyFactory())
            .retrofit(retro)
            .build()

        return mockRetrofit.create(RetroInterface::class.java)
    }
}
