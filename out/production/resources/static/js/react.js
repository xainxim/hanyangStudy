// HTML에서 뒤로가기 버튼에 이벤트 리스너 추가
document.querySelector('.save-button').addEventListener('click', () => {
  // 현재 캘린더 페이지를 숨기고 메인 페이지로 이동
  window.location.href = '/member/main'; // 메인 페이지의 파일명을 적절히 수정
});
