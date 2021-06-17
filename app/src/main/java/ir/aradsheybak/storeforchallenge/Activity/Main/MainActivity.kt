package ir.aradsheybak.storeforchallenge.Activity.Main

import android.os.BaseBundle
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ir.aradsheybak.storeforchallenge.Components.BaseActivity
import ir.aradsheybak.storeforchallenge.Fragments.Categories.CategoriesFragment
import ir.aradsheybak.storeforchallenge.Fragments.Home.HomeFragment
import ir.aradsheybak.storeforchallenge.Fragments.Profile.ProfileFragment
import ir.aradsheybak.storeforchallenge.Fragments.ShoppingBasket.ShoppingBasketFragment
import ir.aradsheybak.storeforchallenge.R
import ir.aradsheybak.storeforchallenge.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    private lateinit var binding : ActivityMainBinding
    private var currentTab :String = "home"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        defineBinding()
        defaultPage()
        setOnClickListener()
    }

    private fun defineBinding(){
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setOnClickListener(){
        binding.bottomNavigation.llProfile.setOnClickListener {
            //when profile clicked
            profileClicked()
        }

        binding.bottomNavigation.llShoppingBasket.setOnClickListener {
            //when ShoppingBasket clicked
            shoppingBasketClicked()

        }
        binding.bottomNavigation.llCategories.setOnClickListener {
            //when categories clicked
            categoriesClicked()
        }

        binding.bottomNavigation.llHome.setOnClickListener {
            //when home clicked
            homeClicked()
        }
    }

    private fun defaultPage(){
        homeClicked()
    }

    private fun profileClicked(){
        deselectTabs(currentTab)
        currentTab = "profile"
        binding.bottomNavigation.ivProfile.setImageDrawable(getDrawable(R.drawable.ic_profile_gold))
        binding.bottomNavigation.tvProfile.setTextColor(getColor(R.color.gold))
        changeFragment(ProfileFragment())
    }

    private fun shoppingBasketClicked(){
        deselectTabs(currentTab)
        currentTab = "shoppingBasket"
        binding.bottomNavigation.ivShoppingBasket.setImageDrawable(getDrawable(R.drawable.ic_shopping_basket_gold))
        binding.bottomNavigation.tvShoppingBasket.setTextColor(getColor(R.color.gold))
        changeFragment(ShoppingBasketFragment())
    }

    private fun categoriesClicked(){
        deselectTabs(currentTab)
        currentTab = "categories"
        binding.bottomNavigation.ivCategories.setImageDrawable(getDrawable(R.drawable.ic_category_gold))
        binding.bottomNavigation.tvCategories.setTextColor(getColor(R.color.gold))
        changeFragment(CategoriesFragment())
    }

    private fun homeClicked(){
        deselectTabs(currentTab)
        currentTab = "home"
        binding.bottomNavigation.ivHome.setImageDrawable(getDrawable(R.drawable.ic_home_gold))
        binding.bottomNavigation.tvHome.setTextColor(getColor(R.color.gold))
        changeFragment(HomeFragment())

    }

    private fun deselectTabs(item:String){
        when(item){
            "home" ->{
                binding.bottomNavigation.ivHome.setImageDrawable(getDrawable(R.drawable.ic_home_white))
                binding.bottomNavigation.tvHome.setTextColor(getColor(R.color.white))

            }
            "categories" ->{
                binding.bottomNavigation.ivCategories.setImageDrawable(getDrawable(R.drawable.ic_category_white))
                binding.bottomNavigation.tvCategories.setTextColor(getColor(R.color.white))
            }
            "shoppingBasket" ->{
                binding.bottomNavigation.ivShoppingBasket.setImageDrawable(getDrawable(R.drawable.ic_shopping_basket_white))
                binding.bottomNavigation.tvShoppingBasket.setTextColor(getColor(R.color.white))
            }

            "profile"->{
                binding.bottomNavigation.ivProfile.setImageDrawable(getDrawable(R.drawable.ic_profile_white))
                binding.bottomNavigation.tvProfile.setTextColor(getColor(R.color.white))
            }
        }
    }

}