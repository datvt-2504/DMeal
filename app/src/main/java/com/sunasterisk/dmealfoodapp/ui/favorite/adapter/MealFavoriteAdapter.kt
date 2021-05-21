package com.sunasterisk.dmealfoodapp.ui.favorite.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.sunasterisk.dmealfoodapp.base.BaseAdapter
import com.sunasterisk.dmealfoodapp.base.BaseViewHolder
import com.sunasterisk.dmealfoodapp.data.model.Meal
import com.sunasterisk.dmealfoodapp.databinding.ItemMealFavoriteBinding
import com.sunasterisk.dmealfoodapp.utils.loadImage

class MealFavoriteAdapter(private val onItemClick: (Meal) -> Unit) :
    BaseAdapter<Meal, MealFavoriteAdapter.MealFavoriteViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MealFavoriteViewHolder = MealFavoriteViewHolder(
        ItemMealFavoriteBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ), onItemClick
    )

    class MealFavoriteViewHolder(
        private val binding: ItemMealFavoriteBinding,
        onItemClick: (Meal) -> Unit
    ) : BaseViewHolder<Meal>(binding, onItemClick) {

        override fun onBindData(itemData: Meal) {
            super.onBindData(itemData)
            with(binding) {
                itemData.apply {
                    textNameMeal.text = name
                    itemData.image.let {
                        imageMeal.loadImage(it)
                    }
                }
            }
        }
    }
}
