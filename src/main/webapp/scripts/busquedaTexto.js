const searchInput = document.getElementById('searchInput');
const list = document.getElementById('list');
const contenText = document.querySelectorAll('#list #contenText');

searchInput.addEventListener('input', function () {
  const searchValue = searchInput.value.toLowerCase();

  if (searchValue.trim() !== '') {
    for (let i = 0; i < contenText.length; i++) {
      const item = contenText[i];
      const itemName = item.textContent.toLowerCase();

      const keywordsMatch = checkKeywords(itemName, searchValue);

      const phraseMatch = itemName.includes(searchValue);

      if (keywordsMatch || phraseMatch) {
        item.style.display = 'block';
      } else {
        item.style.display = 'none';
      }
    }
  } else {
    for (let i = 0; i < contenText.length; i++) {
      contenText[i].style.display = 'block';
    }
  }
});

// Función para verificar coincidencia de palabras clave
function checkKeywords(itemName, searchValue) {
  const words = itemName.split(' ');
  const palabrasFiltradas = words.filter(word => !palabrasExcluidas.includes(word));
  return palabrasFiltradas.includes(searchValue);
}

const palabrasExcluidas = [
    'del', 'y', 'e', 'ni', 'o', 'u', 'a', 
    'ante', 'bajo', 'con', 'contra', 'de', 
    'desde', 'en', 'entre', 'hacia', 'hasta', 
    'para', 'por', 'según', 'sin', 'sobre', 
    'tras', 'el', 'la', 'los', 'las', 'un', 
    'una', 'unos', 'unas'
];