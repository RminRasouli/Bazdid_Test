package ir.project.testbazdid.ui.sabtTakhallof

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.project.testbazdid.data.model.sabtTakhallof.SabtTakhallofReqBody
import ir.project.testbazdid.data.model.sabtTakhallof.SabtTakhallofResBody
import ir.project.testbazdid.data.repository.Repository
import retrofit2.Response
import javax.inject.Inject

private const val TAG = "SabtTakhallofViewModel"
@HiltViewModel
class SabtTakhallofViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
    lateinit var responseOffi : Response<SabtTakhallofResBody>

    suspend fun createSabtTakhallof(
        MobRecordId: String,
        PWD: String,
        RID: String,
        UID: String,
        srDateFull: String,
        srdate: String
    ) {

        val sabtTakhallofReqBody = SabtTakhallofReqBody(
            MobRecordId, PWD, RID, UID, srDateFull, srdate
        )

        val response = repository.createSabtTakhallof(sabtTakhallofReqBody)
        Log.d("Network Req", " ViewModel createSabtTakhallof: ${response.isSuccessful} ")
        responseOffi = response
    }
}