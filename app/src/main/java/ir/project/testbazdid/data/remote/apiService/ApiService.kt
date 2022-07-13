package ir.project.testbazdid.data.remote.apiService

import ir.project.testbazdid.data.model.sabtTakhallof.SabtTakhallofReqBody
import ir.project.testbazdid.data.model.sabtTakhallof.SabtTakhallofResBody
import ir.project.testbazdid.utils.Constanse.END_POINT_TOZINE
import ir.project.testbazdid.utils.Constanse.ND_POINT_TRY
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*


interface ApiService {

    @Multipart
    @POST(END_POINT_TOZINE)
    suspend fun createSabtTakhallof(
        @Part sabtTakhallofReqBody: SabtTakhallofReqBody,
        @Part("Pic21") pic21: MultipartBody.Part
    ): Response<SabtTakhallofResBody>

    /*MobRecordId
UID: String
PWD: String
srdate: Str
srDateFull:
RID : Int

     */

    @Multipart
    @POST(ND_POINT_TRY)
    suspend fun testCreateSabt(
        @Part("MobRecordId") MobRecordId: RequestBody?,
        @Part("UID") UID: RequestBody?,
        @Part("PWD") PWD: RequestBody?,
        @Part("srdate") srdate: RequestBody?,
        @Part("srDateFull") srDateFull: RequestBody?,
        @Part("RID") RID: RequestBody?,
        @Part pic11: MultipartBody.Part?,
        @Part pic12: MultipartBody.Part?,
        @Part pic13: MultipartBody.Part?,
        @Part pic21: MultipartBody.Part?,
        @Part pic22: MultipartBody.Part?,
        @Part pic23: MultipartBody.Part?,
        @Part pic31: MultipartBody.Part?,
        @Part pic32: MultipartBody.Part?,
        @Part pic33: MultipartBody.Part?,
        @Part pic41: MultipartBody.Part?,
        @Part pic42: MultipartBody.Part?,
        @Part pic43: MultipartBody.Part?,
    ): Response<Any>


    /*
            @Part("MobRecordId") MobRecordId: RequestBody?,
        @Part("UID") UID: RequestBody?,
        @Part("PWD") PWD: RequestBody?,
        @Part("srdate") srdate: RequestBody?,
        @Part("srDateFull") srDateFull: RequestBody?,
        @Part("RID") RID: RequestBody?,
     */
//    @Multipart
//    @POST("user/updateprofile")
//    fun updateProfile(
//        @Part("user_id") id: RequestBody?,
//        @Part("full_name") fullName: RequestBody?,
//        @Part image: MultipartBody.Part?,
//        @Part("other") other: RequestBody?
//    ): Observable<ResponseBody?>?

    @POST(ND_POINT_TRY)
    suspend fun postImg(@Body body: RequestBody): Response<Any>

    @GET(END_POINT_TOZINE)
    suspend fun createGetSabtTakhallof(
        @Query("MobRecordId") MobRecordId: Int,
        @Query("UID") UID: String,
        @Query("PWD") PWD: String,
        @Query("srdate") srdate: String,
        @Query("srDateFull") srDateFull: String,
        @Query("RID") RID: Int,
        @Part("Pic21") pic21: MultipartBody.Part
    )




    /*
      @Multipart
    @POST(ND_POINT_TRY)
    suspend fun testCreateSabt(
        @Part MobRecordId: MultipartBody.Part?,
        @Part UID: MultipartBody.Part?,
        @Part PWD: MultipartBody.Part?,
        @Part srdate: MultipartBody.Part?,
        @Part srDateFull: MultipartBody.Part?,
        @Part RID: MultipartBody.Part?,
        @Part pic11: MultipartBody.Part?,
        @Part pic12: MultipartBody.Part?,
        @Part pic13: MultipartBody.Part?,
        @Part pic21: MultipartBody.Part?,
        @Part pic22: MultipartBody.Part?,
        @Part pic23: MultipartBody.Part?,
        @Part pic31: MultipartBody.Part?,
        @Part pic32: MultipartBody.Part?,
        @Part pic33: MultipartBody.Part?,
        @Part pic41: MultipartBody.Part?,
        @Part pic42: MultipartBody.Part?,
        @Part pic43: MultipartBody.Part?,
    ): Response<Any>
     */

}