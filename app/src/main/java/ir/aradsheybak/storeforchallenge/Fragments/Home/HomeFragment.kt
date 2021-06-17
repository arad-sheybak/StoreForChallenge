package ir.aradsheybak.storeforchallenge.Fragments.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import ir.aradsheybak.storeforchallenge.R
import ir.aradsheybak.storeforchallenge.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val imageList = ArrayList<SlideModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        imageList.add(
            SlideModel(
                R.drawable.ic_logo,
                "The animal population decreased by 58 percent in 42 years."
            )
        )
        imageList.add(
            SlideModel(
                R.drawable.ic_logo_login,
                "Elephants and tigers may become extinct."
            )
        )
        imageList.add(
            SlideModel(
                "https://www.gardendesign.com/pictures/images/675x529Max/site_3/helianthus-yellow-flower-pixabay_11863.jpg",
                "And people do that.",
                ScaleTypes.CENTER_CROP
            )
        )
        binding.sliderHome.setImageList(imageList)
        return binding.root
    }
//https://github.com/denzcoskun/ImageSlideshow ---> slider repository
}