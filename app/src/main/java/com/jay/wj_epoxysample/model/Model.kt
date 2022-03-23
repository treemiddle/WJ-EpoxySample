package com.jay.wj_epoxysample.model

interface BaseModel

data class TextModel(val title: String) : BaseModel

data class HorizontalModel(val type: HorizontalType) : BaseModel


interface FeedModel

data class FirstFeed(
    val firstText: String,
    val secondText: String,
    val thridText: String
) : FeedModel

data class SecondFeed(val description: String) : FeedModel

data class ThirdFeed(val title: String) : FeedModel

enum class HorizontalType {
    FIRST,
    SECOND,
    THIRD
}