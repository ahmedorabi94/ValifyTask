package com.example.valifytask.presentation

import android.net.Uri
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.navigation.NavHostController
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.face.FaceDetection
import com.google.mlkit.vision.face.FaceDetectorOptions
import timber.log.Timber
import java.io.File


@Preview
@Composable
fun CaptureImageScreen(
    navController: NavHostController? = null,
    registerViewModel: RegisterViewModel = hiltViewModel()
) {


    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        val isSmiling = remember { mutableStateOf(false) }

        val context = LocalContext.current
        val lifecycleOwner = LocalLifecycleOwner.current
        val imageCapture = remember { ImageCapture.Builder().build() }

        AndroidView(
            factory = { ctx ->
                val previewView = PreviewView(ctx)
                val cameraProviderFuture = ProcessCameraProvider.getInstance(ctx)
                cameraProviderFuture.addListener({
                    val cameraProvider = cameraProviderFuture.get()
                    val preview = androidx.camera.core.Preview.Builder().build().also {
                        it.setSurfaceProvider(previewView.surfaceProvider)
                    }
                    val cameraSelector = CameraSelector.DEFAULT_FRONT_CAMERA
                    cameraProvider.bindToLifecycle(
                        lifecycleOwner,
                        cameraSelector,
                        preview,
                        imageCapture
                    )
                }, ContextCompat.getMainExecutor(ctx))
                previewView
            },
            modifier = Modifier.fillMaxSize()
        )


        Button(
            onClick = {
                val file = File(context.cacheDir, "captured_image.jpg")
                val outputOptions = ImageCapture.OutputFileOptions.Builder(file).build()
                imageCapture.takePicture(outputOptions, ContextCompat.getMainExecutor(context),
                    object : ImageCapture.OnImageSavedCallback {
                        override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
                            val image = InputImage.fromFilePath(context, Uri.fromFile(file))
                            detectSmile(image) { smileDetected ->
                                isSmiling.value = smileDetected
                                if (smileDetected){
                                    registerViewModel.bitmapToByteArray(image.bitmapInternal!!)
                                }
                            }
                        }

                        override fun onError(exception: ImageCaptureException) {
                            Timber.e("Error capturing image: ${exception.message}")
                        }
                    })
            },
            modifier = Modifier.align(Alignment.BottomCenter)

        ) {
            Text("Capture")
        }

        Text(
            text = if (isSmiling.value) "You're smiling! 😊" else "No smile detected.",
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.Center),
            color = Color.White
        )
    }
}

fun detectSmile(image: InputImage, onResult: (Boolean) -> Unit) {
    val options = FaceDetectorOptions.Builder()
        .setPerformanceMode(FaceDetectorOptions.PERFORMANCE_MODE_FAST)
        .setLandmarkMode(FaceDetectorOptions.LANDMARK_MODE_NONE)
        .setClassificationMode(FaceDetectorOptions.CLASSIFICATION_MODE_ALL)
        .build()

    val detector = FaceDetection.getClient(options)
    detector.process(image)
        .addOnSuccessListener { faces ->
            val isSmiling = faces.any { it.smilingProbability ?: 0f > 0.5f }
            onResult(isSmiling)
        }
        .addOnFailureListener { e ->
            Timber.e("Face detection failed: ${e.message}")
            onResult(false)
        }
}

