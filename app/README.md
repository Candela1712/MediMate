# MediMate - Activitat 06: Menú i llistes

En aquesta activitat hem fet la pantalla inicial, el menú de baix, les llistes i el canvi de tema.

## Pantalla inicial (splash)
Quan obrim l'app, el primer que surt és `SplashActivity`. Mostra el logo de MediMate i fa una animació: el logo apareix poc a poc i es fa més gran. L'animació està a `res/anim/splash_logo.xml`. Quan acaba, s'obre la pantalla principal (`MainActivity`) i el splash es tanca.

## Menú de navegació
`MainActivity` té tres coses una sota l'altra: un espai per als fragments, el text legal i el menú de baix (`BottomNavigationView`).
El menú té quatre opcions: Avui, Medicació, Cuidador i Ajustos. Quan toquem una opció, el programa canvia el fragment que es veu a l'espai de dalt. Això ho fa la funció `carregarFragment`. Quan s'obre l'app, per defecte surt Avui.

## Llistes (RecyclerView)
Tenim dues llistes: Avui (les preses del dia) i Medicació (els medicaments).
Cada llista necessita tres parts:
- **Data class:** guarda les dades d'una fila. Tenim `Dosi` per a Avui i `Medicament` per a Medicació.
- **Holder:** guarda les vistes d'una fila (els textos i el botó) perquè no s'hagin de buscar cada vegada. Són `DosiViewHolder` i `MedicamentViewHolder`.
- **Adapter:** és el que connecta les dades amb la llista. Fa tres coses: crea una fila nova (`onCreateViewHolder`), hi posa les dades (`onBindViewHolder`) i diu quantes files hi ha (`getItemCount`). Són `DosiAdapter` i `MedicamentsAdapter`.

Els medicaments i les preses que es veuen són dades de prova que hem escrit als fragments.

## Events
Hem programat què passa quan l'usuari toca coses. En tots els casos surt un Toast (missatge curt a la pantalla) i s'escriu un Log:
- **Afegir:** botó "Afegir medicament".
- **Modificar:** tocar un medicament.
- **Eliminar:** mantenir premut un medicament.
- A Avui, el botó "Ho he près" també fa Toast i Log.

## Tema fosc
A Ajustos hi ha un interruptor per posar el tema fosc o el normal. Quan el canviem, l'app es torna a pintar amb el tema nou. L'opció es guarda amb `SharedPreferences`, i la classe `MediMateApp` la llegeix quan s'obre l'app, així no es perd. Els colors del mode fosc estan a `res/values-night/colors.xml`.

## Accessibilitat
Això és el que hem fet:
- El logo té una descripció (`contentDescription`) perquè la llegeixi el lector de pantalla.
- Els títols estan marcats com a encapçalament.
- Els botons i el menú tenen una mida prou gran per tocar-los bé (mínim 48dp).
- Cada medicament de la llista té una descripció amb el nom, el motiu i l'hora.

## Lliurament
- ZIP del projecte
- Enllaç a GitHub
- Enllaç al vídeo