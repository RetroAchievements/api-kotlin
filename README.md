
<p align="center" dir="auto">
    <a href="https://retroachievements.org" rel="nofollow">
        <img src="https://raw.githubusercontent.com/RetroAchievements/RAWeb/master/public/assets/images/ra-icon.webp" width="200" alt="RetroAchievements Logo" style="max-width: 100%;"/>
    </a>
</p>
        
<h1 align="center">RetroAchievements Web API Client</h1>

## Installation

To begin, import the library using jitpack.io.

You can include jitpack in your `pom.xml` by adding the following jitpack repository:

```xml
<repository>
    <id>jitpack.io</id>
    <url>https://www.jitpack.io</url>
</repository>
```

Then add this `api-kotlin` dependency to your `pom.xml` project!

```xml
<dependency>    
    <groupId>com.github.RetroAchievements</groupId>    
    <artifactId>api-kotlin</artifactId>    
    <version>1.0.18</version>
</dependency>
```

## Usage

### Basic Usage

```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

// access the api interface in `api`
```

#### Achievements

<details>
<summary>GetAchievementUnlocks</summary>
<br>

> A call to this function will retrieve a list of users who have earned an achievement, targeted by the achievement's ID.

**Available Parameters**

| Name          | Type | Description                                          | Example |
|:--------------|:-----|:-----------------------------------------------------|:--------|
| achievementId | Int  | The achievement ID you'd like to query for           | 12345   |
| count         | Int  | number of records to return (default: 50, max: 500). | 10      |
| offset        | Int  | number of entries to skip.                           | 0       |

**Example**
```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

val response: NetworkResponse<GetAchievementUnlocks.Response, ErrorResponse> = api.getAchievementUnlocks(
    achievementId = 13876
)

if (response is NetworkResponse.Success) {
    // handle the data
    val achievements: GetAchievementUnlocks.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

#### Consoles

<details>
<summary>GetGameList</summary>
<br>

> A call to this function will retrieve the complete list of games for a specified console on the site, targeted by the console ID. If you do not know the console ID you're looking for, try using the all systems function.

> <span style='color: red;'>Warning</span>, it's recommended to cache these results, as it is subject to rate-limiting & security measures.

**Available Parameters**

| Name      | Type | Description                                          | Example |
|:----------|:-----|:-----------------------------------------------------|:--------|
| consoleId | Int  | The console ID you'd like to query for               | 1       |

**Example**
```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

val response: NetworkResponse<GetGameList.Response, ErrorResponse> = api.getGameList(
    consoleId = 1
)

