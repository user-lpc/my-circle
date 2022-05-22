package com.mycircle.mvvm.vm.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.mycircle.base.ktx.launchIO
import com.mycircle.base.mvvm.vm.BaseViewModel
import com.mycircle.mvvm.m.home.HomeCommunityRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import javax.inject.Inject

@HiltViewModel
class HomeCommunityViewModel @Inject constructor(private val mRepository: HomeCommunityRepository) : BaseViewModel(){

    val infoData = MutableLiveData<String>()

    fun infoData() {
        launchIO {
            mRepository.getData()
                .catch { Log.d("qqq", "getData: $it") }
                .collect { infoData.postValue(it) }
        }
    }
}