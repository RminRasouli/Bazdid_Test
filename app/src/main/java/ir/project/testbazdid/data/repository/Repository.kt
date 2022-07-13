package ir.project.testbazdid.data.repository

import android.util.Log
import ir.project.testbazdid.data.model.sabtTakhallof.SabtTakhallofReqBody
import ir.project.testbazdid.data.model.sabtTakhallof.SabtTakhallofResBody
import ir.project.testbazdid.data.remote.RemoteDataSource
import ir.project.testbazdid.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository
@Inject constructor(
    @IoDispatcher
    private val dispatcher: CoroutineDispatcher,
    private val remoteDataSource: RemoteDataSource
) {
    suspend fun createSabtTakhallof(
        body: SabtTakhallofReqBody,
        multipartBody: MultipartBody.Part
    ): Response<SabtTakhallofResBody> {
        val response = remoteDataSource.createSabtTakhallof(body, multipartBody)
        Log.d("Network Req", " Server Massage : ${response.code()} - ${response.message()} ")
        return response
    }

   suspend fun testCreateSabt(
       MobRecordId: RequestBody?,
       UID: RequestBody?,
       PWD: RequestBody?,
       srdate: RequestBody?,
       srDateFull: RequestBody?,
       RID: RequestBody?,
        pic11:MultipartBody.Part,
        pic12:MultipartBody.Part,
        pic13:MultipartBody.Part,
        pic21:MultipartBody.Part,
        pic22:MultipartBody.Part,
        pic23:MultipartBody.Part,
        pic31:MultipartBody.Part,
        pic32:MultipartBody.Part,
        pic33:MultipartBody.Part,
        pic41:MultipartBody.Part,
        pic42:MultipartBody.Part,
        pic43:MultipartBody.Part,
    ): Response<Any> {
        return remoteDataSource.testMultiPartServer(
            MobRecordId,
            UID,
            PWD,
            srdate,
            srDateFull,
            RID,
            pic11,
            pic12,
            pic13,
            pic21,
            pic22,
            pic23,
            pic31,
            pic32,
            pic33,
            pic41,
            pic42,
            pic43
        )
    }


    suspend fun postImg(body : RequestBody) : Response<Any>{
        return remoteDataSource.postIng(body)
    }

}




















