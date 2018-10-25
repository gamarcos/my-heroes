package br.com.doghero.dhproject.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import br.com.doghero.dhproject.R
import br.com.doghero.dhproject.utils.CustomView
import br.com.doghero.dhproject.view.myHeroes.MyHeroesViewActivity

/**
 * Created by Gabriel Marcos on 20/10/2018
 */
class SplashActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        CustomView().setActionBarTransparent(this)

        Handler().postDelayed({
            startActivity(Intent(this, MyHeroesViewActivity::class.java))
            finish()
        }, 2000)
    }
}