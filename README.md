

# Galerie des Vedettes de Cinéma

Ce projet consiste à créer une application mobile Android qui présente une galerie de vedettes de cinéma. L'application comporte un écran de démarrage animé, une liste de stars consultable, et la possibilité de filtrer par nom. La bibliothèque Picasso a été choisie pour le chargement des images en raison de ses performances et de sa simplicité.

## Objectifs du Projet

Ce projet a pour objectifs de :
- Réaliser différents types d'animations.
- Créer un écran de démarrage animé pour une application mobile.
- Comprendre l'utilisation de `RecyclerView`.
- Créer et gérer des menus dans l'application.
- Mettre en place un filtrage des données dans une `RecyclerView`.
- Utiliser des images cerclées (`CircularView`, `CircleImageView`).
- Maîtriser la bibliothèque **Picasso** pour le chargement des images.

## Fonctionnalités du Projet

- **Écran de démarrage animé** : Une animation comprenant une rotation de 360°, un redimensionnement à 50%, une translation verticale, et une disparition progressive.
- **Liste de stars** : Les utilisateurs peuvent consulter une liste de vedettes de cinéma et rechercher une star par son nom.
- **Filtrage** : Un système de filtrage des données permet d'afficher les stars correspondant à la recherche effectuée.

## Étapes du Projet

### Étape 1 : Création du Projet
- Création des packages `adapter`, `beans`, `dao`, et `service`.
- Création des activités `ListActivity` et `SplashActivity`.

### Étape 2 : Écran de Démarrage Animé
- Application d'animations au logo (rotation, redimensionnement, translation, disparition).
- Redirection vers `ListActivity` après 5 secondes.

### Étape 3 : Création de la Couche Métier
- Modélisation des stars avec la classe `Star` (id, name, img, star).
- Gestion des opérations CRUD avec une interface `IDao`.
- Gestion de la logique métier avec la classe `StarService`.

### Étape 4 : Présentation des Données avec `RecyclerView`
- Affichage de la liste des stars avec un `RecyclerView`.
- Utilisation de la bibliothèque **Picasso** pour charger les images des stars.

### Étape 5 : Filtrage des Données
- Implémentation d'un filtrage via une interface `Filterable` dans l'adapter.
- Recherche des stars par nom grâce à un `SearchView` dans la barre de menu.

### Étape 6 : Gestion des Menus
- Ajout d'un menu avec une icône de recherche pour afficher les résultats filtrés dans le `RecyclerView`.

## Bibliothèques Utilisées

### 1. **Picasso**
- Préférence : Simple à utiliser, idéal pour des chargements d'images légers et rapides, avec une gestion automatique de la mise en cache.
- [Documentation Picasso](https://square.github.io/picasso/)

### 2. **Glide**
- Préférence : Efficace pour le chargement d'images volumineuses, mais légèrement moins performant que Picasso dans notre contexte.
- [Documentation Glide](https://github.com/bumptech/glide)

### 3. **Fresco**
- Préférence : Excellente gestion de la mémoire pour les images de grande taille et support natif des images WebP et des GIFs.
- [Documentation Fresco](https://frescolib.org/)

### 4. **Coil**
- Préférence : Conçu pour être moderne et léger, avec une intégration facile dans Kotlin.
- [Documentation Coil](https://coil-kt.github.io/coil/)

### 5. **Android-Gif-Drawable**
- Préférence : Idéal pour le rendu fluide des GIFs animés avec une bonne gestion de la mémoire.
- [Documentation Android-Gif-Drawable](https://github.com/koral--/android-gif-drawable)

## Choix de Picasso

Picasso a été choisi comme solution de chargement d'images pour ce projet en raison de :
- Sa **simplicité d'utilisation**.
- Sa **gestion automatique de la mise en cache**.
- Des **performances adaptées** à notre besoin spécifique pour des tâches de chargement d'images sans transformations lourdes.

## Mesure du Temps de Chargement des Images

Nous avons mesuré et affiché le **temps de chargement des images** avec Picasso pour chaque image chargée. Voici un exemple de code permettant cette mesure :

```java
long startTime = System.currentTimeMillis();
Picasso.get().load(url).into(imageView, new Callback() {
    @Override
    public void onSuccess() {
        long endTime = System.currentTimeMillis();
        long loadTime = endTime - startTime;
        Toast.makeText(MainActivity.this, "Image loaded in " + loadTime + " ms", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onError(Exception e) {
        Toast.makeText(MainActivity.this, "Error loading image", Toast.LENGTH_SHORT).show();
    }
});
```

## Conclusion

Nous avons choisi **Picasso** pour ce projet en raison de sa **rapidité**, de sa **simplicité**, et de ses **performances optimisées** dans notre contexte. Glide et d'autres bibliothèques sont aussi des alternatives valides, mais pour ce cas précis, Picasso s'est révélé être le choix optimal.

---

Cela devrait structurer votre fichier README avec toutes les informations importantes sur le projet.
