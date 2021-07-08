package se.micanonym.viaplaysample.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flowOn
import se.micanonym.viaplaysample.data.models.Id
import se.micanonym.viaplaysample.data.models.SectionDetail
import se.micanonym.viaplaysample.data.repositories.SectionRepository
import javax.inject.Inject

@HiltViewModel
class SectionDetailViewModel @Inject constructor(
    private val sectionRepository: SectionRepository
) : ViewModel() {

    fun sectionDetail(id: Id): LiveData<SectionDetail> =
        sectionRepository.getSectionDetailById(id)
            .filterNotNull()
            .flowOn(Dispatchers.IO)
            .asLiveData()
}
