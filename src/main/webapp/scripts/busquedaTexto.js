const searchInput = document.getElementById('searchInput');
const list = document.getElementById('list');
const contenText = document.querySelectorAll('#list #contenText');
const itemP = list.getElementsByTagName('p');

searchInput.addEventListener('input', function () {
  const searchValue = searchInput.value.toLowerCase();

  if (searchValue.trim() !== '') {
    for (let i = 0; i < itemP.length; i++) {
      const item = itemP[i];
      const itemName = item.textContent.toLowerCase();

      const keywords = itemName.split(' ');

      const match = keywords.some(keyword => keyword.includes(searchValue));

      if (match) {
        contenText[i].style.display = 'block';
      } else {
        contenText[i].style.display = 'none';
      }
    }
  } else {
    for (let i = 0; i < contenText.length; i++) {
      contenText[i].style.display = 'none';
    }
  }
});
