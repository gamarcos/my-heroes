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
 * Created by Gabriel Marcos on 20/10/2018
 */

class MyHeroesRecentsAdapter(private val context: Context,
                             private val listener: MyHeroesRecentsAdapterListener,
                             private val Contacts: ArrayList<ResponseModel>): RecyclerView.Adapter<MyHeroesRecentsAdapter.ViewHolder>() {

    interface MyHeroesRecentsAdapterListener {
        fun onTalkRecentsClicked()
        fun onReserveRecentsClicked()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.adapter_heroes, parent, false)
        return ViewHolder(view, listener, context)
    }

    override fun getItemCount(): Int {
        return Contacts.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindView(Contacts[position])
    }

    class ViewHolder(itemView: View, val listener: MyHeroesRecentsAdapterListener, val context: Context): RecyclerView.ViewHolder(itemView) {
        fun bindView(recentContact: ResponseModel) {

            ImageHelper.loadImage(context, recentContact.user.imageUrl, R.drawable.dog_hero_splash, itemView.myHeroAvatarCircleImage)
            itemView.myHeroName.text = recentContact.user.firstName
            itemView.myHeroPrice.text = recentContact.price.toString()
            itemView.myHeroAddress.text = recentContact.neighborhood

            if (recentContact.isSuperHero) {
                itemView.myHeroWidget.visibility = View.VISIBLE
            } else {
                itemView.myHeroWidget.visibility = View.INVISIBLE
            }

            setupButtons()
        }

        private fun setupButtons() {
            itemView.myHeroesReserveButton.setOnClickListener {
                listener.onReserveRecentsClicked()
            }
            itemView.myHeroesTalkButton.setOnClickListener {
                listener.onTalkRecentsClicked()
            }
        }
    }
}