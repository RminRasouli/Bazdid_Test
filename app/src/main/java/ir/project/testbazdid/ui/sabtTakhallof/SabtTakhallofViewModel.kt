package ir.project.testbazdid.ui.sabtTakhallof

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.project.testbazdid.data.model.sabtTakhallof.SabtTakhallofReqBody
import ir.project.testbazdid.data.model.sabtTakhallof.SabtTakhallofResBody
import ir.project.testbazdid.data.repository.Repository
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import javax.inject.Inject

private const val TAG = "SabtTakhallofViewModel"

@HiltViewModel
class SabtTakhallofViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    lateinit var responseOffi: Response<SabtTakhallofResBody>

    suspend fun createSabtTakhallof(
        MobRecordId: Int,
        PWD: String,
        RID: String,
        UID: String,
        srDateFull: String,
        srdate: Int,
        multipartBody: MultipartBody.Part
    ) {

        val sabtTakhallofReqBody = SabtTakhallofReqBody(
            MobRecordId, PWD, RID, UID, srDateFull, srdate
        )

        val response = repository.createSabtTakhallof(sabtTakhallofReqBody, multipartBody)
        responseOffi = response
    }

    suspend fun testCreateSabt(
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
        pic43: MultipartBody.Part,
    ) {
        val response = repository.testCreateSabt(MobRecordId,
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
            pic43)

        Log.d(TAG, "testCreateSabt: ${response.code()} ${response.message()} ${response.body()}")

    }


    suspend fun postImg(body: RequestBody): Response<Any> {
        val response = repository.postImg(body)
        Log.d(TAG, "postImg: ${response.isSuccessful} ${response.message()} ${response.code()}")
        return response
    }
}