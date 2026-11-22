# MediMate - Activitat 06: Menú i llistes

## Splash screen
SplashActivity és l'activity inicial (LAUNCHER). Mostra el logotip amb una animació
(fade + escala definida a res/anim/splash_logo.xml) i, quan l'animació acaba, obre MainActivity.

## Menú de navegació
MainActivity conté un FragmentContainerView i un BottomNavigationView amb el menú
menu_bottom_nav.xml. Un listener (setOnItemSelectedListener) substitueix el fragment segons
l'ítem triat: Avui, Medicació, Cuidador i Ajustos. Per defecte s'obre Avui.

## RecyclerView
Hi ha dues llistes: Medicació (item_medicament) i Avui (item_dose).
- Data class: Medicament i Dosi guarden les dades de cada fila.
- Holder: MedicamentViewHolder i DosiViewHolder guarden les referències a les vistes de la fila.
- Adapter: MedicamentsAdapter i DosiAdapter creen la fila (onCreateViewHolder, inflant el layout),
  hi posen les dades (onBindViewHolder) i diuen quants elements hi ha (getItemCount).
  Els items són de prova i es creen als fragments.

## Events
- Afegir: botó "Afegir medicament" mostra Toast i Log.
- Modificar: clic sobre un medicament mostra Toast i Log.
- Eliminar: clic llarg sobre un medicament mostra Toast i Log.
- Botó "Ho he près" de la llista d'Avui mostra Toast i Log.

## Accessibilitat
- El logotip té contentDescription.
- Els títols estan marcats com a encapçalament (accessibilityHeading).
- Els botons i les icones de navegació tenen una mida mínima tàctil de 48dp.
- Cada medicament de la llista té una descripció per a lectors de pantalla.

## Lliurament
ZIP del projecte, enllaç a GitHub i enllaç al vídeo.

## Tema fosc
A Ajustos hi ha un interruptor per canviar entre tema normal i fosc. El valor es guarda amb
SharedPreferences (classe MediMateApp) i s'aplica en arrencar l'app amb
AppCompatDelegate.setDefaultNightMode. Els colors del mode nit són a res/values-night/colors.xml.