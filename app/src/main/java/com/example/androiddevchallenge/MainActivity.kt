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

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.model.puppies
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                App()
            }
        }
    }
}

@Composable
fun PuppyActivity(navController: NavController) {
    Surface(Modifier.fillMaxWidth(), color = MaterialTheme.colors.background) {
        LazyColumn(
            Modifier.fillMaxWidth()
        ) {
            items(puppies) {
                Card(
                    Modifier
                        .fillMaxWidth()
                        .clickable(onClick = { navController.navigate("details/${it.id}") }),
                ) {
                    Row {
                        Image(
                            painter = painterResource(id = it.drawableRes),
                            null,
                            modifier = Modifier
                                .width(100.dp)
                                .height(100.dp),
                            contentScale = ContentScale.Crop
                        )
                        Column(Modifier.padding(start = 16.dp / 2)) {
                            Text(text = it.name, fontSize = 18.sp, fontWeight = FontWeight.Black)
                            Text(text = it.age)

                            val genderEmoji = when (it.gender) {
                                Puppy.Gender.Male -> "♂️"
                                Puppy.Gender.Female -> "♀️"
                            }
                            Text(text = "$genderEmoji ${it.gender}", fontSize = 14.sp)
                        }
                    }
                }
            }
        }
    }
}
