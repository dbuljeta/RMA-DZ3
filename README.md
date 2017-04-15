<h1> RMA-DZ3_TASKY</h1>

Zadatak ove zadaće je bio napraviti jednostavnu bazu podataka u koju bi korisnik unosio određene obaveze, zablješke. 
Korisniku je potrebno omogućiti unos zabilješki u bazu podataka te brisanje određenih zabilješki iz baze. 
Dodavanje u bazu se izvršava na način da korisnik klikne na gumb dodaj unutar MainActivtya, koji prilikom klika otvara Activity za dodavanje zabilješki/zadataka.
U tom Activity-u se unosi naslov zadatka, njegov opis te se određuje prioritet preko spinner-a koji sadrži tri moguća izbora koji su nakon toga unutar liste prikazni crvenom,žutom te zelenom bojom, 
klikom na gumb "Dodaj zadatak" unutar tog Activitya se dodaje zadatak u bazu podataka. Problem koji je nastao prilikom dodavanja zadatka,odnosno vraćanja u MainActivity
je taj da se trenutni listView odnosno MainActivity koji sadrži listView, nije ozvježavao, te tek ponovnim pokretanjem aplikacije su bili vidljivi,
unešeni zadaci. To sam riješio da sam prilikom svakog prelaska iz MainActivity u Activity za dodavanje zadatka, zatvorio MainActivity, te prilikom klika
gumb odnosno unešenog novog zadatka ponovno pokrenuo MainACtivity samim tim mu napravio i refresh. Brisanje određenog elementa unutar liste se vršio
dugim klikom na taj element(zadatak) unutar MainActivitya, promjena je vidljiva odmah.
Većinu stvari pri izradi ove aplikacije sam radio prema predlošku laboratorijskih vježbi(LV3) kolegija "Razvoj Mobilnih Aplikacija" u kojima je 
bio opisan primjer za unos knjiga, te na neke probleme na koje sam naišao prilikom izrade, pomoć sam našao na Stack Overflow.

 Unutar item_zadatak.xml sam dodao View na zadnjeg TextView, kako bi bila granica nekakva između svakog zadatka, odnosno svakog unešenog zadataka.
 http://stackoverflow.com/questions/3496269/how-do-i-put-a-border-around-an-android-textview
