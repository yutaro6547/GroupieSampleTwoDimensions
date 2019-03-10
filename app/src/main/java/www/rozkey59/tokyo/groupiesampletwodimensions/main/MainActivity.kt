package www.rozkey59.tokyo.groupiesampletwodimensions.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import www.rozkey59.tokyo.groupiesampletwodimensions.MainApp
import www.rozkey59.tokyo.groupiesampletwodimensions.R
import www.rozkey59.tokyo.groupiesampletwodimensions.databinding.ActivityMainBinding
import www.rozkey59.tokyo.groupiesampletwodimensions.di.module.MainModule
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MainViewModel
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        (application as MainApp).appComponent.plus(MainModule(this)).inject(this)
        binding.vm = viewModel
        binding.fab.setOnClickListener {
            viewModel.getIchibaItems("appId", "メンズ")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
//                    Glide.with(this).load(it.Items[0].mediumImageUrls[0]).into(binding.image)
                }, {
                    Timber.e(it, it.message)
                })
        }
    }
}
