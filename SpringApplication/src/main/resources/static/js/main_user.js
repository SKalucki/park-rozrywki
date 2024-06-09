const images2 = document.querySelectorAll('td img');
let currentImageIndex = 0;
const imageElement = document.querySelector('#zdjPokaz');

function changeImage() {
    imageElement.src = images2[currentImageIndex].src;
    imageElement.style.opacity = '0';
    imageElement.style.transition = 'all 2s ease-in-out';

    setTimeout(() => {
        imageElement.style.opacity = '1';
    }, 2000);

    setTimeout(() => {
        imageElement.style.opacity = '0';
        currentImageIndex = (currentImageIndex + 1) % images2.length;
        setTimeout(changeImage, 2000); // zmniejsz wartość argumentu
    }, 6000);


}
changeImage();