package ir.project.testbazdid.ui.sabtTakhallof

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.PermissionChecker
import androidx.core.content.PermissionChecker.checkSelfPermission
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import ir.project.testbazdid.R
import ir.project.testbazdid.databinding.FragmentSabtTakhallofBinding
import kotlinx.coroutines.launch
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import java.util.*


@AndroidEntryPoint
class SabtTakhallofFragment : Fragment(R.layout.fragment_sabt_takhallof) {
    private val sabtTakhallofViewModel: SabtTakhallofViewModel by viewModels()
    private lateinit var binding: FragmentSabtTakhallofBinding
    private var imageView: ImageView? = null
    private val CAMERA_PERMISSION_CODE = 1000
    private val IMAGE_CAPTURE_CODE = 1001
    private var imageUri: Uri? = null
    private var textView: TextView? = null
    private var body: MultipartBody.Part? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentSabtTakhallofBinding.bind(view)
        imageView = view.findViewById(R.id.image_viewer)
        textView = view.findViewById(R.id.nameImage)

        binding.buttonTakePicture.setOnClickListener {
            val permissionGranted = requestCameraPermission()
            if (permissionGranted) {
                // Open the camera interface
                openCameraInterface()
            }
        }

        binding.ConnectServer.setOnClickListener {
            val file = File("/storage/emulated/0/Download/4_5767096602611156975.jpg")
            val requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file)
            val body = MultipartBody.Part.createFormData("image", file.name, requestFile)
            sendData(body)
        }
    }

    private fun imageConvert(): MultipartBody.Part {
        val file = File("/storage/emulated/0/Download/Report.jpeg")
        val requestFile: RequestBody =
            RequestBody.create(MediaType.parse("multipart/form-data"), file)
        val body = MultipartBody.Part.createFormData("Pic21", file.name, requestFile)
        return body
    }
/*
  RequestBody requestFile =  RequestBody.create(MediaType.parse("multipart/form-data"), fileUpload);

     // MultipartBody.Part is used to send also the actual filename
     MultipartBody.Part body =  MultipartBody.Part.createFormData("methodName[headerData][relation][relative_image]", fileUpload.getName(), requestFile);

 */
    private fun sendData(body: MultipartBody.Part) {


        val MobRecord = "11"
        val MobRecordId = RequestBody.create(
            MediaType.parse("multipart/form-data"), "38768"
        )

        val UIDString = "UID"
        val UID = RequestBody.create(
            MediaType.parse("multipart/form-data"), "587"
        )

        val PWDString = "PWD"
        val PWD = RequestBody.create(
            MediaType.parse("multipart/form-data"), "687"
        )


        val srdate = RequestBody.create(
            MediaType.parse("multipart/form-data"), "2022/07/04 11:00:00"
        )

        val srDateFull =
            RequestBody.create(MediaType.parse("multipart/form-data"), "2022/07/04 11:00:00")

        val RID =
            RequestBody.create(MediaType.parse("multipart/form-data"), "545345")


        var multipartImage: MultipartBody.Part? = null

        try {
            lifecycleScope.launch {
                sabtTakhallofViewModel.testCreateSabt(
                    MobRecordId, UID, PWD, srdate, srDateFull, RID,
                    body,
                    body,
                    body,
                    body,
                    body,
                    body,
                    body,
                    body,
                    body,
                    body,
                    body,
                    body,
                )

            }
        } catch (e: Exception) {

        }
    }


    private fun requestCameraPermission(): Boolean {
        var permissionGranted = false

        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            val cameraPermissionNotGranted = checkSelfPermission(
                activity as Context,
                Manifest.permission.CAMERA
            ) == PermissionChecker.PERMISSION_DENIED
            if (cameraPermissionNotGranted) {
                val permission = arrayOf(Manifest.permission.CAMERA)

                // Display permission dialog
                requestPermissions(permission, CAMERA_PERMISSION_CODE)
            } else {
                // Permission already granted
                permissionGranted = true
            }
        } else {
            // Android version earlier than M -&gt; no need to request permission
            permissionGranted = true
        }

        return permissionGranted
    }


    @Deprecated("Deprecated in Java")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode === CAMERA_PERMISSION_CODE) {
            if (grantResults.size === 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission was granted
                openCameraInterface()
            } else {
                // Permission was denied
                showAlert("Camera permission was denied. Unable to take a picture")
            }
        }
    }


    private fun openCameraInterface() {
        val values = ContentValues()
        values.put(MediaStore.Images.Media.TITLE, "HELOOO")
        values.put(MediaStore.Images.Media.DESCRIPTION, "Des Test")
        imageUri =
            activity?.contentResolver?.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)

        // Create camera intent
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)

        // Launch intent
        startActivityForResult(intent, IMAGE_CAPTURE_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Callback from camera intent
        if (resultCode == Activity.RESULT_OK) {
            // Set image captured to image view

            val file = imageUri!!.path?.let { File(it) }
            val requestFile: RequestBody =
                RequestBody.create(MediaType.parse("multipart/form-data"), imageUri!!.encodedPath)
            body = MultipartBody.Part.createFormData("Pic21", file?.name, requestFile)
            sendData(body!!)

            imageView?.setImageURI(imageUri)
            textView?.text = imageUri!!.encodedPath


        } else {
            // Failed to take picture
            showAlert("Failed to take camera picture")
        }
    }

    fun showAlert(message: String) {
        val builder = AlertDialog.Builder(activity as Context)
        builder.setMessage(message)
        builder.setPositiveButton("OK", null)
        val dialog = builder.create()
        dialog.show()
    }

}

/*            val multipart = MultipartBody.Builder().setType(MultipartBody.FORM)
            multipart.apply {

                addFormDataPart("MobRecordId", "111")
                addFormDataPart("UID", "UID")
                addFormDataPart("PWD", "PWD")
                addFormDataPart("srdate", "srdate")
                addFormDataPart("srDateFull", "srDateFull")
                addFormDataPart("RID", "RID")
                addFormDataPart("pic11","")
                addFormDataPart("pic12","")
                addFormDataPart("pic13","")
                addFormDataPart("pic21","")
                addFormDataPart("pic22","")
                addFormDataPart("pic23","")
                addFormDataPart("pic31","")
                addFormDataPart("pic32","")
                addFormDataPart("pic33","")
                addFormDataPart("pic41","")
                addFormDataPart("pic42","")
                addFormDataPart("pic43","")
            }

            /*

 */
            */
