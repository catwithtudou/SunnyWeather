package cn.zhengyua.suunyweather.logic.dao

import android.content.Context
import android.provider.Settings.Global.putString
import androidx.core.content.edit
import cn.zhengyua.suunyweather.SunnyWeatherApplication
import cn.zhengyua.suunyweather.logic.model.PlaceResponse
import com.google.gson.Gson

object PlaceDao {

    fun savePlace(place:PlaceResponse.Place){
        sharedPreferences().edit{
            putString("place",Gson().toJson(place))
        }
    }

    fun getSavedPlace():PlaceResponse.Place{
        val placeJson = sharedPreferences().getString("place","")
        return Gson().fromJson(placeJson, PlaceResponse.Place::class.java)
    }

    fun isPlaceSaved() = sharedPreferences().contains("place")


    private fun sharedPreferences() = SunnyWeatherApplication.context.getSharedPreferences("sunny_weather",
        Context.MODE_PRIVATE)
}