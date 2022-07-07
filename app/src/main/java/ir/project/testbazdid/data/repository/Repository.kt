package ir.project.testbazdid.data.repository

import android.util.Log
import ir.project.testbazdid.data.model.sabtTakhallof.SabtTakhallofReqBody
import ir.project.testbazdid.data.model.sabtTakhallof.SabtTakhallofResBody
import ir.project.testbazdid.data.remote.RemoteDataSource
import ir.project.testbazdid.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository
@Inject constructor(
    @IoDispatcher
    private val dispatcher: CoroutineDispatcher,
    private val remoteDataSource: RemoteDataSource
){
    suspend fun createSabtTakhallof(body: SabtTakhallofReqBody) : Response<SabtTakhallofResBody> {
        val response =  remoteDataSource.createSabtTakhallof(body)
        Log.d("Network Req", " Repository createSabtTakhallof: ${response.isSuccessful} ")
        return response
    }

}




















