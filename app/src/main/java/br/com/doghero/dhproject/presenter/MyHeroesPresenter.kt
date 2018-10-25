package br.com.doghero.dhproject.presenter

import br.com.doghero.dhproject.api.ApiAnswer
import br.com.doghero.dhproject.utils.MyHeroes
import br.com.doghero.dhproject.view.myHeroes.MyHeroesViewContract

/**
 * Created by Gabriel Marcos on 20/10/2018
 */
class MyHeroesPresenter(private val myHeroesContract: MyHeroesViewContract) {

    fun getMyHeroes() {
        myHeroesContract.showProgress()
        myHeroesContract.setData(MyHeroes.build(ApiAnswer.getMyHeroes()))
    }

    fun hideProgress() {
        myHeroesContract.hideProgress()
    }
}