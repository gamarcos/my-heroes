package br.com.doghero.dhproject.view.myHeroes

import br.com.doghero.dhproject.model.DataModel

/**
 * Created by Gabriel Marcos on 20/10/2018
 */
interface MyHeroesViewContract {
    fun showProgress()
    fun hideProgress()
    fun setData(data: DataModel)
    fun setDataError(strError: String)
    fun onItemClick(adapterPosition: Int)
}