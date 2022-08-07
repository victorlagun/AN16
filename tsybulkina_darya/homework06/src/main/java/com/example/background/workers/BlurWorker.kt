package com.example.background.workers

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri

import android.text.TextUtils
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.example.background.*

private const val TAG = "BlurWorker"
class BlurWorker(ctx: Context, params: WorkerParameters) : Worker(ctx, params) {
    override fun doWork(): Result {
        val appContext = applicationContext
        makeStatusNotification("start", appContext)
        val resourceUri = inputData.getString(KEY_IMAGE_URI)

        sleep()

        return try {
            if (TextUtils.isEmpty(resourceUri)) {
                Log.e(TAG, "Invalid input uri")
                throw IllegalArgumentException("Invalid input uri")
            }
            val resolver = appContext.contentResolver
            val picture = BitmapFactory.decodeStream(resolver.openInputStream((Uri.parse(resourceUri))))
            val output = blurBitmap(picture, appContext)
            val uri = writeBitmapToFile(appContext, output)
            val outputData = workDataOf(KEY_IMAGE_URI to uri.toString())
            Result.success(outputData )
        } catch (t: Throwable) {
            Log.e(TAG, "Error applying blur")
            Result.failure()
        }
    }
}