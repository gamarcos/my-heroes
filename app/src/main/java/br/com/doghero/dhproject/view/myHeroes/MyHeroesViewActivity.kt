package br.com.doghero.dhproject.view.myHeroes

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import br.com.doghero.dhproject.R
import br.com.doghero.dhproject.model.DataModel
import br.com.doghero.dhproject.presenter.MyHeroesPresenter
import br.com.doghero.dhproject.view.myHeroes.adapters.MyHeroesFavoritesAdapter
import br.com.doghero.dhproject.view.myHeroes.adapters.MyHeroesRecentsAdapter
import kotlinx.android.synthetic.main.activity_my_heroes.*

/**
 * Created by Gabriel Marcos on 20/10/2018
 */
class MyHeroesViewActivity: AppCompatActivity(), MyHeroesViewContract, MyHeroesRecentsAdapter.MyHeroesRecentsAdapterListener,
        MyHeroesFavoritesAdapter.MyHeroesFavoritesAdapterListener{

    private lateinit var myHeroesPresenter: MyHeroesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_heroes)

        myHeroesPresenter = MyHeroesPresenter(this)
    }

    override fun onResume() {
        super.onResume()
        myHeroesPresenter.getMyHeroes()
    }

    override fun showProgress() {
        myHeroesProgress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        myHeroesProgress.visibility = View.GONE
    }

    override fun setData(data: DataModel) {
        myHeroesPresenter.hideProgress()
        setupRecentsAdapter(data)
        setupFavoritesAdapter(data)
    }

    override fun setDataError(strError: String) {
        Toast.makeText(this, strError, Toast.LENGTH_LONG).show()
    }

    override fun onItemClick(adapterPosition: Int) {}

    override fun onTalkRecentsClicked() {}

    override fun onReserveRecentsClicked() {}

    override fun onTalkFavoriteClicked() {}

    override fun onReserveFavoriteClicked() {}

    fun setupRecentsAdapter(data: DataModel) {
        myHeroesRecentsRecyclerView.adapter = MyHeroesRecentsAdapter(this, this, data.recents)
        myHeroesRecentsRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    fun setupFavoritesAdapter(data: DataModel) {
        myHeroesFavoritesRecyclerView.adapter = MyHeroesFavoritesAdapter(this, this, data.favorites)
        myHeroesFavoritesRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}