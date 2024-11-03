package com.hendrizzzz.dba.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.hendrizzzz.dba.view.HomeView

class DBALauncher : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Start HomeView as the main screen of the app
        val intent = Intent(this, HomeView::class.java)
        startActivity(intent)

        // Optionally, you could finish this activity so it doesn't remain in the back stack
        finish()
    }
}
