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
package com.example.androiddevchallenge

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.model.puppies

@Composable
fun PuppyDetailScreen(id: Int?) {
    val puppy = puppies[id!! - 1]

    Card(
        Modifier
            .fillMaxWidth()
    ) {
        Column {
            Image(
                painter = painterResource(id = puppy.drawableRes),
                null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                contentScale = ContentScale.Crop
            )
            Text(text = "Name: ${puppy.name}")
            Text(text = "Age: ${puppy.age}")
            val genderEmoji = when (puppy.gender) {
                Puppy.Gender.Male -> "♂️"
                Puppy.Gender.Female -> "♀️"
            }
            Text(text = "Gender: $genderEmoji")
            Text(text = puppy.description)
        }
    }
}
