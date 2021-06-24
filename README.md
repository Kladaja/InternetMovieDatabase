# InternetMovieDatabase

Alább az Adatbázisok nevű tárgyra készült projektmunkám bemutatása, illetve annak rövid használati útmutatója látható. A választott témának megfelelően az IMDb online információs adatbázis egy egyszerűsített változatát valósítottam meg.

## A program használata

A program különböző lekérdező és módosító funkciókat tesz lehetővé, tekintsük most át ezeket.

### Keresés

Kezdjük az alap nézettel, amely a már táblázatban kilistázott adatokkal fogad minket.

Amennyiben az általunk keresett film címéből egy részletet adunk meg a lent jelölt szövegbeviteli mezőben, majd ezután a keresés (**Find**) gombra kattintunk, a megjelenített táblázatban már csak azokat a filmeket fogjuk látni, amelyek címében szerepel az általunk megadott szöveg.

![search](https://github.com/Kladaja/InternetMovieDatabase/blob/main/documentation/Views/search.JPG)

### Törlés

Egy másik hasznos funkció amellyel ezen az oldalon találkozhatunk a törlés, amelyet természetesen a törlés (**Delete**) gombbal tudunk aktiválni.

Amennyiben meg szeretnénk szabadulni egy filmtől, a fenti táblázatból ki tudjuk választani az azonosítóját, majd ezt az azonosítót a szövegbeviteli mezőben megadva, a gombra kattintva el is távolíthatjuk az adatbázisunkból.

![delete](https://github.com/Kladaja/InternetMovieDatabase/blob/main/documentation/Views/delete.JPG)

### Szerkesztés

Egy másik fontos funkció az adatbázisban levő adatok módosítása, amit a szerkesztés (**Edit**) gomb segítségével tudunk végrehajtani. A gombra kattintva egy új ablak jelenik meg a képernyőn, ahova a módosítani kívánt adatokat tudjuk beírni.

**FONTOS**, hogy az azonosítókat nem tudjuk módosítani. Az ennek szánt szövegbeviteli mező arra szolgál, hogy ezen keresztül tudjuk elérni azt a rekordot, amit módosítani szeretnénk. Az azonosítón kívül viszont minden adatot szerkeszthetünk.

![edit](https://github.com/Kladaja/InternetMovieDatabase/blob/main/documentation/Views/edit.JPG)

A szerkesztés gombra kattintva visszatérünk az eredeti ablakhoz, ahol a már módosított adatok szerepelnek a táblázatban.

### Összetett keresés

Amennyiben egy adott kategóriáról összetettebb lekérdezéseket szeretnénk végrehajtani, akkor választhatjuk az összetett keresés (**Advanced search**) opciót.
Egy újabb felugró ablak fog megjelenni előttünk, amely már több keresésre szánt beviteli mezőt kínál.

Nem szükséges az összes mezőt kitölteni ahhoz, hogy keresést tudjunk végrehajtani, viszont amennyiben rendelkezünk a szükséges információkkal, és egyértelműen meg szeretnénk kapni az általunk keresett filmet, akkor természetesen akár az összes tulajdonságot megadhatjuk.

![advanced_search](https://github.com/Kladaja/InternetMovieDatabase/blob/main/documentation/Views/advanced_search.JPG)

A fenti ábrán például az olyan filmeket listáztuk ki, amelyek címében szerepel „T” betű, a műfajában részszóként van jelen a „rom”, illetve a szereplői között szerepel egy „Leo” nevű színész.

A keresés végrehajtása után természetesen megjelent a táblázatban a megfelelő találat.

### Kapcsolatok létrehozása

Ugyanezen az oldalon szintén lehetőségünk van adatmanipulációra, amely hasonlóan működik, mint az előző leírásban.

Szintén a témákhoz tartozó fő oldalakról érhetjük el a különböző, egymással kapcsolatban levő adatokat.

A filmek (**Movies**) kezdőlapjáról a színészek hozzáadása (**Add actors to movies**) gomb segítségével egy új ablak nyílik meg, amelyen keresztül egyszerre van lehetőségünk a filmek és a színészek között keresgélni.

Amennyiben egy film és egy színész között szeretnénk szereplési viszonyt kialakítani, azt a képernyő jobb alsó sarkában levő szövegbeviteli mezők, illetve a hozzáadás (**Add**) gomb segítségével tudjuk megtenni.

![add_actors_to_movies](https://github.com/Kladaja/InternetMovieDatabase/blob/main/documentation/Views/add_actor_to_movie.JPG)


*A program részletesebb ismertetése a **documentation** mappában a **doc.pdf** fájlban található.*
