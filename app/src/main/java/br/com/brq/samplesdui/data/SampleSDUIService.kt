package br.com.brq.samplesdui.data

import com.github.codandotv.craftd.androidcore.data.model.base.SimplePropertiesResponse
import retrofit2.http.GET

interface SampleSDUIService {
    @GET("dynamic")
    suspend fun getDynamicExample() : List<SimplePropertiesResponse>
}