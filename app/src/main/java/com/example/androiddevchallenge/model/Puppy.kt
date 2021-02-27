/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import com.example.androiddevchallenge.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class Puppy(
    val id: Int,
    @DrawableRes val drawableRes: Int,
    val name: String,
    val age: String,
    val gender: Gender,
    val description: String
) : Parcelable {
    enum class Gender { Male, Female }
}

val puppies = listOf(
    Puppy(1, R.drawable.pic1, "Damon", "2month", Puppy.Gender.Female, "Zeluss ire in asopus!"),
    Puppy(2, R.drawable.pic2, "Casimir", "4month", Puppy.Gender.Male, "Cacula observares, tanquam altus uria."),
    Puppy(3, R.drawable.pic3, "Hastings", "1month", Puppy.Gender.Male, "Heu, fluctui!"),
    Puppy(4, R.drawable.pic4, "Sidney", "2month", Puppy.Gender.Female, "The master understands advice which is not psychic."),
    Puppy(5, R.drawable.pic5, "Neil", "3month", Puppy.Gender.Female, "Mash up the caviar with fluffy butter, thyme, green curry, and celery making sure to cover all of it.")
)
