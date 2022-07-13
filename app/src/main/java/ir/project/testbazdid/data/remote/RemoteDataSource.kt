package ir.project.testbazdid.data.remote

import ir.project.testbazdid.data.model.sabtTakhallof.SabtTakhallofReqBody
import ir.project.testbazdid.data.model.sabtTakhallof.SabtTakhallofResBody
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response

interface RemoteDataSource {
suspend fun createSabtTakhallof(body : SabtTakhallofReqBody , multipartBody: MultipartBody.Part) : Response<SabtTakhallofResBody>
suspend fun testMultiPartServer(
    MobRecordId: RequestBody?,
    UID: RequestBody?,
    PWD: RequestBody?,
    srdate: RequestBody?,
    srDateFull: RequestBody?,
    RID: RequestBody?,
    pic11: MultipartBody.Part,
    pic12: MultipartBody.Part,
    pic13: MultipartBody.Part,
    pic21: MultipartBody.Part,
    pic22: MultipartBody.Part,
    pic23: MultipartBody.Part,
    pic31: MultipartBody.Part,
    pic32: MultipartBody.Part,
    pic33: MultipartBody.Part,
    pic41: MultipartBody.Part,
    pic42: MultipartBody.Part,
    pic43: MultipartBody.Part
):Response<Any>


suspend fun postIng( body : RequestBody):Response<Any>
}