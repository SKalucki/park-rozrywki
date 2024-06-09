const points = document.querySelectorAll('.point');
const linkOpis = document.querySelectorAll('th');
const elements = document.querySelectorAll('td');
const images = document.querySelectorAll('#linkIOpisPrzed img');
const descriptions = document.querySelectorAll('#linkIOpisPrzed div');

for (var i = 0; i < images.length; i++) {
    images[i].setAttribute('data-index', i + 1);
    descriptions[i].setAttribute('data-index', i + 1);
}

for (var i = 0; i < linkOpis.length; i++) {
    linkOpis[i].setAttribute('data-index', i + 1);
}


for (var i = 0; i < elements.length; i++) {
    elements[i].setAttribute('data-index', i + 1);
}

//
points.forEach(point => {
    point.addEventListener('mouseover', function() {
        point.style.backgroundColor = 'red';
        elements.item(point.getAttribute('data-index')-1).style.backgroundColor = "rgba(198, 0, 44,0.5)";

        let id = point.getAttribute('data-index');
        let image = document.querySelector(`#linkIOpisPrzed img[data-index='${id}']`);
        let description = document.querySelector(`#linkIOpisPrzed div[data-index='${id}']`);
        document.querySelector('#zdjPo').src = image.src;
        document.querySelector('#zdjPo').border = "black";
        document.querySelector('#opisPo').innerHTML = description.innerHTML;
    });

    point.addEventListener('mouseout', function() {
        point.style.backgroundColor = 'yellow';
        elements.item(point.getAttribute('data-index')-1).style.backgroundColor = null;
    });
});

elements.forEach(element => {
    element.addEventListener('mouseover', function() {
        const index = element.getAttribute('data-index');
        const point = document.querySelector(`.point[data-index='${index}']`);

        element.style.backgroundColor = "rgba(198, 0, 44,0.5)";
        point.style.backgroundColor = 'red';



    });
    const rows = document.querySelectorAll('td');

    rows.forEach(row => {
        row.addEventListener('mouseover', function() {
            const id = this.getAttribute('data-index');
            const image = document.querySelector(`#linkIOpisPrzed img[data-index="${id}"]`);
            const description = document.querySelector(`#linkIOpisPrzed div[data-index="${id}"]`);
            document.querySelector('#zdjPo').src = image.src;
            document.querySelector('#opisPo').textContent = description.textContent;
        });
    });

    element.addEventListener('mouseout', function() {
        const index = element.getAttribute('data-index');
        const point = document.querySelector(`.point[data-index='${index}']`);
        point.style.backgroundColor = 'yellow';
        element.style.backgroundColor = null;

    });
});
const defaultImage = document.querySelector('#linkIOpisPrzed img').src;
document.querySelector('#zdjPo').src = defaultImage;
const defaultText = document.querySelector('#linkIOpisPrzed div').textContent;
document.querySelector('#opisPo').textContent = defaultText;



