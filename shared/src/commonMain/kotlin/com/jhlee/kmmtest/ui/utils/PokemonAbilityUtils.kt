package com.jhlee.kmmtest.ui.utils

import androidx.compose.ui.graphics.Color
import com.jhlee.kmmtest.ui.theme.Bug
import com.jhlee.kmmtest.ui.theme.Dark
import com.jhlee.kmmtest.ui.theme.Dragon
import com.jhlee.kmmtest.ui.theme.Electric
import com.jhlee.kmmtest.ui.theme.Fairy
import com.jhlee.kmmtest.ui.theme.Fighting
import com.jhlee.kmmtest.ui.theme.Fire
import com.jhlee.kmmtest.ui.theme.Flying
import com.jhlee.kmmtest.ui.theme.Ghost
import com.jhlee.kmmtest.ui.theme.Grass
import com.jhlee.kmmtest.ui.theme.Gray400
import com.jhlee.kmmtest.ui.theme.Ground
import com.jhlee.kmmtest.ui.theme.Ice
import com.jhlee.kmmtest.ui.theme.Poison
import com.jhlee.kmmtest.ui.theme.Psychic
import com.jhlee.kmmtest.ui.theme.Rock
import com.jhlee.kmmtest.ui.theme.Steel
import com.jhlee.kmmtest.ui.theme.Water

object PokemonAbilityUtils {

     fun getAbilityColor(name: String): Color = when(name) {
         "fighting" -> Fighting
         "flying" -> Flying
         "poison" -> Poison
         "ground" -> Ground
         "rock" -> Rock
         "bug" -> Bug
         "ghost" -> Ghost
         "steel" -> Steel
         "fire" -> Fire
         "water" -> Water
         "grass" -> Grass
         "electric" -> Electric
         "psychic" -> Psychic
         "ice" -> Ice
         "dragon" -> Dragon
         "fairy" -> Fairy
         "dark" -> Dark
         else -> Gray400
     }

}