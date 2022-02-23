package cn.zhengyua.suunyweather.ui.weather

import android.location.Location
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import cn.zhengyua.suunyweather.logic.Repository
import cn.zhengyua.suunyweather.logic.model.PlaceResponse
import kotlin.math.ln

class WeatherViewModel:ViewModel() {

    private val locationLiveData = MutableLiveData<PlaceResponse.Location>()

    var locationLng = ""
    var locationLat = ""
    var placeName = ""

    val weatherLiveData = Transformations.switchMap(locationLiveData) { location ->
        Repository.refreshWeather(location.lng, location.lat)
    }

    fun refreshWeather(lng:String,lat:String){
        locationLiveData.value = PlaceResponse.Location(lng,lat)
    }

}