if (response is NetworkResponse.Success) {
    // handle the data
    val gameList: GetGameList.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

<details>
<summary>GetConsoleIds</summary>
<br>

> A call to this function will retrieve the complete list of all system ID and name pairs on the site.

**Available Parameters**

| Name              | Type | Description                | Example | Default |
|:------------------|:-----|:---------------------------|:--------|:--------|
| activeSystemsOnly | Int  | Obtain active systems only | 1       | 0       |
| gameSystemsOnly   | Int  | Obtain game systems only   | 1       | 0       |

**Example**
```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

val response: NetworkResponse<GetConsoleID.Response, ErrorResponse> = api.getConsoleIds()

if (response is NetworkResponse.Success) {
    // handle the data
    val consoleIds: GetConsoleID.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

#### Events

<details>
<summary>GetAchievementOfTheWeek</summary>
<br>

> A call to this function will retrieve comprehensive metadata about the current Achievement of the Week.

**Example**
```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

val response: NetworkResponse<GetAchievementOfTheWeek.Response, ErrorResponse> = api.getAchievementOfTheWeek()

if (response is NetworkResponse.Success) {
    // handle the data
    val achievementOfTheWeek: GetAchievementOfTheWeek.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

#### Feed

<details>
<summary>GetActiveClaims</summary>
<br>

> A call to this function returns information about all (1000 max) active set claims.

**Example**
```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

val response: NetworkResponse<GetClaims.Response, ErrorResponse> = api.getActiveClaims()

if (response is NetworkResponse.Success) {
    // handle the data
    val claims: GetClaims.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

<details>
<summary>GetClaims</summary>
<br>

> A call to this function returns information about all (1000 max) set claims of a specified kind.

**Available Parameters**

| Name      | Type | Description                                                                        | Example |
|:----------|:-----|:-----------------------------------------------------------------------------------|:--------|
| claimKind | Int  | The desired claim kind: 1 (completed), 2 (dropped), or 3 (expired). Defaults to 1. | 1       |

**Example**
```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

val response: NetworkResponse<GetClaims.Response, ErrorResponse> = api.getClaims(
    claimKind = 2
)

if (response is NetworkResponse.Success) {
    // handle the data
    val claims: GetClaims.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

<details>
<summary>GetTopTenUsers</summary>
<br>

> A call to this function will retrieve the current top ten users on the site.

**Example**
```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

val response: NetworkResponse<GetTopTenUsers.Response, ErrorResponse> = api.getTopTenUsers()

if (response is NetworkResponse.Success) {
    // handle the data
    val topUsers: GetTopTenUsers.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

<details>
<summary>GetRecentGameAwards</summary>
<br>

> A call to this function will retrieve all recently granted game awards across the site's userbase.

**Example**
```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

val response: NetworkResponse<GetRecentGameAwards.Response, ErrorResponse> = api.getRecentGameAwards()

if (response is NetworkResponse.Success) {
    // handle the data
    val topUsers: GetRecentGameAwards.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

#### Games

<details>
<summary>GetAchievementDistribution</summary>
<br>

> A call to this function will retrieve a dictionary of the number of players who have earned a specific number of achievements for a given game ID. This function can be used to determine the total mastery count for a game, as well as how rare that overall mastery is.

**Available Parameters**

| Name     | Type | Description                                                            | Example |
|:---------|:-----|:-----------------------------------------------------------------------|:--------|
| gameId   | Long | The game ID you'd like to search for                                   | 14402   |
| hardcore | Int  | Fetching for hardcore achievements only (Hardcore-Only: 1, Default: 0) | 0       |

**Example**
```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

val response: NetworkResponse<GetAchievementDistribution.Response, ErrorResponse> = api.getAchievementDistribution(
    gameId = 14402,
    hardcore = 1
)

if (response is NetworkResponse.Success) {
    // handle the data
    val distribution: GetAchievementDistribution.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

<details>
<summary>GetAchievementCount</summary>
<br>

> A call to this function will retrieve the list of achievement IDs for a game, targeted by game ID. This can be useful if you'd like to quickly check how many achievements a particular game has. Using this, you can also detect if a game has received a revision. For example, if a game had 100 achievements last month and has 102 today, you know the game's achievement set has been revised.

**Available Parameters**

| Name   | Type | Description                          | Example |
|:-------|------|:-------------------------------------|:--------|
| gameId | Long | The game ID you'd like to search for | 14402   |

**Example**
```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

val response: NetworkResponse<GetAchievementCount.Response, ErrorResponse> = api.getAchievementCount(
    gameId = 14402
)

if (response is NetworkResponse.Success) {
    // handle the data
    val achievementCount: GetAchievementCount.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

<details>
<summary>GetGameExtended</summary>
<br>

> A call to this function will retrieve extended metadata about a game, targeted via its unique ID.

**Available Parameters**

| Name       | Type | Description                                                       | Example |
|:-----------|:-----|:------------------------------------------------------------------|:--------|
| gameId     | Long | The game ID you'd like to search for                              | 14402   |
| unofficial | Int  | Defaults to 3. Set to 5 to see Unofficial / demoted achievements. | 3       |

**Example**
```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

val response: NetworkResponse<GetGameExtended.Response, ErrorResponse> = api.getGameExtended(
    gameId = 14402
)

if (response is NetworkResponse.Success) {
    // handle the data
    val gameExtended: GetGameExtended.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

<details>
<summary>GetGameRankAndScore</summary>
<br>

> A call to this function will retrieve metadata about either the latest masters for a game, or the highest points earners for a game. The game is targeted via its unique ID.

**Available Parameters**

| Name    | Type | Description                                                        | Example |
|:--------|:-----|:-------------------------------------------------------------------|:--------|
| gameId  | Long | The game ID you'd like to search for                               | 14402   |
| masters | Int  | 1 for latest masters. 0 for non-master high scores. Defaults to 0. | 0       |

**Example**
```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

val response: NetworkResponse<GetGameRankAndScore.Response, ErrorResponse> = api.getGameRankAndScore(
    gameId = 14402
)

if (response is NetworkResponse.Success) {
    // handle the data
    val rankAndScore: GetGameRankAndScore.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

<details>
<summary>GetGame</summary>
<br>

> A call to this function will retrieve basic metadata about a game, targeted via its unique ID.

**Available Parameters**

| Name   | Type | Description                          | Example |
|:-------|:-----|:-------------------------------------|:--------|
| gameId | Long | The game ID you'd like to search for | 14402   |

**Example**
```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

val response: NetworkResponse<GetGame.Response, ErrorResponse> = api.getGame(
    gameId = 14402
)

if (response is NetworkResponse.Success) {
    // handle the data
    val game: GetGame.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

<details>
<summary>GetGameHashes</summary>
<br>

> A call to this function will retrieve the hashes linked to a game, targeted via its unique ID.

**Available Parameters**

| Name   | Type | Description         | Example |
|:-------|:-----|:--------------------|:--------|
| gameId | Long | The target game ID. | 14402   |

**Example**
```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

val response: NetworkResponse<GetGameHashes.Response, ErrorResponse> = api.getGameHashes(
    gameId = 14402
)

if (response is NetworkResponse.Success) {
    // handle the data
    val gameHashes: GetGameHashes.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

#### Leaderboards

<details>
<summary>GetGameLeaderboards</summary>
<br>

> A call to this function will retrieve a given game's list of leaderboards, targeted by the game's ID.

**Available Parameters**

| Name   | Type | Description                            | Example | Default |
|:-------|:-----|:---------------------------------------|:--------|:--------|
| gameId | Long | The target game ID.                    | 14402   |         |
| offset | Int  | number of entries to skip              | 100     | 0       |
| count  | Int  | number of entries to return (max: 500) | 50      | 100     |

**Example**
```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

val response: NetworkResponse<GetGameLeaderboards.Response, ErrorResponse> = api.getGameLeaderboards(
    gameId = 14402
)

if (response is NetworkResponse.Success) {
    // handle the data
    val gameLeaderboards: GetGameLeaderboards.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

<details>
<summary>GetLeaderboardEntries</summary>
<br>

> A call to this function will retrieve a given leaderboard's entries, targeted by its ID.

**Available Parameters**

| Name   | Type | Description                            | Example | Default |
|:-------|:-----|:---------------------------------------|:--------|:--------|
| gameId | Long | The target game ID.                    | 14402   |         |
| offset | Int  | number of entries to skip              | 100     | 0       |
| count  | Int  | number of entries to return (max: 500) | 50      | 100     |

**Example**
```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

val response: NetworkResponse<GetLeaderboardEntries.Response, ErrorResponse> = api.getLeaderboardEntries(
    gameId = 14402
)

if (response is NetworkResponse.Success) {
    // handle the data
    val leaderboardEntries: GetLeaderboardEntries.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

#### Tickets

<details>
<summary>GetDeveloperTicketStats</summary>
<br>

> A call to getTicketData() in this manner will retrieve ticket stats for a developer, targeted by that developer's site username.

**Available Parameters**

| Name     | Type   | Description                                                      | Example |
|:---------|:-------|:-----------------------------------------------------------------|:--------|
| username | String | The username of the user you'd like to retrieve ticket stats for | xelnia  |

**Example**
```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

val response: NetworkResponse<GetDeveloperTicketStats.Response, ErrorResponse> = api.getDeveloperTicketStats(
    username = "xelnia"
)

if (response is NetworkResponse.Success) {
    // handle the data
    val developerTicketStats: GetDeveloperTicketStats.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

<details>
<summary>GetAchievementTicketStats</summary>
<br>

> A call to getTicketData() in this manner will retrieve ticket stats for an achievement, targeted by that achievement's unique ID.

**Available Parameters**

| Name          | Type | Description                                                | Example |
|:--------------|:-----|:-----------------------------------------------------------|:--------|
| achievementId | Long | The achievement ID you'd like to retrieve ticket stats for | 12345   |

**Example**
```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

val response: NetworkResponse<GetAchievementTicketStats.Response, ErrorResponse> = api.getAchievementTicketStats(
    achievementId = 12345
)

if (response is NetworkResponse.Success) {
    // handle the data
    val achievementTicketStats: GetAchievementTicketStats.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

<details>
<summary>GetGameTicketStats</summary>
<br>

> A call to getTicketData() in this manner will retrieve the most recent ticket.

**Available Parameters**

| Name                                      | Type | Description                                                                | Example |
|:------------------------------------------|:-----|:---------------------------------------------------------------------------|:--------|
| gameId                                    | Long | The target game ID.                                                        | 14402   |
| shouldReturnTicketsList                   | Int  | Set to 1 if you want deep ticket metadata in the response's Tickets array. | 0       |
| isGettingTicketsForUnofficialAchievements | Int  | Set to 5 if you want ticket data for unofficial achievements.              | 0       |
| count                                     | Int  | Count, number of records to return (default: 10, max: 100).                | 0       |
| offset                                    | Int  | number of entries to skip (default: 0).                                    | 0       |

**Example**
```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

val response: NetworkResponse<GetGameTicketStats.Response, ErrorResponse> = api.getGameTicketStats(
    gameId = 14402
)

if (response is NetworkResponse.Success) {
    // handle the data
    val gameTicketStats: GetGameTicketStats.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

<details>
<summary>GetMostRecentTickets</summary>
<br>

> A call to getTicketData() in this manner will retrieve the most recent tickets

**Available Parameters**

| Name   | Type | Description                                                 | Example |
|:-------|:-----|:------------------------------------------------------------|:--------|
| count  | Int  | Count, number of records to return (default: 10, max: 100). | 10      |
| offset | Int  | number of entries to skip (default: 0).                     | 0       |

**Example**
```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

// you may pass an offset or count to its parameters
val response: NetworkResponse<GetMostRecentTickets.Response, ErrorResponse> = api.getMostRecentTickets()

if (response is NetworkResponse.Success) {
    // handle the data
    val tickets: GetMostRecentTickets.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

<details>
<summary>GetMostTicketedGames</summary>
<br>

> A call to getTicketData() in this manner will retrieve the games on the site with the highest count of opened achievement tickets.

**Available Parameters**

| Name   | Type | Description                                                   | Example |
|:-------|:-----|:--------------------------------------------------------------|:--------|
| count  | Int  | number of records to return (default: 10, max: 100).          | 10      |
| offset | Int  | number of entries to skip (default: 0).                       | 0       |
| type   | Int  | Set to 5 if you want ticket data for unofficial achievements. | 0       |

**Example**
```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

val response: NetworkResponse<GetMostTicketedGames.Response, ErrorResponse> = api.getMostTicketedGames()

if (response is NetworkResponse.Success) {
    // handle the data
    val mostTicketedGames: GetMostTicketedGames.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

<details>
<summary>GetTicket (by ID)</summary>
<br>

> A call to getTicketData() in this manner will retrieve ticket metadata information about a single achievement ticket, targeted by its ticket ID.

**Available Parameters**

| Name     | Type | Description                                                   | Example |
|:---------|:-----|:--------------------------------------------------------------|:--------|
| ticketId | Int  | The ticket ID you'd like to query for                         | 12345   |

**Example**
```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

val response: NetworkResponse<GetTicketData.Response, ErrorResponse> = api.getTicket(
    ticketId = 12345
)

if (response is NetworkResponse.Success) {
    // handle the data
    val ticket: GetTicketData.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

#### Users

<details>
<summary>GetAchievementsEarnedBetween</summary>
<br>

> A call to this function will retrieve a list of achievements unlocked by a given user between two given dates.

**Available Parameters**

| Name     | Type   | Description                                                   | Example    |
|:---------|:-------|:--------------------------------------------------------------|:-----------|
| fromDate | Date   | The starting date you'd like to query with                    | 2022-01-01 |
| toDate   | Date   | The ending date you'd like to query with                      | 2022-01-08 |
| username | String | The username of the user you'd like to query achievements for | Jamiras    |

**Example**
```kotlin
// create dates
val dateFormat = SimpleDateFormat("yyyy-MM-dd")
val fromDate: Date = dateFormat.parse("2022-01-01")
val toDate: Date = dateFormat.parse("2022-01-08")

val response: NetworkResponse<GetUserRecentAchievements.Response, ErrorResponse> = api.getAchievementsEarnedBetween(
    username = "Jamiras",
    fromDate = fromDate,
    toDate = toDate
)

if (response is NetworkResponse.Success) {
    // handle the data
    val achievements: GetUserRecentAchievements.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

<details>
<summary>GetAchievementsEarnedOnDay</summary>
<br>

> A call to this function will retrieve a list of achievements unlocked by a given user on a specified date.

**Available Parameters**

| Name     | Type   | Description                                                   | Example    |
|:---------|:-------|:--------------------------------------------------------------|:-----------|
| date     | Date   | The date of the day you'd like to query achievements at       | 2022-10-14 |
| username | String | The username of the user you'd like to query achievements for | Jamiras    |

**Example**
```kotlin
// create dates
val dateFormat = SimpleDateFormat("yyyy-MM-dd")
val date: Date = dateFormat.parse("2022-10-14")

val response: NetworkResponse<GetUserRecentAchievements.Response, ErrorResponse> = api.getAchievementsEarnedOnDay(
    username = "Jamiras",
    date = date
)

if (response is NetworkResponse.Success) {
    // handle the data
    val achievements: GetUserRecentAchievements.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

<details>
<summary>GetUserCompletedGames</summary>
<br>

> A call to this function will retrieve completion metadata about the games a given user has played. It returns two entries per each game: one for the softcore completion and one for the hardcore completion. These are designated by the hardcoreMode property on each completion object.

**Available Parameters**

| Name     | Type   | Description                                                      | Example   |
|:---------|:-------|:-----------------------------------------------------------------|:----------|
| username | String | The username of the user you'd like to query completed games for | MaxMilyin |

**Example**
```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

val response: NetworkResponse<GetUserCompletedGames.Response, ErrorResponse> = api.getUserCompletedGames(
    username = "MaxMilyin",
)

if (response is NetworkResponse.Success) {
    // handle the data
    val completedGames: GetUserCompletedGames.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

<details>
<summary>GetUserWantToPlayList</summary>
<br>

> A call to this function will retrieve a given user's "Want to Play Games" list, targeted by their username. Results will only be returned if the target user is yourself, or if both you and the target user follow each other.

**Available Parameters**

| Name     | Type   | Description                                                      | Example   | Default |
|:---------|:-------|:-----------------------------------------------------------------|:----------|:--------|
| username | String | The username of the user you'd like to query completed games for | MaxMilyin |         |
| offset   | Int    | number of entries to skip                                        | 100       | 0       |
| count    | Int    | number of entries to return (max: 500)                           | 50        | 100     |

**Example**
```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

val response: NetworkResponse<GetUserWantToPlayList.Response, ErrorResponse> = api.getUserWantToPlayList(
    username = "MaxMilyin",
)

if (response is NetworkResponse.Success) {
    // handle the data
    val wantToPlayList: GetUserWantToPlayList.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

<details>
<summary>GetUserCompletionProgress</summary>
<br>

> A call to this function will retrieve a giver user's completion progress, targeted by their username.

**Available Parameters**

| Name       | Type   | Description                                                        | Example   |
|:-----------|:-------|:-------------------------------------------------------------------|:----------|
| username   | String | The username of the user you'd like to query game progressions for | MaxMilyin |
| maxRecords | Int    | number of records to return (default: 100, max: 500).              | 100       |
| offset     | Int    | Offset, number of entries to skip (default: 0).                    | 0         |

**Example**
```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

val response: NetworkResponse<GetUserCompletionProgress.Response, ErrorResponse> = api.getUserCompletionProgress(
    username = "MaxMilyin",
)

if (response is NetworkResponse.Success) {
    // handle the data
    val completionProgress: GetUserCompletionProgress.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

<details>
<summary>GetGameInfoAndUserProgress</summary>
<br>

> A call to this function will retrieve extended metadata about a game, in addition to a user's progress about that game. This is targeted via a game's unique ID and a given username.

**Available Parameters**

| Name     | Type   | Description                                                         | Example   |
|:---------|:-------|:--------------------------------------------------------------------|:----------|
| username | String | The username of the user you'd like to query game progressions for. | MaxMilyin |
| gameId   | Long   | The target game ID.                                                 | 14402     |

**Example**
```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

val response: NetworkResponse<GetGameInfoAndUserProgress.Response, ErrorResponse> = api.getGameInfoAndUserProgress(
    username = "MaxMilyin",
    gameId = 14402
)

if (response is NetworkResponse.Success) {
    // handle the data
    val gameInfoAndUserProgress: GetGameInfoAndUserProgress.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

<details>
<summary>GetUserClaims</summary>
<br>

> A call to this function will retrieve a list of achievement set claims made over the lifetime of a given user, targeted by their username.

**Available Parameters**

| Name     | Type   | Description                                              | Example   |
|:---------|:-------|:---------------------------------------------------------|:----------|
| username | String | The username of the user you'd like to query claims for. | MaxMilyin |

**Example**
```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

val response: NetworkResponse<GetUserClaims.Response, ErrorResponse> = api.getUserClaims(
    username = "Jamiras"
)

if (response is NetworkResponse.Success) {
    // handle the data
    val claims: GetUserClaims.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

<details>
<summary>GetUserGameRankAndScore</summary>
<br>

> A call to this function will retrieve metadata about how a given user has performed/ranked on a given game, targeted by game ID.

**Available Parameters**

| Name     | Type   | Description                                                | Example   |
|:---------|:-------|:-----------------------------------------------------------|:----------|
| username | String | The username of the user you'd like to query metadata for. | MaxMilyin |
| gameId   | Long   | The target game ID.                                        | 14402     |

**Example**
```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

val response: NetworkResponse<GetUserGameRankAndScore.Response, ErrorResponse> = api.getUserGameRankAndScore(
    username = "xelnia",
    gameId = 14402
)

if (response is NetworkResponse.Success) {
    // handle the data
    val userGameRankAndScore: GetUserGameRankAndScore.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

<details>
<summary>GetUserPoints</summary>
<br>

> A call to this function will retrieve a given user's hardcore and softcore points.

**Available Parameters**

| Name     | Type   | Description                                              | Example   |
|:---------|:-------|:---------------------------------------------------------|:----------|
| username | String | The username of the user you'd like to query points for. | MaxMilyin |

**Example**
```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

val response: NetworkResponse<GetUserPoints.Response, ErrorResponse> = api.getUserPoints(
    username = "xelnia"
)

if (response is NetworkResponse.Success) {
    // handle the data
    val userPoints: GetUserPoints.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

<details>
<summary>GetUserProgress</summary>
<br>

> A call to this function will retrieve a given user's progress on a given list of games, targeted by game ID.

**Available Parameters**

| Name     | Type   | Description                                              | Example   |
|:---------|:-------|:---------------------------------------------------------|:----------|
| username | String | The username of the user you'd like to query points for. | MaxMilyin |
| gameId   | String | The target game ID. (separate list by ',' delimiter)     | 14402,1,2 |

**Example**
```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

val response: NetworkResponse<GetUserProgress.Response, ErrorResponse> = api.getUserProgress(
    username = "xelnia",
    gameId = "1,14402"
)

if (response is NetworkResponse.Success) {
    // handle the data
    val userProgress: GetUserProgress.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

<details>
<summary>GetUserRecentlyPlayedGames</summary>
<br>

> A call to this function will retrieve a list of a target user's recently played games, via their username.

**Available Parameters**

| Name     | Type   | Description                                                             | Example   |
|:---------|:-------|:------------------------------------------------------------------------|:----------|
| username | String | The username of the user you'd like to query recently played gamed for. | MaxMilyin |
| count    | Int    | number of records to return (default: 10, max: 50).                     | 10        |
| offset   | Int    | number of entries to skip (default: 0).                                 | 0         |

**Example**
```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

val response: NetworkResponse<GetUserRecentlyPlayedGames.Response, ErrorResponse> = api.getUserRecentlyPlayedGames(
    username = "xelnia",
)

if (response is NetworkResponse.Success) {
    // handle the data
    val recentlyPlayedGames: GetUserRecentlyPlayedGames.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

<details>
<summary>GetUserSummary</summary>
<br>

> A call to this function will retrieve summary information about a given user, targeted by username.

**Available Parameters**

| Name     | Type   | Description                                               | Example   |
|:---------|:-------|:----------------------------------------------------------|:----------|
| username | String | The username of the user you'd like to query summary for. | MaxMilyin |

**Example**
```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

val response: NetworkResponse<GetUserSummary.Response, ErrorResponse> = api.getUserSummary(
    username = "xelnia",
)

if (response is NetworkResponse.Success) {
    // handle the data
    val userProgress: GetUserSummary.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

<details>
<summary>GetUserProfile</summary>
<br>

> A call to this function will retrieve minimal user profile information, such as their ID, motto, most recent game ID, avatar, and points.

**Available Parameters**

| Name     | Type   | Description                                               | Example |
|:---------|:-------|:----------------------------------------------------------|:--------|
| username | String | The username of the user you'd like to get the profile of | xelnia  |

**Example**
```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

val response: NetworkResponse<GetUserProfile.Response, ErrorResponse> = api.getUserProfile(
    username = "xelnia",
)

if (response is NetworkResponse.Success) {
    // handle the data
    val userProfile: GetUserProfile.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

<details>
<summary>GetUserAwards</summary>
<br>

> A call to this function will retrieve metadata about the target user's site awards, via their username.

**Available Parameters**

| Name     | Type   | Description                                             | Example |
|:---------|:-------|:--------------------------------------------------------|:--------|
| username | String | The username of the user you'd like to get metadata for | xelnia  |

**Example**
```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

val response: NetworkResponse<GetUserAwards.Response, ErrorResponse> = api.getUserAwards(
    username = "xelnia",
)

if (response is NetworkResponse.Success) {
    // handle the data
    val awards: GetUserAwards.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

<details>
<summary>GetUsersIFollow</summary>
<br>

> A call to this function will retrieve a list of users that I follow.

**Available Parameters**

| Name   | Type | Description                            | Example | Default |
|:-------|:-----|:---------------------------------------|:--------|:--------|
| offset | Int  | number of entries to skip              | 100     | 0       |
| count  | Int  | number of entries to return (max: 500) | 50      | 100     |

**Example**
```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

val response: NetworkResponse<GetUsersIFollow.Response, ErrorResponse> = api.getUsersIFollow()

if (response is NetworkResponse.Success) {
    // handle the data
    val users: GetUsersIFollow.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

<details>
<summary>GetUsersFollowingMe</summary>
<br>

> A call to this function will retrieve a list of users that are following me.

**Available Parameters**

| Name   | Type | Description                            | Example | Default |
|:-------|:-----|:---------------------------------------|:--------|:--------|
| offset | Int  | number of entries to skip              | 100     | 0       |
| count  | Int  | number of entries to return (max: 500) | 50      | 100     |

**Example**
```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

val response: NetworkResponse<GetUsersFollowingMe.Response, ErrorResponse> = api.getUsersFollowingMe()

if (response is NetworkResponse.Success) {
    // handle the data
    val users: GetUsersFollowingMe.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

#### Comments

<details>
<summary>GetCommentsOnUserWall</summary>
<br>

> A call to this function returns comments of a specified user.

**Available Parameters**

| Name     | Type   | Description                                                      | Example   | Default |
|:---------|:-------|:-----------------------------------------------------------------|:----------|:--------|
| username | String | The username of the user you'd like to query completed games for | MaxMilyin |         |
| offset   | Int    | number of entries to skip                                        | 100       | 0       |
| count    | Int    | number of entries to return (max: 500)                           | 50        | 100     |

**Example**
```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

val response: NetworkResponse<GetComments.Response, ErrorResponse> = api.getCommentsOnUserWall(
    username = "MaxMilyin",
)

if (response is NetworkResponse.Success) {
    // handle the data
    val comments: GetComments.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

<details>
<summary>GetCommentsOnGameWall</summary>
<br>

> A call to this function returns comments of a specified game.

**Available Parameters**

| Name   | Type | Description                            | Example | Default |
|:-------|:-----|:---------------------------------------|:--------|:--------|
| gameId | Long | The game ID you'd like to search for   | 14402   |         |
| offset | Int  | number of entries to skip              | 100     | 0       |
| count  | Int  | number of entries to return (max: 500) | 50      | 100     |

**Example**
```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

val response: NetworkResponse<GetComments.Response, ErrorResponse> = api.getCommentsOnGameWall(
    gameId = 14402,
)

if (response is NetworkResponse.Success) {
    // handle the data
    val comments: GetComments.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

<details>
<summary>GetCommentsOnAchievementWall</summary>
<br>

> A call to this function returns comments of a specified achievement.

**Available Parameters**

| Name          | Type | Description                                | Example | Default |
|:--------------|:-----|:-------------------------------------------|:--------|:--------|
| achievementId | Long | The achievement ID you'd like to query for | 12345   |         |
| offset        | Int  | number of entries to skip                  | 100     | 0       |
| count         | Int  | number of entries to return (max: 500)     | 50      | 100     |

**Example**
```kotlin
val credentials = RetroCredentials("<username>", "<web api key>")
val api: RetroInterface = RetroClient(credentials).api

val response: NetworkResponse<GetComments.Response, ErrorResponse> = api.getCommentsOnAchievementWall(
    achievementId = 14402,
)

if (response is NetworkResponse.Success) {
    // handle the data
    val comments: GetComments.Response = response.body

} else if (response is NetworkResponse.Error) {
    // if the server returns an error it be found here
    val errorResponse: ErrorResponse? = response.body

    // if the api (locally) had an internal error, it'll be found here
    val internalError: Throwable? = response.error
}
```

</details>

## Testing

Apache maven must be correctly installed on the system.

To run tests for this project using Maven, execute the following command in your terminal:

```bash
mvn test
```

To compile the application, just run:

```bash
mvn clean package
```

## Contributing

See [Contribution Guidelines](CONTRIBUTING.md) and [Code of Conduct](CODE_OF_CONDUCT.md).

## Security Vulnerabilities

Please review [our security policy](../../security/policy).

## Credits

- [All Contributors](../../contributors)

## License

MIT License (MIT). See [License File](LICENSE.md).

