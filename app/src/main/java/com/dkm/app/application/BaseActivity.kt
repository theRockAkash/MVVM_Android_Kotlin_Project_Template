package com.dkm.app.application

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.bumptech.glide.Glide
import com.dkm.app.R
import com.dkm.app.databinding.ZoomImageLayoutBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint

/**
 * @Created by akash on 11/21/2023.
 * Know more about author on https://akash.cloudemy.in
 */
@AndroidEntryPoint
open class BaseActivity : AppCompatActivity() {

    private lateinit var progressBar: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        progressBar = MaterialAlertDialogBuilder(this, R.style.Rounded_MaterialAlertDialog)
            .setCancelable(false)
            .setView(R.layout.loader_layout)
            .create()

    }

    fun showLoader() {
        progressBar.show()
        val window: Window? = progressBar.window
        if (window != null) {
            val layoutParams = WindowManager.LayoutParams()
            layoutParams.copyFrom(progressBar.window!!.attributes)
            layoutParams.width = 450
            layoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT
            layoutParams.dimAmount = 0f
            progressBar.window!!.attributes = layoutParams
        }

    }

    fun showFullImage(s: String?) {
        val binding = ZoomImageLayoutBinding.inflate(layoutInflater)
        val dialog = AlertDialog.Builder(this)
            .setCancelable(false)
            .setView(binding.root)
            .create()
        dialog.show()

        Glide.with(this)
            .load(s)
            .placeholder(R.drawable.loading)
            .error(R.drawable.error)
            .into(binding.ivZoom)
        binding.close.setOnClickListener {
            dialog.dismiss()
        }

    }

    fun hideLoader() {
        progressBar.dismiss()
    }

    override fun onDestroy() {
        progressBar.dismiss()
        super.onDestroy()
    }
}