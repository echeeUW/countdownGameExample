package edu.uw.echee.countdowngame

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

const val LOWEST_LEVEL = 0
const val HIGHEST_LEVEL = 100

sealed class GameStatus{
    object Player1Won: GameStatus()
    object Player2Won: GameStatus()
    object InProgress: GameStatus()
}


class CountdownViewModel: ViewModel() {
    private val _progress = MutableLiveData<Int>()
    private val _gameStatus = MutableLiveData<GameStatus>()

    val progress: LiveData<Int> = _progress
    val gameStatus: LiveData<GameStatus> = _gameStatus

    init {
        _gameStatus.value = GameStatus.InProgress
        _progress.value = 50
    }

    fun onAddProgress() {
        _progress.value = _progress.value!! + 1
        checkGameWon()
    }

    fun onLossProgress() {
        _progress.value = _progress.value!! - 1
        checkGameWon()
    }

    fun checkGameWon() {
        val currentProgress: Int = _progress.value ?: 50

        _gameStatus.value = when {
            currentProgress < LOWEST_LEVEL -> GameStatus.Player1Won
            currentProgress > HIGHEST_LEVEL -> GameStatus.Player2Won
            else -> GameStatus.InProgress
        }
    }



}
