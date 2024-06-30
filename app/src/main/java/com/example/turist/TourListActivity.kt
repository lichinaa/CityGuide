package com.example.turist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import com.example.turist.databinding.ActivityTourListBinding

class TourListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTourListBinding
    private lateinit var listAdapter: ListAdapter
    private lateinit var listData: ListData
    var dataArrayList = ArrayList<ListData?>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTourListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageList = intArrayOf(
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
            R.drawable.img7
        )
        val includeList = intArrayOf(
            R.string.SkopjeTour,
            R.string.OldBazarTour,
            R.string.MatkaTour,
            R.string.VodnoTour,
            R.string.CulturalSkopjeTour,
            R.string.ArtSkopjeTour
        )
        val descList = intArrayOf(
            R.string.SkopjeDesc,
            R.string.OldBazarDesc,
            R.string.MatkaDesc,
            R.string.VodnoDesc,
            R.string.CulturalSkopjeDesc,
            R.string.ArtSkopjeDesc
        )
        val nameList = arrayOf("Day tour to Skopje", "Old Bazar Tour", "Canon Matka Tour","Vodno Mountain Tour", "Cultural and Historical Tour of Skopje","Art and Architecture Tour of Skopje")
        val timeList = arrayOf("2 hours", "3 hours", "5 hours", "2 hours", "2 hours", "2 hours")
        val priceList = arrayOf("30€", "20€", "50€", "25€", "35€", "30€")

        for (i in imageList.indices) {
            listData = ListData(
                nameList[i],
                timeList[i], includeList[i], descList[i], imageList[i], priceList[i]
            )
            dataArrayList.add(listData)
        }
        listAdapter = ListAdapter(this, dataArrayList)
        binding.listview.adapter = listAdapter
        binding.listview.isClickable = true
        binding.listview.onItemClickListener = OnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this@TourListActivity, DetailedActivity::class.java)
            intent.putExtra("name", nameList[i])
            intent.putExtra("time", timeList[i])
            intent.putExtra("include", includeList[i])
            intent.putExtra("desc", descList[i])
            intent.putExtra("image", imageList[i])
            intent.putExtra("price", priceList[i])
            startActivity(intent)
        }

    }
}