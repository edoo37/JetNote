package com.yasinsenel.jetnote.model

import java.time.Instant
import java.util.*
import java.time.LocalDateTime

data class Note(
    val id : UUID = UUID.randomUUID(),
    val title : String,
    val description: String,
    val entryDate: LocalDateTime = LocalDateTime.now()
)
