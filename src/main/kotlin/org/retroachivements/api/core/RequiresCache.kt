package org.retroachivements.api.core

@RequiresOptIn(
     level = RequiresOptIn.Level.WARNING,
     message = "Consider aggressively caching this endpoint's response. The response size for some system IDs can be huge. The data doesn't change very often. Frequent calls to this endpoint may prompt us to look into your bandwidth usage. Refer to our usage guidelines for more details."
 )
 @Retention(AnnotationRetention.BINARY)
 @Target(
     AnnotationTarget.CLASS,
     AnnotationTarget.FUNCTION,
     AnnotationTarget.PROPERTY
 )
 annotation class RequiresCache
