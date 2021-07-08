package se.micanonym.viaplaysample.ui.viewmodels

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import se.micanonym.viaplaysample.data.models.Section
import se.micanonym.viaplaysample.data.repositories.SectionRepository
import se.micanonym.viaplaysample.utils.Event
import javax.inject.Inject

@HiltViewModel
class SectionPageListViewModel @Inject constructor(
    private val sectionRepository: SectionRepository
) : ViewModel() {

    private val _spinner = MutableLiveData(false)
    val spinner: LiveData<Boolean> = _spinner

    private val _snackbar = MutableLiveData<String?>(null)
    val snackbar: LiveData<String?> = _snackbar

    val sections: LiveData<List<Section>> =
        sectionRepository
            .getSectionsFromDisk()
            .onEach { _spinner.postValue(false) }
            .asLiveData()

    private val _selectedSection = MutableLiveData<Event<Section>>()
    val selectedSection: LiveData<Event<Section>> = _selectedSection

    init {
        viewModelScope.launch(context = Dispatchers.IO) {
            sectionRepository.getSections()
                .onStart {
                    _spinner.postValue(true)
                }
                .catch { cause ->
                    _spinner.postValue(false)
                    _snackbar.postValue(cause.message)
                }
                .onCompletion {
                    _spinner.postValue(false)
                }
                .collect()
        }
    }

    fun onSnackbarWasShown() {
        _snackbar.postValue(null)
    }

    fun onDidSelectSection(section: Section) {
        _selectedSection.postValue(Event(section))
    }
}
