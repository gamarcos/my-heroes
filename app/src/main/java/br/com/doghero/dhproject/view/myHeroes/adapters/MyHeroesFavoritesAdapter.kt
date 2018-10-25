package br.com.doghero.dhproject.view.myHeroes.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.doghero.dhproject.R
import br.com.doghero.dhproject.images.ImageHelper
import br.com.doghero.dhproject.model.ResponseModel
import kotlinx.android.synthetic.main.adapter_heroes.view.*

/**
 * Created by Gabriel Marcos on 21/10/2018
 */
class MyHeroesFavoritesAdapter (private val context: Context,
                                private val listener: MyHeroesFavoritesAdapterListener,
                                private val favoritesContacts: ArrayList<ResponseModel>): RecyclerView.Adapter<MyHeroesFavoritesAdapter.ViewHolder>() {

    interface MyHeroesFavoritesAdapterListener {
        fun onTalkFavoriteClicked()
        fun onReserveFavoriteClicked()
    }
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.adapter_heroes, parent, false)
        return ViewHolder(view, listener, context)
    }

    override fun getItemCount(): Int {
        return favoritesContacts.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindView(favoritesContacts[position])
    }

    class ViewHolder(itemView: View, val listener: MyHeroesFavoritesAdapterListener, val context: Context ): RecyclerView.ViewHolder(itemView) {
        fun bindView(favoritesContact: ResponseModel) {

            itemView.myHeroLoveIcon.visibility = View.VISIBLE

            ImageHelper.loadImage(context, favoritesContact.user.imageUrl, R.drawable.dog_hero_splash, itemView.myHeroAvatarCircleImage)
            itemView.myHeroName.text = favoritesContact.user.firstName
            itemView.myHeroPrice.text = favoritesContact.price.toString()
            itemView.myHeroAddress.text = favoritesContact.neighborhood

            if (favoritesContact.isSuperHero) {
                itemView.myHeroWidget.visibility = View.VISIBLE
            } else {
                itemView.myHeroWidget.visibility = View.INVISIBLE
            }

            setupButtons()
        }

        private fun setupButtons() {
            var isLoved = false

            itemView.myHeroLoveIcon.setOnClickListener {
                if (isLoved){
                    itemView.myHeroLoveIcon.setImageResource(R.drawable.icon_like_border_vector_gray_battleship)
                    isLoved = false
                } else {
                    itemView.myHeroLoveIcon.setImageResource(R.drawable.icon_like_filled_vector_red)
                    isLoved = true
                }
            }

            itemView.myHeroesReserveButton.setOnClickListener {
                listener.onReserveFavoriteClicked()
            }
            itemView.myHeroesTalkButton.setOnClickListener {
                listener.onTalkFavoriteClicked()
            }
        }
    }

}