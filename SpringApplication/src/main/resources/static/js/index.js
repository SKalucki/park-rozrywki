const images = document.querySelectorAll('td img');
let currentImageIndex = 0;
const imageElement = document.querySelector('#zdjPokaz');

function changeImage() {
    imageElement.src = images[currentImageIndex].src;
    imageElement.style.opacity = '0';
    imageElement.style.transition = 'all 2s ease-in-out';

    setTimeout(() => {
        imageElement.style.opacity = '1';
    }, 2000);

    setTimeout(() => {
        imageElement.style.opacity = '0';
        currentImageIndex = (currentImageIndex + 1) % images.length;
        setTimeout(changeImage, 2000); // zmniejsz wartość argumentu
    }, 4000);


}
changeImage();