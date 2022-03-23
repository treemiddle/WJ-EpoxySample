package com.jay.wj_epoxysample.utils

import com.jay.wj_epoxysample.model.*

fun createFirstFeeds(): List<FirstFeed> {
    val list = mutableListOf<FirstFeed>().apply {
        for (i in 0..99) {
            add(
                FirstFeed(
                    firstText = "firstText: $i",
                    secondText = "secondText: $i",
                    thridText = "ThridText: $i"
                )
            )
        }
    }

    return list
}

fun createFirstHeader() = TextModel("first header title !")

fun createFirstHorizontal() = HorizontalModel(HorizontalType.FIRST)

fun createSecondHorizontal() = HorizontalModel(HorizontalType.SECOND)

fun createThirdHorizontal() = HorizontalModel(HorizontalType.THIRD)

fun createSecondHeader() = TextModel("second title !")

fun createThirdHeader() = TextModel("Third title !")

fun createSecondFeeds(): List<SecondFeed> {
    val list = mutableListOf<SecondFeed>().apply {
        for (i in 0..9) {
            add(SecondFeed(description = "description: $i",))
        }
    }

    return list
}

fun createThirdFeeds(): List<ThirdFeed> {
    val list = mutableListOf<ThirdFeed>().apply {
        for (i in 0..7) {
            add(ThirdFeed(title = "title: $i"))
        }
    }

    return list
}

fun createLastest(): List<TextModel> {
    val list = mutableListOf<TextModel>().apply {
        for (i in 0..99) {
            add(TextModel(title = "title: $i"))
        }
    }

    return list
}