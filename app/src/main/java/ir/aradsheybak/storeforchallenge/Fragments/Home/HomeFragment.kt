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
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        addImageToSlider()
        setArrayImageToSlider()

        return binding.root
    }
//https://github.com/denzcoskun/ImageSlideshow ---> slider repository

    private fun addImageToSlider(){
        imageList.add(
            SlideModel(
                "https://d39l2hkdp2esp1.cloudfront.net/img/photo/147422/147422_00_2x.jpg", ScaleTypes.CENTER_CROP
            )
        )
        imageList.add(
            SlideModel(
                "https://www.gardeningknowhow.com/wp-content/uploads/2019/08/flower-color.jpg", ScaleTypes.CENTER_CROP
            )
        )
        imageList.add(
            SlideModel(
                "https://www.gardendesign.com/pictures/images/675x529Max/site_3/helianthus-yellow-flower-pixabay_11863.jpg",
                ScaleTypes.CENTER_CROP
            )
        )
    }

    private fun setArrayImageToSlider(){
        binding.sliderHome.setImageList(imageList)

    }


}