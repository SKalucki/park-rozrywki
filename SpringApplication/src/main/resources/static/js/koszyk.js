//tablica przechowująca produkty w koszyku
var koszyk = [];
var koszykCena = document.getElementById("cenaCalkowita");

//funkcja obsługująca kliknięcie przycisku "Dodaj do koszyka"
function dodajDoKoszyka(nazwa, cena) {
    var produkt = {nazwa: nazwa, cena: cena};
    koszyk.push(produkt);
    aktualizujKoszyk();
}

//funkcja aktualizująca widok koszyka
function aktualizujKoszyk() {
    var koszykTabela = document.getElementById("koszykTabela");
    var koszykIle = document.getElementById("iloscProduktow");
    var koszykCena = document.getElementById("cenaCalkowita");
    var cenaCalkowita = 0;

    //usuwamy wszystkie wiersze z tabeli
    while (koszykTabela.rows.length > 0) {
        koszykTabela.deleteRow(0);
    }

    //wstawiamy produkty z koszyka do tabeli
    for (var i = 0; i < koszyk.length; i++) {
        var produkt = koszyk[i];
        var wiersz = koszykTabela.insertRow();
        var nazwa = wiersz.insertCell(0);
        var cena = wiersz.insertCell(1);
        nazwa.innerHTML = produkt.nazwa;
        cena.innerHTML = produkt.cena + " zł";
        cenaCalkowita += produkt.cena;
    }

    //aktualizujemy ilość i cenę całkowitą
    koszykIle.innerHTML = koszyk.length;
    koszykCena.innerHTML = cenaCalkowita;
}

//funkcja obsługująca kliknięcie przycisku "Opróżnij koszyk"
function oproznijKoszyk() {
    koszyk = [];
    aktualizujKoszyk();
}

//funkcja obsługująca kliknięcie przycisku "Zarezerwuj bilet"
function zarezerwuj() {
    if (koszyk.length == 0) {
        alert("Koszyk jest pusty!");
    } else if (koszyk.length == 1){
     var potwierdzenie = confirm("Czy na pewno chcesz zarezerwować " + koszyk.length + " bilet za kwotę " + koszykCena.innerHTML + " zł?");
            if (potwierdzenie) {
                modal.style.display = "block";
                koniec();
                oproznijKoszyk();
                }
    } else if (koszyk.length < 5 ){
    var potwierdzenie = confirm("Czy na pewno chcesz zarezerwować " + koszyk.length + " bilety za kwotę " + koszykCena.innerHTML + " zł?");
                if (potwierdzenie) {
                    modal.style.display = "block";
                    koniec();
                    oproznijKoszyk();
                    }
    } else {
        var potwierdzenie = confirm("Czy na pewno chcesz zarezerwować " + koszyk.length + " biletów za łączną kwotę " + koszykCena.innerHTML + " zł?");
        if (potwierdzenie) {
            modal.style.display = "block";
            koniec();
            oproznijKoszyk();
            }
        }
    }

//nasłuchiwanie na kliknięcie przycisków "Dodaj do koszyka"
var przyciskiDodaj = document.getElementsByClassName("dodajDoKoszyka");
    for (var i = 0; i < przyciskiDodaj.length; i++) {
            przyciskiDodaj[i].addEventListener("click", function() {
            var produkt = this.parentNode;
            var nazwa = produkt.getElementsByClassName("nazwaProduktu")[0].innerHTML;
            var cena = produkt.getElementsByClassName("cena")[0].innerHTML;
            //usuwamy słowo "Cena: " z ceny
            cena = parseInt(cena.substring(6));
            dodajDoKoszyka(nazwa, cena);
            });
        }

//nasłuchiwanie na kliknięcie przycisku "Opróżnij koszyk"
document.getElementById("oproznijKoszyk").addEventListener("click", oproznijKoszyk);

//nasłuchiwanie na kliknięcie przycisku "Zarezerwuj bilet"
document.getElementById("zaplac").addEventListener("click", zarezerwuj);



function koniec () {

    const iloscProduktow = document.getElementById("iloscProduktow");
    const cenaKoncowa = document.getElementById("cenaCalkowita");

    const iloscBiletow = document.getElementById("iloscBiletow");
    const caloscKwota = document.getElementById("kwotaCalosc");

    iloscBiletow.value = iloscProduktow.textContent;
    caloscKwota.value = cenaKoncowa.textContent;

    iloscBiletow.readOnly = true;
    caloscKwota.readOnly = true;
}



// Get the modal
var modal = document.getElementById("myModal");

// Get the button that opens the modal
var btn = document.getElementById("zaplac");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on the button, open the modal
btn.onclick = function() {
  modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
  modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}