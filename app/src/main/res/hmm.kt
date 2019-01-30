package java.tata.piyu.khichmeriphoto2

import android.content.Intent
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class Welcome : AppCompatActivity() {
    internal var mediaPlayer: MediaPlayer? = null
    internal var timer: Thread? = null

    override fun onPause() {
        super.onPause()
        mediaPlayer?.release()
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        mediaPlayer = MediaPlayer.create(this@Welcome, R.raw.sound)
        mediaPlayer.start()
        timer = object : Thread() {
            override fun run() {
                try {
                    Thread.sleep(10000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                } finally {
                    val on = Intent(applicationContext, MainActivity::class.java)
                    startActivity(on)
                }
            }
        }
        timer.start()
    }
}
