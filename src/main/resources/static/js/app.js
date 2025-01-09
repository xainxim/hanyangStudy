
const body = document.body;
const audioPlayer = document.getElementById('audioPlayer');
const playPauseButton = document.getElementById('playPause');
let isPlaying = false;

const songs = {
  angry: "/audio/노래1.mp3", // 화남 노래
  happy: "/audio/노래2.mp3", // 기쁨 노래
  sad: "/audio/노래3.mp3"    // 슬픔 노래
};

const updatePlayPauseIcon = (isPlaying) => {
  const img = playPauseButton.querySelector('img');
  img.src = isPlaying ? '/images/멈춤.png' : './images/재생.png';
};

const playSong = (song) => {
  if (audioPlayer.src !== song) {
    audioPlayer.src = song;
  }
  audioPlayer.play();
  isPlaying = true;
  updatePlayPauseIcon(isPlaying);
};

const pauseSong = () => {
  audioPlayer.pause();
  isPlaying = false;
  updatePlayPauseIcon(isPlaying);
};

playPauseButton.addEventListener('click', () => {
  if (isPlaying) {
    pauseSong();
  } else {
    playSong(audioPlayer.src);
  }
});

document.getElementById('angry').addEventListener('click', () => {
  body.style.backgroundColor = '#FFE6E2';
  playSong(songs.angry);
});

document.getElementById('happy').addEventListener('click', () => {
  body.style.backgroundColor = '#FFF9DD';
  playSong(songs.happy);
});

document.getElementById('sad').addEventListener('click', () => {
  body.style.backgroundColor = '#E3F8FA';
  playSong(songs.sad);
});

document.getElementById('calendarIcon').addEventListener('click', () => {
  window.location.href = '/member/calendar';  // calendar.html은 당신의 HTML 파일명으로 변경
});








